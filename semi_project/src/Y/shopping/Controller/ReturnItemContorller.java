package Y.shopping.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Y.shopping.dao.CategoryDao;
import Y.shopping.dao.ItemDao;
import Y.shopping.dao.ReturnItemDao;
import Y.shopping.dto.CategoryDTO;
import Y.shopping.dto.ItemDTO;
import Y.shopping.dto.ReturnDTO;

@WebServlet("/returnitem.do")
public class ReturnItemContorller extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getParameter("cmd");
		if(cmd.equals("list")){
			list(request,response);
		}else if(cmd.equals("search")){
			search(request,response);
		}else if(cmd.equals("delete")){
			delete(request,response);
		}
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDao cdao=new CategoryDao();
		ArrayList<CategoryDTO> clist=cdao.list();
		request.setAttribute("clist", clist);
		
		ReturnItemDao dao=new ReturnItemDao();
		ArrayList<ReturnDTO> list=dao.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/adminPage/layout/return.jsp").forward(request, response);
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int returnNo=Integer.parseInt(request.getParameter("returnNo"));
		ReturnItemDao dao=new ReturnItemDao();
		int n=dao.delete(returnNo);
		if(n>0){
			request.getRequestDispatcher("/Yoseop/returnitem.do?cmd=list").forward(request, response);
		}
	}
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String option=request.getParameter("option");
		String search=request.getParameter("search");
		ReturnItemDao dao=new ReturnItemDao();
		ArrayList<ReturnDTO> list=dao.search(option, search);
		request.setAttribute("list", list);
		CategoryDao cdao=new CategoryDao();
		ArrayList<CategoryDTO> clist=cdao.list();
		request.setAttribute("clist", clist);
		
		request.getRequestDispatcher("/adminPage/layout/return.jsp").forward(request, response);
	}
}
	
