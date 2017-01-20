package Y.shopping.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Y.shopping.dao.ImgDao;
import Y.shopping.dto.ImgDTO;
import Y.shopping.dto.ImgUploadDTO;

@WebServlet("/images.do")
public class Images extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd.equals("insert")){
			insert(request,response);
		}else if(cmd.equals("list")){
			list(request,response);
		}
	}	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String savePath=request.getServletContext().getRealPath("images");
		int sizeLimit = 1024*1024*15;
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		
		String name=multi.getParameter("name");
		String nickname=multi.getParameter("nickname");
		String fileName=multi.getFilesystemName("imgs");
		String filePath=savePath+ "\\" + fileName;
		
		ImgDTO dto=new ImgDTO(name, nickname, filePath, fileName);
		
		dto.setName(name);
		dto.setNickname(nickname);
		dto.setFilePath(filePath);
		dto.setFileName(fileName);
		
		ImgDao dao=new ImgDao();
		int n=dao.insert(dto);
		request.setAttribute("list", dto);
		request.getRequestDispatcher("/test.jsp").forward(request, response);
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImgDao dao=new ImgDao();
		ArrayList<ImgDTO> list=dao.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/testimg.jsp").forward(request, response);
	}
}
