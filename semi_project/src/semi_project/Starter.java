package semi_project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.dao.CategoryDao;
import shopping.dao.ItemDao;
import shopping.dto.CategoryDTO;
import shopping.dto.ItemDTO;
@WebServlet("/starter.do")
public class Starter extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		if(session.getAttribute("id")==null){
			req.setAttribute("head", "/defaultHeader.jsp");
		}else{
			req.setAttribute("head", "/loginHeader.jsp");
		}
		if(req.getParameter("content")!=null){
			req.setAttribute("content",req.getParameter("content"));
		}else if(req.getAttribute("content")==null){
			req.setAttribute("content", "/defaultContent.jsp");
		}else{
			req.setAttribute("content",req.getAttribute("content"));
		}
		CategoryDao dao=new CategoryDao();
		ArrayList<CategoryDTO> list=dao.list();
		req.setAttribute("list",list);
		req.getRequestDispatcher("/index1.jsp").forward(req, res);
	}
}
