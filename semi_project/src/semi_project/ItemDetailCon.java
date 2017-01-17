package semi_project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.dao.BoardDao;
import shopping.dao.ItemDao;
import shopping.dto.BoardDTO;
import shopping.dto.ItemDTO;
@WebServlet("/itemDetail.do")
public class ItemDetailCon extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code=req.getParameter("code");
		if(req.getAttribute("code")!=null)code=(String)req.getAttribute("code");
		ItemDao dao=new ItemDao();
		ItemDTO dto=dao.itemDetail(code);
		HttpSession session=req.getSession();
		req.setAttribute("code", code);
		req.setAttribute("name", dto.getName());
		req.setAttribute("price", dto.getPrice());
		req.setAttribute("itemImgRoot", dto.getItemImgRoot());
		req.setAttribute("inventory", dto.getInventory());
		req.setAttribute("retailPrice", dto.getRetailPrice());
		req.setAttribute("supplier", dto.getSupplier());
		req.setAttribute("categoryList",dto.getCategoryList());
		BoardDao dao1=new BoardDao();
		int startNum=1;
		String start=req.getParameter("start");
		if(start!=null)startNum=Integer.parseInt(start);
		startNum=(startNum-1)/10*10+1;
		int endNum=startNum+9;
		int count=dao1.getCount(code);
		int pageCount=0;
		if(count>0)pageCount=(int)Math.ceil(count/10.0);
		if(endNum>pageCount)endNum=pageCount;
		int b=1;
		int e=b*10;
		if(start!=null){
			b=Integer.parseInt(start)*10-9;
			e=Integer.parseInt(start)*10;
		}
		String id=(String)session.getAttribute("id");
		id="admin";
		ArrayList<BoardDTO> list=dao1.listUp(code, b, e);
		req.setAttribute("list3", list);
		req.setAttribute("startPage", startNum);
		req.setAttribute("endPage", endNum);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("content", "/itemDetail.jsp");
		req.getRequestDispatcher("/starter.do").forward(req, resp);
	}
}
