package Y.shopping.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Y.shopping.dao.CouponDao;
import Y.shopping.dto.CouponDTO;
import Y.shopping.dto.CouponSearchDTO;
import Y.shopping.dto.CreateCouponDTO;

@WebServlet("/coupon.do")
public class CouponController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd.equals("insert")){
			insert(request,response);
		}else if(cmd.equals("cnt")){
			cnt(request,response);
		}
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("c_name");
		int discount=Integer.parseInt(request.getParameter("discount"));
		CouponDao dao=new CouponDao();
		CouponDTO dto=new CouponDTO(name, discount);
		int n=dao.insert(dto);
		if(n>0){
			response.sendRedirect("/adminPage/layout/coupon.jsp");
		}
		
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void cnt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		CouponDao dao=new CouponDao();
		ArrayList<CouponSearchDTO> dto=dao.searchList(id);
		request.setAttribute("clist", dto);
		request.getRequestDispatcher("/adminPage/layout/selectCoupon.jsp").forward(request, response);
	}
}
