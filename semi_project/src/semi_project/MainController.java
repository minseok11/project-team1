package semi_project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.dao.ItemDao;
import shopping.dto.ItemDTO;
@WebServlet("/mainController.do")
public class MainController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cmd=req.getParameter("cmd");
		if(cmd.equals("itemChange")){
			int startNum=1;
			String sendNum=req.getParameter("num");
			if(sendNum!=null){
				startNum=Integer.parseInt(sendNum);
			}
			int endNum=startNum+5;
			ItemDao dao1=new ItemDao();
			ArrayList<ItemDTO> list1=dao1.mainList(startNum, endNum);
			Iterator<ItemDTO> it=list1.iterator();
			PrintWriter pw=res.getWriter();
			res.setCharacterEncoding("utf-8");
			res.setContentType("text/xml;charset=utf-8");
			pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			pw.println("<data>");
			while(it.hasNext()){
				ItemDTO dto=it.next();
				String code=dto.getCode();
				String itemImgRoot=dto.getItemImgRoot();
				String name=dto.getName();
				pw.println("<item>");
				pw.println("<code>"+code+"</code>");
				pw.println("<itemImgRoot>"+itemImgRoot+"</itemImgRoot>");
				pw.println("<name>"+name+"</name>");
				pw.println("</item>");
			}
			pw.println("</data>");
			pw.close();
		}
	}
}
