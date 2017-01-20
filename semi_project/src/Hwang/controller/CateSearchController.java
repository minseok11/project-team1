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

@WebServlet("/cateSearch.do")
public class CateSearchController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cate=request.getParameter("cate");
		String search=request.getParameter("search");
		String spageNum=request.getParameter("pageNum");
	
		int pageNum=1;
		if(spageNum!=null){
			pageNum=Integer.parseInt(spageNum);
		}
		
		int startRow=pageNum+(11*(pageNum-1));//시작행번호//무조건 1,11,21,..단위로 시작하게한다.
		int endRow=startRow+11;//끝행번호//10,20,30,..단위로 시작하게한다.
		
		ItemDAO dao=new ItemDAO();
		ArrayList<ItemDTO> list=dao.CateSearchList(cate, search, startRow, endRow);
		
		//전체 페이지갯수 구하기
		int pageCount=(int)Math.ceil(dao.ItemSearchCount(search,cate)/10.0);//실수로 나눠줘야 소수점까지 나옴
		//시작 페이지 구하기
		int startPage=((pageNum-1)/10*10)+1;//정수값끼리 연산했으니 소수점은 안쳐줌 0.xxx나와도 0임
		
		//끝 페이지 구하기
		int endPage=startPage+9;
		
		if(endPage>pageCount){
			endPage=pageCount;
		}
				
		request.setAttribute("list3", list);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("cate", cate);
		request.setAttribute("search", search);
		request.setAttribute("send", "E");
		request.setAttribute("content", "itemList.jsp");
		request.getRequestDispatcher("/starter.do").forward(request, response);
	
	}
}
