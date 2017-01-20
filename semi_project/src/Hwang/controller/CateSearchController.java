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
		
		int startRow=pageNum+(11*(pageNum-1));//�������ȣ//������ 1,11,21,..������ �����ϰ��Ѵ�.
		int endRow=startRow+11;//�����ȣ//10,20,30,..������ �����ϰ��Ѵ�.
		
		ItemDAO dao=new ItemDAO();
		ArrayList<ItemDTO> list=dao.CateSearchList(cate, search, startRow, endRow);
		
		//��ü ���������� ���ϱ�
		int pageCount=(int)Math.ceil(dao.ItemSearchCount(search,cate)/10.0);//�Ǽ��� ������� �Ҽ������� ����
		//���� ������ ���ϱ�
		int startPage=((pageNum-1)/10*10)+1;//���������� ���������� �Ҽ����� ������ 0.xxx���͵� 0��
		
		//�� ������ ���ϱ�
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
