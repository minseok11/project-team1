package Y.shopping.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Y.shopping.dao.ItemDao;
import Y.shopping.dao.SupplierDao;
import Y.shopping.dto.CategoryDTO;
import Y.shopping.dto.ItemDTO;
import Y.shopping.dto.SupplierDTO;

@WebServlet("/supplier.do")
public class SupplierController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getParameter("cmd");
		if(cmd.equals("list")){
			list(request,response);
		}else if(cmd.equals("insert")){
			insert(request,response);
		}else if(cmd.equals("detail")){
			detail(request,response);
		}else if(cmd.equals("update")){
			update(request,response);
		}else if(cmd.equals("delete")){
			delete(request,response);
		}
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SupplierDao dao=new SupplierDao();
		ArrayList<SupplierDTO> list=dao.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/adminPage/layout/support.jsp").forward(request, response);
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String supplier=request.getParameter("supplier");
		SupplierDao dao=new SupplierDao();
		int n=dao.delete(supplier);
		if(n>0){
			request.getRequestDispatcher("/supplier.do?cmd=list").forward(request, response);
		}
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String supplier=request.getParameter("supplier");
		String manager=request.getParameter("manager");
		String contect=request.getParameter("contect");
		
		SupplierDao dao=new SupplierDao();
		SupplierDTO dto=new SupplierDTO(supplier, manager, contect);
		int n=dao.insert(dto);
		if(n>0){
			request.getRequestDispatcher("/supplier.do?cmd=list").forward(request, response);
		}else{
			
		}
	}
	protected void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		
		String supplier=request.getParameter("supplier");
		SupplierDao dao=new SupplierDao();
		ArrayList<SupplierDTO> list=dao.supplierList(supplier);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/adminPage/layout/ssupdate.jsp").forward(request, response);
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		
		String supplier=request.getParameter("supplier");
		String manager=request.getParameter("manager");
		String contect=request.getParameter("contect");
		SupplierDao dao=new SupplierDao();
		SupplierDTO dto=new SupplierDTO(supplier, manager, contect);
		int n=dao.update(dto);
		if(n>0){
			request.getRequestDispatcher("/supplier.do?cmd=list").forward(request, response);
		}else{
			
		}
	}
}