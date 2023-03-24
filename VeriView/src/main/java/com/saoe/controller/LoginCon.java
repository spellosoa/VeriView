package com.saoe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saoe.model.MemberDAO;
import com.saoe.model.MemberDTO;

@WebServlet("/LoginCon")
public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println(id+pw);
		
		MemberDAO dao = new MemberDAO();
		
		MemberDTO dto = new MemberDTO(id,pw);
		
		MemberDTO member = dao.login(dto);
		
		if(member != null) {
			System.out.println("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
		}else {
			System.out.println("로그인 실패");
		}
		
		response.sendRedirect("main.jsp");
		
	}

}
