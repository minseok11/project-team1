package semi_project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/starter.do")
public class Starter extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("head", "/defaultHeader.jsp");
		req.setAttribute("content", "/defaultContent.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, res);
	}
}
