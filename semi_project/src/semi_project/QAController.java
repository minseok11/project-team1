package semi_project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.dao.CustomerInfoDao;
import shopping.dao.QAboardDao;
import shopping.dto.CustomerInfoDTO;
import shopping.dto.QAboardDTO;
@WebServlet("/QAController.do")
public class QAController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("content", "/qnaboard.jsp");
		HttpSession session=req.getSession();
		String sid=(String)session.getAttribute("id");
		CustomerInfoDao dao=new CustomerInfoDao();
		ArrayList<CustomerInfoDTO> list=dao.listUp(sid);
		Iterator<CustomerInfoDTO> it=list.iterator();
		if(it.hasNext()){
			CustomerInfoDTO dto=it.next();
			req.setAttribute("name", dto.getName());
			req.setAttribute("email", dto.getEmail());
			req.setAttribute("phone", dto.getPhoneNo());
		}
		req.getRequestDispatcher("/starter.do").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		String qaList=req.getParameter("qaList");
		QAboardDTO dto=new QAboardDTO(0, 0, title, content, id, qaList);
		
	}
}
