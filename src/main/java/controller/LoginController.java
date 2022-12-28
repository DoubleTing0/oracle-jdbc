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

@WebServlet("/member/login")
public class LoginController extends HttpServlet {
	
	private MemberService memberService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 전에만 진입가능
		HttpSession session = request.getSession();
		
		// 로그인 전 : loginMember -> null
		// 로그인 후 : loginMember -> not null
		
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		if(loginMember != null) {	// 이미 로그인 상태라면...
			
			response.sendRedirect(request.getContextPath() + "/home");
			return;
			
		}
		
		
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 인코딩 : UTF-8
		request.setCharacterEncoding("UTF-8");
		
		// 로그인 전에만 진입가능
		HttpSession session = request.getSession();
		
		// 로그인 전 : loginMember -> null
		// 로그인 후 : loginMember -> not null
		
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		if(loginMember != null) {	// 이미 로그인 상태라면...
			
			response.sendRedirect(request.getContextPath() + "/home");
			return;
			
		}
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		if(memberId == null || memberPw == null || memberId.equals("") || memberPw.equals("")) {
			
			response.sendRedirect(request.getContextPath() + "/member/login");
			return;
			
		}
		
		
		
		// 로그인 성공하면 정보 저장할 Member
		Member resultMember = new Member();
				
		this.memberService = new MemberService();
		resultMember = this.memberService.loginCheck(memberId, memberPw);
		
		String targetUrl = "/member/login";
		if(resultMember != null) {
			session.setAttribute("loginMember", resultMember);
			targetUrl = "/home";
		}
		
		
		response.sendRedirect(request.getContextPath() + targetUrl);
		
		
	}
	
	
	

}
