package semi_project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.dao.QAboardDao;
import shopping.dto.QAboardDTO;
@WebServlet("/QAboard.do")
public class QABoardController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		QAboardDao dao=new QAboardDao();
		String start=req.getParameter("start");
		int startNum=1;
		if(start!=null)startNum=Integer.parseInt(start);
		startNum=(startNum-1)/10*10+1;
		int endNum=startNum+9;
		int count=dao.getCount(id);
		int pageCount=0;
		if(count>0)pageCount=(int)Math.ceil(count/10.0);
		if(endNum>pageCount)endNum=pageCount;
		int b=1;
		int e=b*10;
		if(start!=null){
			b=Integer.parseInt(start)*10-9;
			e=Integer.parseInt(start)*10;
		}
		ArrayList<QAboardDTO> list=dao.listUp(id, b, e);
		req.setAttribute("content", "/qnaBoard.jsp");
		req.setAttribute("list3", list);
		req.setAttribute("startPage", startNum);
		req.setAttribute("endPage", endNum);
		req.setAttribute("pageCount", pageCount);
		req.getRequestDispatcher("/starter.do").forward(req, res);
	}
}
