package semi_project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.core.ApplicationContext;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import shopping.dao.BoardDao;
import shopping.dto.BoardDTO;
import shopping.dto.QAboardDTO;
@WebServlet("/write.do")
public class WriteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		ServletContext application=req.getServletContext();
		String uploadPath=application.getRealPath("/writeImg");
		File file=new File(uploadPath);
		if(!file.exists())file.mkdirs();
		MultipartRequest mr=new MultipartRequest(
			req, //request��ü
			uploadPath, //������ ������ ���
			1024*1024*5, //�ִ� ���ε� ������(byte���� - 5mb)
			"utf-8", //���ڵ�Ÿ��
			new DefaultFileRenamePolicy()//������ ���ϸ��� ����� ���ϳ��� ���ں��̱�
		);
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		String code=mr.getParameter("code");
		id="admin";
		String start=req.getParameter("start");
		BoardDao dao=new BoardDao();
		int startNum=1;
		if(start!=null)startNum=Integer.parseInt(start);
		startNum=(startNum-1)/10*10+1;
		int endNum=startNum+9;
		int count=dao.getCount(code);
		int pageCount=0;
		if(count>0)pageCount=(int)Math.ceil(count/10.0);
		if(endNum>pageCount)endNum=pageCount;
		int b=1;
		int e=b*10;
		if(start!=null){
			b=Integer.parseInt(start)*10-9;
			e=Integer.parseInt(start)*10;
		}
		ArrayList<BoardDTO> list=dao.listUp(id, b, e);
		req.setAttribute("list3", list);
		req.setAttribute("startPage", startNum);
		req.setAttribute("endPage", endNum);
		req.setAttribute("pageCount", pageCount);
		
		String title=mr.getParameter("title");
		String content=mr.getParameter("wContent");
		String saveFileName=mr.getFilesystemName("uploadImg");//������������ϸ�
		BoardDTO dto=new BoardDTO(0, title, content, id, code,saveFileName);
		int boardNum=dao.insert(dto);
		if(boardNum>0){
			req.setAttribute("wResult", "�ۼ�����");
			req.setAttribute("content", "/itemDetail.jsp");
			req.getRequestDispatcher("/starter.do").forward(req, res);
		}else{
			req.setAttribute("wResult", "������ ���� �ۼ�����");
			req.setAttribute("content", "/itemDetail.jsp");
			req.getRequestDispatcher("/starter.do").forward(req, res);
		}
	}
}
