package semi_project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.dao.CategoryDao;
import shopping.dao.ItemDao;
import shopping.dto.CategoryDTO;
import shopping.dto.ItemDTO;
@WebServlet("/starter.do")
public class Starter extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		if(session.getAttribute("id")==null){
			req.setAttribute("head", "/defaultHeader.jsp");
		}else{
			req.setAttribute("head", "/loginHeader.jsp");
		}
		if(session.getAttribute("id")!=null&&session.getAttribute("id").equals("admin")){
			req.setAttribute("head", "/adminstration.jsp");
		}
		if(req.getParameter("content")!=null){
			req.setAttribute("content",req.getParameter("content"));
		}else if(req.getAttribute("content")==null){
			req.setAttribute("content", "/defaultContent.jsp");
			ItemDao dao=new ItemDao();
			String[] icode=new String[9];
			String[] iimgroot=new String[9];
			int i=0;
			ArrayList<ItemDTO> list=dao.mdItem();
			if(list!=null){
				Iterator<ItemDTO> it=list.iterator();
				while(it.hasNext()){
					ItemDTO dto=it.next();
					icode[i]=dto.getCode();
					System.out.println(icode[i]);
					iimgroot[i]=dto.getItemImgRoot();
					System.out.println(iimgroot[i]);
					i++;
				}
				req.setAttribute("icode", icode);
				req.setAttribute("iimgroot", iimgroot);
			}
		}else{
			req.setAttribute("content",req.getAttribute("content"));
		}
		CategoryDao dao=new CategoryDao();
		ArrayList<CategoryDTO> list=dao.list();
		req.setAttribute("list",list);
		req.getRequestDispatcher("/index1.jsp").forward(req, res);
	}
}
