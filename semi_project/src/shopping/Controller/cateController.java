package shopping.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.dao.CategoryDao;
import shopping.dto.CategoryDTO;

@WebServlet("/category.do")
public class cateController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getParameter("cmd");
		if(cmd.equals("list")){
			list(request,response);
		}else if(cmd.equals("insert")){
			insert(request,response);
		}else if(cmd.equals("delete")){
			delete(request,response);
		}
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("insert");
		String cate=request.getParameter("cate");
		System.out.println(cate);
		CategoryDao dao=new CategoryDao();
		CategoryDTO dto=new CategoryDTO(cate);
		int n=dao.insert(dto);
		if(n>0){
			request.getRequestDispatcher("/category.do?cmd=list").forward(request, response);
		}else{
			response.sendRedirect("errorMsg");
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cate=request.getParameter("cate");
		CategoryDao dao=new CategoryDao();
		int n=dao.delete(cate);
		if(n>0){
			request.getRequestDispatcher("/category.do?cmd=list").forward(request, response);
		}else{
			response.sendRedirect("errorMsg");
		}
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		CategoryDao dao=new CategoryDao();
		ArrayList<CategoryDTO> list=dao.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/adminPage/layout/category.jsp").forward(request, response);
	}
}
