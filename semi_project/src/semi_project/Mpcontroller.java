package semi_project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.dao.CustomerInfoDao;

import shopping.dto.CustomerInfoDTO;

@WebServlet("/MyPage.do")
public class Mpcontroller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cmd = req.getParameter("cmd");
		if (cmd.equals("update")) {
			update(req,res);
		}else if (cmd.equals("getinfo")) {
			getInfo(req,res);
		}else if(cmd.equals("delPage")){
			delPage(req,res);
		}else if(cmd.equals("delete")){
			delete(req,res);
		}else if(cmd.equals("main")){
			req.setAttribute("content", "/MyPage/MpMain.jsp");
			req.getRequestDispatcher("/starter.do").forward(req, res);
		}
	}
	private void getInfo(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		CustomerInfoDao dao=new CustomerInfoDao();
		ArrayList<CustomerInfoDTO> list=dao.listUp(id);
		Iterator<CustomerInfoDTO> it=list.iterator();
		if(it.hasNext()){
			CustomerInfoDTO dto=it.next();
			req.setAttribute("dto", dto);
		}else{
			req.setAttribute("errMsg", "정보가 없습니다");
		}
		req.setAttribute("content", "/MyPage/getinfo.jsp");
		req.getRequestDispatcher("/starter.do").forward(req, res);
	}
	private void update(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		String pwd=req.getParameter("userPw");
		CustomerInfoDao dao=new CustomerInfoDao();
		int chk=dao.IsMember(pwd, id);
		CustomerInfoDTO dto=new CustomerInfoDTO();
		dto.setId(id);
		dto.setPassword(pwd);
		dto.setEmail(req.getParameter("userEmail"));
		dto.setPhoneNo(req.getParameter("userPh"));
		dto.setAdress(req.getParameter("userAd")+"_"+req.getParameter("detailadr"));
		dto.setPostNo(req.getParameter("userPo"));
		if(chk>0){
			int result=dao.update(dto);
			if(result>0){
				req.setAttribute("content", "/MyPage/MpMain.jsp");
				req.getRequestDispatcher("/starter.do").forward(req, res);
			}else{
				req.setAttribute("errMsg", "오류로 인해 수정하지 못했습니다.");
				req.setAttribute("content", "/MyPage/getinfo.jsp");
				req.getRequestDispatcher("/starter.do").forward(req, res);
			}
		}else{
			req.setAttribute("dto", dto);
			req.setAttribute("errMsg", "비밀번호가 올바르지 않습니다");
			req.setAttribute("content", "/MyPage/getinfo.jsp");
			req.getRequestDispatcher("/starter.do").forward(req, res);
		}
	}
	private void delPage(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		CustomerInfoDao dao=new CustomerInfoDao();
		ArrayList<CustomerInfoDTO> list=dao.listUp(id);
		Iterator<CustomerInfoDTO> it=list.iterator();
		if(it.hasNext()){
			CustomerInfoDTO dto=it.next();
			req.setAttribute("dto", dto);
		}else{
			req.setAttribute("errMsg", "정보가 없습니다");
		}
		req.setAttribute("content", "/MyPage/MpDelete.jsp");
		req.getRequestDispatcher("/starter.do").forward(req, res);
	}
	private void delete(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		String password=req.getParameter("password");
		String ans=req.getParameter("ans");
		CustomerInfoDao dao=new CustomerInfoDao();
		ArrayList<CustomerInfoDTO> list=dao.listUp(id);
		Iterator<CustomerInfoDTO> it=list.iterator();
		if(it.hasNext()){
			CustomerInfoDTO dto=it.next();
			String pwd=dto.getPassword();
			String ans1=dto.getAns();
			if(password.equals(pwd)&&ans.equals(ans1)){
				int result=dao.delete(id);
				if(result>0){
					
				}else{
					req.setAttribute("dto", dto);
					req.setAttribute("errMsg", "알수 없는 오류로 해당 명령을 실행할 수 없습니다.");
					req.setAttribute("content", "/MyPage/MpDelete.jsp");
					req.getRequestDispatcher("/starter.do").forward(req, res);
				}
			}else{
				req.setAttribute("dto", dto);
				req.setAttribute("errMsg", "비밀번호 혹은 문제에 대한 답이 올바르지 않습니다.");
				req.setAttribute("content", "/MyPage/MpDelete.jsp");
				req.getRequestDispatcher("/starter.do").forward(req, res);
			}
		}else{
			req.setAttribute("errMsg", "회원정보가 없습니다.");
			req.setAttribute("content", "/MyPage/MpDelete.jsp");
			req.getRequestDispatcher("/starter.do").forward(req, res);
		}
	}
	








}