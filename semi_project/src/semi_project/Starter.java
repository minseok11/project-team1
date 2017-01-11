package semi_project;

import java.io.IOException;
import java.util.ArrayList;

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
		req.setAttribute("content", "/defaultContent.jsp");
		CategoryDao dao=new CategoryDao();
		ArrayList<CategoryDTO> list=dao.list();
		req.setAttribute("list",list);
/*		int startNum=1;
		String sendNum=req.getParameter("num");
		if(sendNum!=null){
			startNum=Integer.parseInt(sendNum);
		}
		int endNum=startNum+5;
		ItemDao dao1=new ItemDao();
		ArrayList<ItemDTO> list1=dao1.mainList(startNum, endNum);
		req.setAttribute("list1", list1);
*/
		req.getRequestDispatcher("/index1.jsp").forward(req, res);
		
	}
}
