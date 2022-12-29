package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

@WebServlet("/member/checkPassword")
public class CheckPasswordController extends HttpServlet {
	
	private MemberService memberService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 상태가 아니라면
		HttpSession session = request.getSession();
		
		// 로그인 전 : loginMember -> null
		// 로그인 후 : loginMember -> not null
		
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		if(loginMember == null) {	// 이미 로그인 상태가 아니라면...
			
			response.sendRedirect(request.getContextPath() + "/home");
			return;
			
		}
		
		String targetUrl = request.getParameter("targetUrl");
		
		// 디버깅
		System.out.println(targetUrl + " <-- targetUrl");
		
		if(targetUrl == null || targetUrl.equals("")) {
			
			response.sendRedirect(request.getContextPath() + "/home");
			return;
			
		}
		
		request.setAttribute("targetUrl", targetUrl);
		
		
		request.getRequestDispatcher("/WEB-INF/view/member/checkPassword.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 상태가 아니라면
		HttpSession session = request.getSession();
		
		// 로그인 전 : loginMember -> null
		// 로그인 후 : loginMember -> not null
		
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		if(loginMember == null) {	// 이미 로그인 상태가 아니라면...
			
			response.sendRedirect(request.getContextPath() + "/home");
			return;
			
		}
		
		// 인코딩 : UTF-8
		request.setCharacterEncoding("UTF-8");
		
		String targetUrl = request.getParameter("targetUrl");
		String memberPw = request.getParameter("memberPw");
		if(targetUrl == null || memberPw == null || targetUrl.equals("") || memberPw.equals("")) {
			
			response.sendRedirect(request.getContextPath() + "/home");
			return;
			
		}
		
		Member member = new Member();
		member.setMemberId(loginMember.getMemberId());
		member.setMemberPw(memberPw);
		
		this.memberService = new MemberService();
		
		// 비밀번호 일치하면 true, 틀리면 false
		boolean checkPw = this.memberService.checkPassword(member);
		
		
		if(checkPw) {
			
			response.sendRedirect(request.getContextPath() + targetUrl);
			
		} else {
			
			response.sendRedirect(request.getContextPath() + "/member/checkPassword?targetUrl=" + targetUrl);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
