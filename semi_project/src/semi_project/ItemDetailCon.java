package semi_project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.dao.ItemDao;
import shopping.dto.ItemDTO;
@WebServlet("/itemDetail.do")
public class ItemDetailCon extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code=req.getParameter("code");
		ItemDao dao=new ItemDao();
		ItemDTO dto=dao.itemDetail(code);
		req.setAttribute("code", code);
		req.setAttribute("name", dto.getName());
		req.setAttribute("price", dto.getPrice());
		req.setAttribute("itemImgRoot", dto.getItemImgRoot());
		req.setAttribute("inventory", dto.getInventory());
		req.setAttribute("retailPrice", dto.getRetailPrice());
		req.setAttribute("supplier", dto.getSupplier());
		req.setAttribute("categoryList",dto.getCategoryList());
		req.setAttribute("content", "/itemDetail.jsp");
		req.getRequestDispatcher("/starter.do").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
