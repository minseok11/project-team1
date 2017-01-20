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
import shopping.dao.InterestDao;
import Hwang.dto.BIDTO;
import Hwang.dto.BasketDto;
import Hwang.dto.IIDTO;
import Hwang.dto.InterestDTO;

@WebServlet("/interest.do")
public class InterestController extends HttpServlet{
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
			 Hwang.dao.InterestDao dao=new Hwang.dao.InterestDao();
			 ArrayList<IIDTO> list=dao.IdList(id);
			 
			 request.setAttribute("list3", list);
			 request.setAttribute("content", "/Interest.jsp");
			 request.getRequestDispatcher("/starter.do").forward(request, response);
			 
		 }
		 
		 private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 request.setCharacterEncoding("utf-8");
			 HttpSession session=request.getSession();
			 String id=(String)session.getAttribute("id");
			 String itemPrice=request.getParameter("itemPrice");
			 int totalPrice=Integer.parseInt(itemPrice);
			 String code=request.getParameter("itemCode");
			 String itemInven=request.getParameter("itemInven");
			 String itemName=request.getParameter("itemName");
			 String itemRprice=request.getParameter("itemRprice");
			 String itemImgRoot=request.getParameter("itemImgRoot");
			 String itemCate=request.getParameter("itemCate");
			 String itemSupplier=request.getParameter("itemSupplier");
			 Hwang.dto.InterestDTO dto=new InterestDTO(code, id);
			 
			 Hwang.dao.InterestDao dao=new Hwang.dao.InterestDao();
			 int n=dao.insert(dto);
			 if(n>0){
					request.setAttribute("msg", "관심상품에 추가되었습니다.");
			 }else{
				 	int m=dao.delete(dto);
				 	System.out.println(m);
				 	if(m>0){
						request.setAttribute("msg", "관심상품에서 삭제되었습니다.");
				 	}else{
				 		request.setAttribute("msg", "오류가 발생하여 해당 작업을 수행하지 못했습니다.");
				 	}
			 }
			request.setAttribute("code", code);
			request.setAttribute("inventory", itemInven);
			request.setAttribute("name", itemName);
			request.setAttribute("price", totalPrice);
			request.setAttribute("retailPrice", itemRprice);
			request.setAttribute("itemImgRoot", itemImgRoot);
			request.setAttribute("categoryList", itemCate);
			request.setAttribute("supplier", itemSupplier);	
			request.setAttribute("content", "/itemDetail.jsp");
			request.getRequestDispatcher("/starter.do").forward(request, response);
		 }
		 private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 request.setCharacterEncoding("utf-8");
			 HttpSession session=request.getSession();
			 String id=(String)session.getAttribute("id");
			 String code=request.getParameter("code");
			 InterestDTO dto=new InterestDTO(code, id);
			 Hwang.dao.InterestDao dao=new Hwang.dao.InterestDao();
			 int n=dao.delete(dto);
			 if(n>0){
				 request.getRequestDispatcher("/interest.do?cmd=IdList").forward(request, response);
			 }else{
				 
			 }
		 }
	}
