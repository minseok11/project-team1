package Y.shopping.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Y.shopping.dao.CouponDao;
import Y.shopping.dao.CustomerInfoDao;
import Y.shopping.dao.PaymentDao;
import Y.shopping.dao.QAboardDao;
import Y.shopping.dto.CouponDTO;
import Y.shopping.dto.CouponSearchDTO;
import Y.shopping.dto.CreateCouponDTO;
import Y.shopping.dto.CustomerInfoDTO;
import Y.shopping.dto.PaymentDTO;
import Y.shopping.dto.QAboardDTO;

@WebServlet("/userinfo.do")
public class userinfoController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd.equals("list")){
			list(request,response);
		}
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		QAboardDao dao=new QAboardDao();
		ArrayList<QAboardDTO> list1=dao.list(id);
		CouponDao cdao=new CouponDao();
		ArrayList<CouponSearchDTO> list2=cdao.list(id);
		CustomerInfoDao custom=new CustomerInfoDao();
		ArrayList<CustomerInfoDTO> list3=custom.userlist(id);
		PaymentDao pay=new PaymentDao();
		ArrayList<PaymentDTO> list4=pay.paylist(id);
		request.setAttribute("list", list1);//1:1문의
		request.setAttribute("couponlist", list2);//쿠폰정보
		request.setAttribute("info", list3);//고객정보
		request.setAttribute("pay", list4);//결제정보
		request.setAttribute("id", id);
		request.getRequestDispatcher("/adminPage/layout/userdetail.jsp").forward(request, response);
	}
}
