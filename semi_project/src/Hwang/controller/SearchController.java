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

@WebServlet("/search.do")
public class SearchController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");
		String search=request.getParameter("search");
			
		String spageNum=request.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null){
			pageNum=Integer.parseInt(spageNum);
		}
		
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		
		ItemDAO dao=new ItemDAO();
		ArrayList<ItemDTO> list=dao.MainSerchList(search, startRow, endRow);
		
		int pageCount=(int)Math.ceil(dao.SearchCount(search)/10.0);
		
		int startPage=((pageNum-1)/10*10)+1;
		int endPage=startPage+9;
		
		if(endPage>pageCount){
			endPage=pageCount;
		}
		
		request.setAttribute("list3", list);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("search", search);
		request.setAttribute("content", "/MainSearchPage.jsp");
		request.getRequestDispatcher("/starter.do").forward(request, response);
	}
}
