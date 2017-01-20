package Y.shopping.Controller;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Y.shopping.dao.CustomerInfoDao;
import Y.shopping.dto.CustomerInfoDTO;

@WebServlet("/users.do")
public class CustomerInfoController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd.equals("list")){
			list(request,response);
		}else if(cmd.equals("detail")){
			detail(request,response);
		}
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerInfoDao dao=new CustomerInfoDao();
		ArrayList<CustomerInfoDTO> list=dao.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/adminPage/layout/user.jsp").forward(request, response);
	}
	protected void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		request.setAttribute("id", id);
		request.getRequestDispatcher("/adminPage/layout/userdetail.jsp").forward(request, response);
	}
}
