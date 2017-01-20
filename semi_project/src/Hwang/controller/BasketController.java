package Hwang.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Hwang.dao.BasketDao;
import Hwang.dto.BIDTO;
import Hwang.dto.BasketDto;
import shopping.dto.BuyDTO;

@WebServlet("/basket.do")
public class BasketController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	 String cmd=request.getParameter("cmd");
 
	 if(cmd.equals("insert")){
		 insert(request,response);
	 	}else if(cmd.equals("IdList")){
	 		IdList(request,response);
	 	}else if(cmd.equals("delete")){
	 		delete(request,response);
	 	}
	}
	 
	private void IdList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 HttpSession session=request.getSession();
		 String id=(String)session.getAttribute("id");
		 BasketDao dao=new BasketDao();
		 ArrayList<BIDTO> list=dao.IdList(id);
		 
		 request.setAttribute("list4", list);
		 request.setAttribute("content", "/Basket.jsp");
		 request.getRequestDispatcher("/starter.do").forward(request, response);
		 
	 }
	 
	 private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 HttpSession session=request.getSession();
		 String id=(String)session.getAttribute("id");
		 String itemPrice=request.getParameter("itemPrice");
		 int totalPrice=Integer.parseInt(itemPrice);
		 String code=request.getParameter("itemCode");
		 String ccnt=request.getParameter("itemCount");
		 int cnt=Integer.parseInt(ccnt);
		 String itemInven=request.getParameter("itemInven");
		 String itemName=request.getParameter("itemName");
		 String itemRprice=request.getParameter("itemRprice");
		 String itemImgRoot=request.getParameter("itemImgRoot");
		 String itemCate=request.getParameter("itemCate");
		 String itemSupplier=request.getParameter("itemSupplier");
		 
		 BasketDto dto=new BasketDto(0,totalPrice, id, code,cnt);
		 
		 BasketDao dao=new BasketDao();
		 int n=dao.insert(dto);
		 
		 if(n>0){
			request.setAttribute("code", code);
			request.setAttribute("itemInven", itemInven);
			request.setAttribute("name", itemName);
			request.setAttribute("price", totalPrice);
			request.setAttribute("itemRprice", itemRprice);
			request.setAttribute("itemImgRoot", itemImgRoot);
			request.setAttribute("itemCate", itemCate);
			request.setAttribute("itemSupplier", itemSupplier);	
			request.setAttribute("content", "itemDetail.jsp");
			request.setAttribute("msg", "장바구니에 추가되었습니다.");
			request.getRequestDispatcher("/starter.do").forward(request, response);
		 }
	 }
	 private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String buy=request.getParameter("buyNum");
			int buyNum=Integer.parseInt(buy);
			BasketDao dao=new BasketDao();
			int n=dao.delete(buyNum);
			
			if(n>0){
				response.sendRedirect("/basket.do?cmd=IdList");
			}
		}
}