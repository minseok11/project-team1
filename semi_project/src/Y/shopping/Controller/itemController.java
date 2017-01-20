package Y.shopping.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Y.shopping.dao.CategoryDao;
import Y.shopping.dao.ItemDao;
import Y.shopping.dao.SupplierDao;
import Y.shopping.dto.CategoryDTO;
import Y.shopping.dto.ItemDTO;
import Y.shopping.dto.SupplierDTO;

@WebServlet("/Aitems.do")
public class itemController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getParameter("cmd");
		if(cmd.equals("list")){
			list(request,response);
		}else if(cmd.equals("insertTab")){
			insertTab(request,response);
		}else if(cmd.equals("insert")){
			insert(request,response);
		}else if(cmd.equals("search")){
			search(request,response);
		}else if(cmd.equals("detail")){
			detail(request,response);
		}else if(cmd.equals("update")){
			update(request,response);
		}else if(cmd.equals("delete")){
			delete(request,response);
		}
	}
	protected void insertTab(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDao cdao=new CategoryDao();
		ArrayList<CategoryDTO> clist=cdao.list();
		request.setAttribute("clist", clist);
		
		SupplierDao dao=new SupplierDao();
		ArrayList<SupplierDTO> list=dao.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/adminPage/layout/insert.jsp").forward(request, response);
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//<<<<<<<<<<<<<<����¡ó��>>>>>>>>>>>>>>>>>>
		String spageNum=request.getParameter("pageNum"); 
		int pageNum=1; //������ ��ȣ�� ������(�Ķ���Ͱ� �Ѿ���� ������) 1�������� �����ش�
		if(spageNum!=null){
			pageNum=Integer.parseInt(spageNum);
		}	
		//<<<<<<<<<<<<<<<<<<��ǰ���>>>>>>>>>>>>>>>>
		ItemDao dao=new ItemDao();
		
		//��ü���������� ���ϱ�
		int pageCount=(int)Math.ceil(dao.getCount("code","")/5.0); //�������� ���������̴� �ø� �� ����ȯ�� �־�����
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
		int startRow=dao.getCount("code", "")-(pageNum-1)*5;//�������ȣ
		int endRow=startRow-4;//�����ȣ
		
		if(endRow<1){
			endRow=1;
		}
		ArrayList<ItemDTO> list=dao.list(startRow,endRow);
		request.setAttribute("ilist", list);
		
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);

		
		CategoryDao cdao=new CategoryDao();
		ArrayList<CategoryDTO> clist=cdao.list();
		request.setAttribute("clist", clist);
		request.getRequestDispatcher("/adminPage/layout/item.jsp").forward(request, response);
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("insert");
		String savePath=request.getServletContext().getRealPath("/images/itemImg");
		int sizeLimit = 1024*1024*15;
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
			
		String code=multi.getParameter("code");
		int price=Integer.parseInt(multi.getParameter("price"));
		int inventory=Integer.parseInt(multi.getParameter("inventory"));
		String name=multi.getParameter("name");
		int retail=Integer.parseInt(multi.getParameter("retail"));
		
		String imgRoot=multi.getFilesystemName("imgs");
		String detailImg=multi.getFilesystemName("detailImg");
		String category=multi.getParameter("category");
		String supplier=multi.getParameter("supplier");
		ItemDao dao=new ItemDao();
		ItemDTO dto=new ItemDTO(code, price, inventory, name, retail, imgRoot, detailImg, category, supplier);
		int n=dao.insert(dto);
		if(n>0){
			request.getRequestDispatcher("/Aitems.do?cmd=list").forward(request, response);
		}else{
			
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemDao dao=new ItemDao();
		String savePath=request.getServletContext().getRealPath("images");
		String code=request.getParameter("code");
		ArrayList<ItemDTO> list=dao.getName(code);
		Iterator<ItemDTO> it=list.iterator();
		String itemImgRoot=null;
		String detailImg=null;
		if(it.hasNext()){
			ItemDTO dto=it.next();
			itemImgRoot=dto.getItemImgRoot();
			detailImg=dto.getDetailImg();
		}
		File f=new File(savePath+"\\"+itemImgRoot);
		File ff=new File(savePath+"\\"+detailImg);
		boolean a=f.delete();
		boolean b=ff.delete();
		
		int n=dao.delete(code);
		if(n>0 & a & b){
			request.getRequestDispatcher("/Aitems.do?cmd=list").forward(request, response);
		}
	}
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		
		String option=request.getParameter("option");
		if(option == null ||  option == ""){
			option = "name";
		}
		String search=request.getParameter("search");
		if(search == null){
			search = "";
		}
		//	<<<<<<<<<<<<<<����¡ó��>>>>>>>>>>>>>>>>>>
		String spageNum=request.getParameter("pageNum"); 
		int pageNum=1; //������ ��ȣ�� ������(�Ķ���Ͱ� �Ѿ���� ������) 1�������� �����ش�
		if(spageNum!=null){
			pageNum=Integer.parseInt(spageNum);
		}	
		//<<<<<<<<<<<<<<<<<<��ǰ���>>>>>>>>>>>>>>>>
		ItemDao dao=new ItemDao();
		
		//��ü���������� ���ϱ�
		int pageCount=(int)Math.ceil(dao.getCount(option,search)/5.0); //�������� ���������̴� �ø� �� ����ȯ�� �־�����
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
		int startRow=dao.getCount(option,search)-(pageNum-1)*5;//�������ȣ
		int endRow=startRow-4;//�����ȣ
		
		if(endRow<1){
			endRow=1;
		}
		CategoryDao cdao=new CategoryDao();
		ArrayList<CategoryDTO> clist=cdao.list();
		request.setAttribute("clist", clist);
		ArrayList<ItemDTO> list=dao.search(startRow,endRow,option,search);
		request.setAttribute("ilist", list);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("option", option);
		request.setAttribute("search", search);
		request.getRequestDispatcher("/adminPage/layout/itemlist.jsp").forward(request, response);
	}
	protected void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		
		String code=request.getParameter("code");
		ItemDao dao=new ItemDao();
		ArrayList<ItemDTO> list=dao.detail(code);
		
		CategoryDao cdao=new CategoryDao();
		ArrayList<CategoryDTO> clist=cdao.list();
		request.setAttribute("clist", clist);
		
		SupplierDao sdao=new SupplierDao();
		ArrayList<SupplierDTO> slist=sdao.list();
		request.setAttribute("slist", slist);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/adminPage/layout/itemdetail.jsp").forward(request, response);
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		
		String savePath=request.getServletContext().getRealPath("images");
		int sizeLimit = 1024*1024*15;
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
			
		String code=multi.getParameter("code");
		int price=Integer.parseInt(multi.getParameter("price"));
		int inventory=Integer.parseInt(multi.getParameter("inventory"));
		String name=multi.getParameter("name");
		int retail=Integer.parseInt(multi.getParameter("retail"));
		String imgRoot=multi.getFilesystemName("imgs");
		String detailImg=multi.getFilesystemName("detailImg");
		String category=multi.getParameter("category");
		String supplier=multi.getParameter("supplier");
		
		ItemDao dao=new ItemDao();
		ItemDTO dto=new ItemDTO(code, price, inventory, name, retail, imgRoot, detailImg, category, supplier);
		
		ArrayList<ItemDTO> list=dao.getName(code);
		Iterator<ItemDTO> it=list.iterator();
		String itemImgRoot=null;
		String detailImgs=null;
		if(it.hasNext()){
			dto=it.next();
			itemImgRoot=dto.getItemImgRoot();
			detailImgs=dto.getDetailImg();
		}
		File f=new File(savePath+"\\"+itemImgRoot);
		File ff=new File(savePath+"\\"+detailImgs);
		boolean a=f.delete();
		boolean b=ff.delete();
		
		
		int n=dao.update(dto);
		if(n>0){
			request.getRequestDispatcher("/Aitems.do?cmd=list").forward(request, response);
		}else{
			
		}
	}
}






