package Hwang.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hwang.dao.ItemDAO;
import shopping.dto.ItemDTO;


@WebServlet("/itemOrder.do")
public class ItemOrderController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd.equals("NewItem")){
			NewItem(request,response);
		}else if(cmd.equals("HotItem")){
			HotItem(request,response);
		}else if(cmd.equals("LowPrice")){
			LowPrice(request,response);
		}else if(cmd.equals("HighPrice")){
			HighPrice(request,response);
		}
	}
	
	private void NewItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cate=request.getParameter("cate");
		String spageNum=request.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null){
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=pageNum+(11*(pageNum-1));
		int endRow=startRow+11;
		ItemDAO dao=new ItemDAO();
		ArrayList<ItemDTO> list=dao.NewItemList(cate, startRow, endRow);
		//전체 페이지갯수 구하기
		int pageCount=(int)Math.ceil(dao.getCount(cate)/10.0);
		//시작 페이지 구하기
		int startPage=((pageNum-1)/10*10)+1;
		
		//끝 페이지 구하기
		int endPage=startPage+9;
		
		if(endPage>pageCount){
			endPage=pageCount;
		}
		//-----페이징 처리를 위한 작업들-----		
		request.setAttribute("list3", list);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("cate", cate);
		request.setAttribute("send", "A");
		request.setAttribute("content", "/itemList.jsp");
		request.getRequestDispatcher("/starter.do").forward(request, response);
		
	}
	
	private void HotItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cate=request.getParameter("cate");
		String spageNum=request.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null){
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=pageNum+(11*(pageNum-1));
		int endRow=startRow+11;
		ItemDAO dao=new ItemDAO();
		ArrayList<ItemDTO> list=dao.HotItemList(cate, startRow, endRow);
		//전체 페이지갯수 구하기
		int pageCount=(int)Math.ceil(dao.getCount(cate)/10.0);//실수로 나눠줘야 소수점까지 나옴
		//시작 페이지 구하기
		int startPage=((pageNum-1)/10*10)+1;//정수값끼리 연산했으니 소수점은 안쳐줌 0.xxx나와도 0임
		
		//끝 페이지 구하기
		int endPage=startPage+9;
		
		if(endPage>pageCount){
			endPage=pageCount;
		}
		//-----페이징 처리를 위한 작업들-----		
		request.setAttribute("list3", list);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("cate", cate);
		request.setAttribute("send", "B");
		request.setAttribute("content", "/itemList.jsp");
		request.getRequestDispatcher("/starter.do").forward(request, response);
		
	}
	
	private void LowPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("utf-8");
		String cate=request.getParameter("cate");
		String spageNum=request.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null){
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=pageNum+(11*(pageNum-1));
		int endRow=startRow+11;
		ItemDAO dao=new ItemDAO();
		ArrayList<ItemDTO> list=dao.LowPriceList(cate, startRow, endRow);
		//전체 페이지갯수 구하기
		int pageCount=(int)Math.ceil(dao.getCount(cate)/10.0);//실수로 나눠줘야 소수점까지 나옴
		//시작 페이지 구하기
		int startPage=((pageNum-1)/10*10)+1;//정수값끼리 연산했으니 소수점은 안쳐줌 0.xxx나와도 0임
		
		//끝 페이지 구하기
		int endPage=startPage+9;
		
		if(endPage>pageCount){
			endPage=pageCount;
		}
		//-----페이징 처리를 위한 작업들-----		
		request.setAttribute("list3", list);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("cate", cate);
		request.setAttribute("send", "C");
		request.setAttribute("content", "/itemList.jsp");
		request.getRequestDispatcher("/starter.do").forward(request, response);
	}
	
	private void HighPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cate=request.getParameter("cate");
		String spageNum=request.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null){
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=pageNum+(11*(pageNum-1));
		int endRow=startRow+11;
		ItemDAO dao=new ItemDAO();
		ArrayList<ItemDTO> list=dao.HighPriceList(cate, startRow, endRow);
		//전체 페이지갯수 구하기
		int pageCount=(int)Math.ceil(dao.getCount(cate)/10.0);//실수로 나눠줘야 소수점까지 나옴
		//시작 페이지 구하기
		int startPage=((pageNum-1)/10*10)+1;//정수값끼리 연산했으니 소수점은 안쳐줌 0.xxx나와도 0임
		
		//끝 페이지 구하기
		int endPage=startPage+9;
		
		if(endPage>pageCount){
			endPage=pageCount;
		}
		//-----페이징 처리를 위한 작업들-----		
		request.setAttribute("list3", list);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("cate", cate);
		request.setAttribute("send", "D");
		request.setAttribute("content", "/itemList.jsp");
		request.getRequestDispatcher("/starter.do").forward(request, response);
		
	}		
}

