package Y.shopping.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		}
	}
	protected void insertTab(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String code=request.getParameter("itemCode");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		ItemDao idao=new ItemDao();
		ArrayList<ItemDTO> ilist=idao.detail(code);
		CustomerInfoDao cdao=new CustomerInfoDao();
		ArrayList<CustomerInfoDTO> clist=cdao.userlist(id);
		CouponDao dao=new CouponDao();
		ArrayList<CouponSearchDTO> coupon=dao.list(id);
		request.setAttribute("coupon", coupon);
		request.setAttribute("ilist", ilist);
		request.setAttribute("clist", clist);
		request.setAttribute("content", "/adminPage/layout/payment.jsp");
		request.getRequestDispatcher("/starter.do").forward(request, response);
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String coupon="미사용";
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
		cdao.c_insert(dto);
		dto=cdao.getinfo(csdto);
		if(dto!=null){
			int cnum=dto.getCreateNum();
			cdao.update(cnum);
			if(request.getParameter("coupon")!=null || !coupon.equals(request.getParameter("coupon"))){
				coupon="사용";	
			}
		}
		
		String[] code=request.getParameterValues("code");		
		String[] itemcost=request.getParameterValues("price");
		String[] retailPrice=request.getParameterValues("retail");
		String[] cnt=request.getParameterValues("cnt");
		PaymentDao dao=new PaymentDao();
		int a=dao.s_insert();
		//배송정보입력
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
			request.getRequestDispatcher("starter.do?content=/adminPage/layout/paymentResult.jsp").forward(request, response);
		}else{
			
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaymentDao dao=new PaymentDao();
		ArrayList<PaymentDTO> list=dao.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("starter.do?content=/adminPage/layout/paymentList.jsp").forward(request, response);
	}
	protected void itemReturn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int paymentNum=Integer.parseInt(request.getParameter("paymentnum"));
		PaymentDao dao=new PaymentDao();
		
		ReturnItemDao rdao=new ReturnItemDao();
		ReturnItemDTO rdto=new ReturnItemDTO(0, null, "처리중", paymentNum);
		int n1=rdao.insert(rdto);
		System.out.println("반품처리중..");
		/*
		if(n1>0){
			n1=dao.delete(paymentNum);
			System.out.println("반품완료");
		}
		*/
		if(n1>0){
			StatisticDao sdao=new StatisticDao();
			n1=sdao.update(paymentNum);
			System.out.println("반품최종완료");
		}
		if(n1>0){
			request.getRequestDispatcher("/payment.do?cmd=list").forward(request, response);
		}
	}
}
