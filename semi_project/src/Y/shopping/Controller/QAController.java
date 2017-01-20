package Y.shopping.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Y.shopping.dao.QAboardDao;
import Y.shopping.dto.QAboardDTO;


@WebServlet("/qna.do")
public class QAController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		System.out.println(cmd);
		if(cmd.equals("list")){
			list(request,response);
		}else if(cmd.equals("SeeQA")){
			SeeQA(request,response);
		}else if(cmd.equals("answer")){
			answer(request,response);
		}else if(cmd.equals("qaList")){
			qalist(request,response);
		}else if(cmd.equals("MyQA")){
			MyQA(request,response);
		}
	}
	protected void answer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ref=Integer.parseInt(request.getParameter("ref"));
		String title=request.getParameter("a_title");
		String writer=request.getParameter("a_writer");
		String content=request.getParameter("a_content");
		String qalist=request.getParameter("a_qalist");
		QAboardDao dao=new QAboardDao();
		QAboardDTO dto=new QAboardDTO(0, ref, title, content, writer, qalist);
		int n=dao.a_insert(dto);
		if(n>0){
			response.sendRedirect("/Yoseop/qna.do?cmd=list");
		}
	}
	protected void SeeQA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=Integer.parseInt(request.getParameter("num"));
		
		QAboardDao dao=new QAboardDao();
		QAboardDTO dto =dao.SeeQA(num);
		
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("/adminPage/layout/QNAdetail.jsp").forward(request, response);
	}
	protected void MyQA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=Integer.parseInt(request.getParameter("num"));
		
		
		
		QAboardDao dao=new QAboardDao();
		QAboardDTO dto =dao.SeeQA(num);
		QAboardDTO dto2 =dao.SeeAnswer(num);
		
		request.setAttribute("dto2", dto);
		request.setAttribute("dto3", dto2);
		
		request.setAttribute("content", "/MyPage/MyQa.jsp");
		request.getRequestDispatcher("/starter.do").forward(request, response);
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QAboardDao dao=new QAboardDao();
		ArrayList<QAboardDTO> list=dao.listAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/adminPage/layout/QNA.jsp").forward(request, response);
	}
	protected void qalist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		QAboardDao dao=new QAboardDao();
		String start=request.getParameter("start");
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
		request.setAttribute("content", "/MyPage/MpWrite.jsp");
		request.setAttribute("list3", list);
		request.setAttribute("startPage", startNum);
		request.setAttribute("endPage", endNum);
		request.setAttribute("pageCount", pageCount);
		request.getRequestDispatcher("/starter.do").forward(request, response);
	}
}
