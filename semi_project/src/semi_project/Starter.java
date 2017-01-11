package semi_project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import shopping.dao.CategoryDao;
import shopping.dto.CategoryDTO;
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
		req.setAttribute("content", "/defaultContent.jsp");
		CategoryDao dao=new CategoryDao();
		ArrayList<CategoryDTO> list=dao.list();
		req.setAttribute("list",list);
		
		req.getRequestDispatcher("/index.jsp").forward(req, res);
		
	}
}
