package com.edu.member.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.member.model.MemberService;
import com.edu.member.model.MemberVO;

@WebServlet("/Member/memberProc.do")
public class MemberControl extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setMail(mail);
		
		// 서비스 로직 (MemberService.java)
		// DB 처리 (MemberDAO.java)
		MemberService service = new MemberService();
		service.memberInsert(member);
		
		req.setAttribute("member", member);
		
		// 처리결과 memberOutPut.jsp
		RequestDispatcher rd = req.getRequestDispatcher("memberOutput.jsp");
		rd.forward(req, resp);
	}
}
