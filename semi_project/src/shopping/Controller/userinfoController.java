package shopping.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.dao.QAboardDao;
import shopping.dto.QAboardDTO;

@WebServlet("/userinfo.do")
public class userinfoController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd.equals("list")){
			list(request,response);
		}
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		QAboardDao dao=new QAboardDao();
		ArrayList<QAboardDTO> list1=dao.list(id);
		request.setAttribute("list", list1);
		request.getRequestDispatcher("/adminPage/layout/userdetail.jsp").forward(request, response);
	}
}
