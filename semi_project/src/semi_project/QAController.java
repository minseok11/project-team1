package semi_project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.dao.CustomerInfoDao;
import shopping.dto.CustomerInfoDTO;
@WebServlet("/QAController.do")
public class QAController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("content", "/qnaboard.jsp");
		HttpSession session=req.getSession();
		String sid=(String)session.getAttribute("id");
		CustomerInfoDao dao=new CustomerInfoDao();
		ArrayList<CustomerInfoDTO> list=dao.listUp(sid);
		
		req.getRequestDispatcher("/starter.do").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
