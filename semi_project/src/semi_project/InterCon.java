package semi_project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.dao.InterestDao;
import shopping.dto.InterestDTO;
@WebServlet("/interest1.do")
public class InterCon extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		String code=req.getParameter("itemCode");
		InterestDTO dto=new InterestDTO(code, id);
		InterestDao dao=new InterestDao();
		String jjim=dao.insert(dto);
		req.setAttribute("jjim", jjim);
		req.setAttribute("code", code);
		req.setAttribute("content", "/itemDetail.jsp");
		req.getRequestDispatcher("/starter.do").forward(req, res);
		
	}
}
