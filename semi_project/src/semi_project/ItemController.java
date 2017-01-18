package semi_project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.dao.ItemDao;
import shopping.dto.ItemDTO;
@WebServlet("/itemController.do")
public class ItemController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cate=req.getParameter("cate");
		String start=req.getParameter("start");
		ItemDao dao=new ItemDao();
		int startNum=1;
		if(start!=null)startNum=Integer.parseInt(start);
		startNum=(startNum-1)/10*10+1;
		int endNum=startNum+9;
		int count=dao.getCount(cate);
		int pageCount=0;
		if(count>0)pageCount=(int)Math.ceil(count/12.0);
		if(endNum>pageCount)endNum=pageCount;
		int b=1;
		int e=b*12;
		if(start!=null){
			b=Integer.parseInt(start)*12-11;
			e=Integer.parseInt(start)*12;
		}
		ArrayList<ItemDTO> list=dao.cateList(b, e,cate);
		req.setAttribute("content", "/itemList.jsp");
		req.setAttribute("list3", list);
		req.setAttribute("startPage", startNum);
		req.setAttribute("endPage", endNum);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("cate", cate);
		req.getRequestDispatcher("/starter.do").forward(req, res);
	}
}
