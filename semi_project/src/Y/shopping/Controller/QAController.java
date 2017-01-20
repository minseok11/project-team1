package Y.shopping.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QAboardDao dao=new QAboardDao();
		ArrayList<QAboardDTO> list=dao.listAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/adminPage/layout/QNA.jsp").forward(request, response);
	}
}
