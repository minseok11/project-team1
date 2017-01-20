package Hwang.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Hwang.dao.CustomerDAO;
import Hwang.dto.CustomerDTO;

@WebServlet("/CustomerInfo.do")
public class CustomerController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getParameter("cmd");
		if(cmd.equals("terms")){
			terms(request,response);
		}else if(cmd.equals("insert")){
			insert(request,response);
		}else if(cmd.equals("idcheck")){
			idcheck(request,response);
		}else if(cmd.equals("emailCheck")){
			emailCheck(request,response);
		}else if(cmd.equals("login")){
			login(request,response);
		}else if(cmd.equals("findId")){
			findId(request,response);
		}else if(cmd.equals("findPwd")){
			findPwd(request,response);
		}else if(cmd.equals("logout")){
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("/starter.do");
		}
	}
	
	private void findPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		CustomerDAO dao=new CustomerDAO();
		String pwd=dao.FindPwd(id, name, email);
		
		if(pwd!=null){
			request.setAttribute("email", email);
			request.setAttribute("pwd", pwd);
			request.getRequestDispatcher("/SendMail1.jsp").forward(request, response);
		}else{
			request.setAttribute("errMsg", "찾으시는 정보에 대한 비밀번호가 없습니다. 다시 한 번 확인해주십시오");
			//request.getRequestDispatcher("").forward(request, response);
		}
	}
	
	private void findId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		CustomerDAO dao=new CustomerDAO();
		String id=dao.FindId(name, email);
		
		if(id!=null){
			request.setAttribute("name", name);
			request.setAttribute("id", id);
			request.setAttribute("content", "/hwang/FindIdS.jsp");
			request.getRequestDispatcher("/starter.do").forward(request, response);
		}else{
			request.setAttribute("errMsg", "찾으시는 정보에 대한 아이디가 없습니다. 다시 한 번 확인해주십시오");
			request.setAttribute("content", "/hwang/FindIdF.jsp");
			request.getRequestDispatcher("/starter.do").forward(request, response);
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		//int cnt=Integer.parseInt(request.getParameter("cnt"));
		
		CustomerDAO dao=new CustomerDAO();
		int n=dao.IsMember(pwd, id);
		
		if(n==1){
			HttpSession session=request.getSession();
			session.setAttribute("id", id);
			response.sendRedirect("/starter.do");//메인으로 갑시당~
		}else if(n==0){
			request.setAttribute("errMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			request.setAttribute("content", "/hwang/Login.jsp");
			request.getRequestDispatcher("/starter.do").forward(request, response);
		}else{
			request.setAttribute("content", "/hwang/error.jsp");
			request.getRequestDispatcher("/starter.do").forward(request, response);
		}
		
	}
	
	private void emailCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		
		CustomerDAO dao=new CustomerDAO();
		boolean using=dao.selectEmail(email);
		
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
		pw.print("<using>"+ using +"</using>");
		pw.print("</result>");
		pw.close();
		
		
	}
		
	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");	
		String password=request.getParameter("password");		
		String qeslist=request.getParameter("qeslist");			
		String ans=request.getParameter("ans");				
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String adress1=request.getParameter("adress1");
		String detailadr=request.getParameter("detailadr");
		//도로명주소+상세주소
		String adress=adress1+"_"+detailadr;
		String phoneno1=request.getParameter("phoneno1");
		String phoneno2=request.getParameter("phoneno2");
		String phoneno3=request.getParameter("phoneno3");
		//핸드폰 번호 합치기
		String phoneno=phoneno1+phoneno2+phoneno3;
		String postno=request.getParameter("postno");
		System.out.println(postno);
		
		CustomerDTO dto=new CustomerDTO(id, password, qeslist, ans, name, gender, email, phoneno, adress, postno);
		CustomerDAO dao=new CustomerDAO();
		int n=dao.insert(dto);
		if(n>0){
			request.setAttribute("content", "/hwang/LastJoin.jsp");
			RequestDispatcher rd=request.getRequestDispatcher("/starter.do");
			rd.forward(request, response);
		}else{
			
		}
		
	}
	
	private void idcheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		System.out.println(id);
		
		CustomerDAO dao=new CustomerDAO();
		boolean using=dao.selectId(id);
		System.out.println(using);
		
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
		pw.print("<using>" + using +"</using>");
		System.out.println(using);
		pw.print("</result>");
		pw.close();
		
	}
	
	private void terms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String choose1=request.getParameter("choose1");
		//String choose2=request.getParameter("choose2");
		
		//response.sendRedirect("/FirstJoin.jsp");
		request.setAttribute("content", "/hwang/FirstJoin.jsp");
		RequestDispatcher rd=request.getRequestDispatcher("/starter.do");
		rd.forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
