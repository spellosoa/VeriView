package com.saoe.controllers.messageController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saoe.model.MemberDTO;
import com.saoe.model.MessageDAO;
import com.saoe.model.MessageDTO;

public class WriteMessageCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		MemberDTO member= (MemberDTO)session.getAttribute("member");
		
		String send_id = member.getId();
		String receive_id = request.getParameter("receive_id");
		String message_content = request.getParameter("message_content");
		
		MessageDTO msg = new MessageDTO(send_id, receive_id, message_content);
		
		MessageDAO dao = new MessageDAO();
		
		int cnt = dao.sendMessage(msg);
		
		if(cnt > 0) {
			System.out.println("쪽지 보내기 성공");
		}else {
			System.out.println("쪽지 보내기 실패");			
		}
		
		response.sendRedirect("messageMain.jsp");
	
	}

}