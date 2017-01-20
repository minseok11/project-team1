package Y.shopping.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import Hwang.dao.BasketDao;
import Hwang.dto.BIDTO;
import Y.shopping.dao.CouponDao;
import Y.shopping.dao.CustomerInfoDao;
import Y.shopping.dao.ItemDao;
import Y.shopping.dao.PaymentDao;
import Y.shopping.dao.ReturnItemDao;
import Y.shopping.dao.StatisticDao;
import Y.shopping.dto.CouponSearchDTO;
import Y.shopping.dto.CreateCouponDTO;
import Y.shopping.dto.CustomerInfoDTO;
import Y.shopping.dto.DeliveryDTO;
import Y.shopping.dto.ItemDTO;
import Y.shopping.dto.PaymentDTO;
import Y.shopping.dto.PaymentResultDTO;
import Y.shopping.dto.ReturnItemDTO;
import Y.shopping.dto.StatisticDTO;

@WebServlet("/payment.do")
public class PaymentController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd.equals("insertTab")){
			insertTab(request,response);
		}else if(cmd.equals("insert")){
			insert(request,response);
		}else if(cmd.equals("delete")){
			delete(request,response);
		}else if(cmd.equals("list")){
			list(request,response);
		}else if(cmd.equals("itemReturn")){
			itemReturn(request,response);
		}else if(cmd.equals("paymentList")){
			paymentList(request,response);
		}
	}
	private void insertTab(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] buynum = request.getParameterValues("buyNum");
		
		System.out.println("insertTab");
		request.setCharacterEncoding("utf-8");
		//String code=request.getParameter("itemCode");
		String [] code= request.getParameterValues("itemCode");
		String [] count = request.getParameterValues("cnt");
		//String [] aaa = request.getParameterValues("choice");
		
		int [] cnt = null;
				
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		ItemDao idao=new ItemDao();
		ArrayList<ItemDTO> ilist = new ArrayList<>();
		ItemDTO idto = new ItemDTO();

		for(int i=0;i<code.length;i++){
			idto=idao.b_list(code[i]);
			System.out.println();
			ilist.add(idao.b_list(idto.getCode()));
			System.out.println(idto.getName());
		}
		
		CustomerInfoDao cdao=new CustomerInfoDao();
		ArrayList<CustomerInfoDTO> clist=cdao.userlist(id);
		CouponDao dao=new CouponDao();
		ArrayList<CouponSearchDTO> coupon=dao.list(id);
		request.setAttribute("itemCount", count);
		request.setAttribute("buynum", buynum);
		request.setAttribute("coupon", coupon);
		request.setAttribute("ilist", ilist);
		request.setAttribute("clist", clist);
		request.setAttribute("content", "/adminPage/layout/payment.jsp");
		request.getRequestDispatcher("/starter.do").forward(request, response);
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String coupon="�̻��";
		int totalPrice =Integer.parseInt(request.getParameter("totalPrice"));
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		int discount=0;
		if(request.getParameter("discount")!=null||!(request.getParameter("discount").equals(""))){
			discount=Integer.parseInt(request.getParameter("discount"));
		}
		CouponDao cdao=new CouponDao();
		String name=null;
		if(totalPrice>=100000){
			name="VIP";
		}else if(totalPrice>=200000){
			name="BLUE";
		}else if(totalPrice>=300000){
			name="VVIP";
		}else if(totalPrice>=400000){
			name="MANIA";
		}
		CreateCouponDTO dto=new CreateCouponDTO(0, name, id, null, null);
		CouponSearchDTO csdto=new CouponSearchDTO(0, name, id, discount, null, null);
		if(name!=null){
			cdao.c_insert(dto);
		}
		dto=cdao.getinfo(csdto);
		if(dto!=null){
			int cnum=dto.getCreateNum();
			cdao.update(cnum);
			if(request.getParameter("coupon")!=null || !coupon.equals(request.getParameter("coupon"))){
				coupon="���";	
			}
		}
		
		String[] code=request.getParameterValues("code");		
		String[] itemcost=request.getParameterValues("price");
		String[] retailPrice=request.getParameterValues("retail");
		String[] cnt=request.getParameterValues("cnt");
		PaymentDao dao=new PaymentDao();
		int a=dao.s_insert();
		//��������Է�
		DeliveryDTO ddto=new DeliveryDTO(0,
				request.getParameter("d_name"),
				request.getParameter("d_phoneNo"), 
				request	.getParameter("d_postNo"),
				request.getParameter("d_deliveryLoc"), 
				null,
				id);
		int n=dao.d_insert(ddto);
		
		int n2=0;
		for(int i=0;i<code.length;i++){
			PaymentDTO pdto=new PaymentDTO(
					0,
					Integer.parseInt(itemcost[i]),
					Integer.parseInt(retailPrice[i]),
					null,
					coupon,
					id,
					request.getParameterValues("code")[i],
					n,
					0,
					Integer.parseInt(cnt[i])
					);
			n2=dao.insert(pdto);
		}			
		if(n2>0){
			request.setCharacterEncoding("utf-8");
			BasketDao bdao=new BasketDao();
			String [] b_num=request.getParameterValues("buynum");
			int [] buynum = null;
			for(int i=0;i<b_num.length;i++){
				buynum = new int [b_num.length];
				buynum[i] = Integer.parseInt(b_num[i]);
				if(buynum[i]!=0)bdao.delete(buynum[i]);
			}
			request.getRequestDispatcher("starter.do?content=/adminPage/layout/paymentResult.jsp").forward(request, response);
		}else{
			
		}
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaymentDao dao=new PaymentDao();
		ArrayList<PaymentDTO> list=dao.list();
		request.setAttribute("list2", list);
		request.getRequestDispatcher("/adminPage/layout/paymentList.jsp").forward(request, response);
	}
	private void itemReturn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int paymentNum=Integer.parseInt(request.getParameter("paymentnum"));
		PaymentDao dao=new PaymentDao();
		
		ReturnItemDao rdao=new ReturnItemDao();
		ReturnItemDTO rdto=new ReturnItemDTO(0, null, "ó����", paymentNum);
		int n1=rdao.insert(rdto);
		System.out.println("��ǰó����..");
		/*
		if(n1>0){
			n1=dao.delete(paymentNum);
			System.out.println("��ǰ�Ϸ�");
		}
		*/
		if(n1>0){
			StatisticDao sdao=new StatisticDao();
			n1=sdao.update(paymentNum);
			System.out.println("��ǰ�����Ϸ�");
		}
		if(n1>0){
			request.getRequestDispatcher("/payment.do?cmd=list").forward(request, response);
		}
	}
	private void paymentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String spageNum=request.getParameter("pageNum");
		String id=(String)session.getAttribute("id");
		PaymentDao dao=new PaymentDao();
		int pageNum=1; //������ ��ȣ�� ������(�Ķ���Ͱ� �Ѿ���� ������) 1�������� �����ش�
		if(spageNum!=null){
			pageNum=Integer.parseInt(spageNum);
		}	
		//<<<<<<<<<<<<<<<<<<��ǰ���>>>>>>>>>>>>>>>>
		//��ü���������� ���ϱ�
		int pageCount=(int)Math.ceil(dao.getCount(id)/5.0); //�������� ���������̴� �ø� �� ����ȯ�� �־�����
		System.out.println("getCount"+dao.getCount(id));
		//���������� ���ϱ�
		int startPage=((pageNum-1)/10*10)+1;//�������� ����̱� ������ 0.1~0.9 ���� 0�̴� �� 1~10�������� ������������ ������ 1�̴�
		//�������� ���ϱ�
		int endPage=startPage+9;
		// ��������� �ִٸ� ��ü �������� 10�� ����� �ƴҶ� ����ִ� �������� ��µȴ�(ex ��ü �������� 25������ ���������� 30���� �ȴ�)
		// �׷��� ������ �Ʒ� if�� �߰�!
		if(endPage>pageCount){
			endPage=pageCount;
		}
		//1�������� 1~10, 2�������� 11~20���� �����ֱ� ���� ������ ����
		int startRow=(pageNum-1)*5+1;//�������ȣ
		int endRow=startRow+4;//�����ȣ
		
		if(endRow<1){
			endRow=1;
		}	
		System.out.println(startRow);
		System.out.println(endRow);
		System.out.println(startPage);
		System.out.println("ep"+endPage);
		ArrayList<PaymentResultDTO> list=dao.paymentlist(id,startRow,endRow);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("id", id);
		request.setAttribute("list3", list);
		request.getRequestDispatcher("/starter.do?content=/MyPage/MpOrder.jsp").forward(request, response);
	}
}
