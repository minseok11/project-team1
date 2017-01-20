package Y.shopping.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Y.shopping.dao.StatisticDao;
import Y.shopping.dto.StatisticDTO;

@WebServlet("/statistic.do")
public class StatisticController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		System.out.println(cmd);
		if(cmd.equals("list")){
			list(request,response);
		}else if(cmd.equals("year_list")){
			year_list(request,response);
		}
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StatisticDao dao=new StatisticDao();
		ArrayList<StatisticDTO> list=dao.list();
		request.setAttribute("list", list);
		request.setAttribute("listAll", list);
		request.getRequestDispatcher("/adminPage/layout/statisic.jsp").forward(request, response);
	}
	protected void year_list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int year=Integer.parseInt(request.getParameter("year"));
		StatisticDao dao=new StatisticDao();
		ArrayList<StatisticDTO> list=dao.year_list(year);
		ArrayList<StatisticDTO> listAll=dao.list();
		request.setAttribute("listAll", listAll);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/adminPage/layout/statisic.jsp").forward(request, response);
	}
}
