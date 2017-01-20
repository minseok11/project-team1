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
import shopping.dao.ItemDao;
import shopping.dto.BoardDTO;
import shopping.dto.ItemDTO;
import shopping.dto.QAboardDTO;
@WebServlet("/write.do")
public class WriteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		ServletContext application=req.getServletContext();
		String uploadPath=application.getRealPath("/images/customerImg");
		File file=new File(uploadPath);
		if(!file.exists())file.mkdirs();
		MultipartRequest mr=new MultipartRequest(
			req, //request객체
			uploadPath, //파일을 저장할 경로
			1024*1024*5, //최대 업로드 사이즈(byte단위 - 5mb)
			"utf-8", //인코딩타입
			new DefaultFileRenamePolicy()//동일한 파일명이 존재시 파일끝에 숫자붙이기
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
		ItemDao dao2=new ItemDao();
		ItemDTO dto2=dao2.itemDetail(code);
		req.setAttribute("code", code);
		req.setAttribute("price", dto2.getPrice());
		req.setAttribute("inventory", dto2.getInventory());
		req.setAttribute("name",dto2.getName());
		req.setAttribute("retailPirce", dto2.getRetailPrice());
		req.setAttribute("itemImgRoot", dto2.getItemImgRoot());
		req.setAttribute("detailImg", dto2.getDetailImg());
		req.setAttribute("categoryList", dto2.getCategoryList());
		req.setAttribute("supplier", dto2.getSupplier());
		String title=mr.getParameter("title");
		String content=mr.getParameter("wContent");
		String saveFileName=mr.getFilesystemName("uploadImg");//실제저장된파일명
		BoardDTO dto=new BoardDTO(0, title, content, id, code,saveFileName);
		int boardNum=dao.insert(dto);
		ArrayList<BoardDTO> list=dao.listUp(code, b, e);
		req.setAttribute("list3", list);
		req.setAttribute("startPage", startNum);
		req.setAttribute("endPage", endNum);
		req.setAttribute("pageCount", pageCount);
		if(boardNum>0){
			req.setAttribute("wResult", "작성성공");
			req.setAttribute("content", "/itemDetail.jsp");
			req.getRequestDispatcher("/starter.do").forward(req, res);
		}else{
			req.setAttribute("wResult", "오류로 인한 작성실패");
			req.setAttribute("content", "/itemDetail.jsp");
			req.getRequestDispatcher("/starter.do").forward(req, res);
		}
	}
}
