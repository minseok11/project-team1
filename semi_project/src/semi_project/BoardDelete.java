package semi_project;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.dao.BoardDao;
@WebServlet("/boardDelete.do")
public class BoardDelete extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String num=req.getParameter("boardNum");
		String id=req.getParameter("id");
		int boardNum=0;
		if(num!=null)boardNum=Integer.parseInt(num);
		HttpSession session=req.getSession();
		String sid=(String)session.getAttribute("id");
		sid="admin";
		BoardDao dao=new BoardDao();
		String code=dao.findCode(boardNum);
		req.setAttribute("code", code);
		if(id.equals(sid)){
			String imgName=dao.findImg(boardNum);
			ServletContext application=getServletContext();
			String savePath=application.getRealPath("/writeImg");
			File file=new File(savePath+"\\"+imgName);
			if(file.exists())file.delete();
			int result=dao.delete(boardNum);
			if(result>0){
				req.setAttribute("ans", "삭제성공");
			}else{
				req.setAttribute("ans", "삭제실패");
			}
		}else{
			req.setAttribute("ans", "본인이 작성한 글만 삭제할 수 있습니다.");
		}
		req.getRequestDispatcher("/itemDetail.do").forward(req, res);
	}
}
