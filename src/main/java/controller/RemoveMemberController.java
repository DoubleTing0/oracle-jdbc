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

@WebServlet("/member/removeMember")
public class RemoveMemberController extends HttpServlet {
	
	private MemberService memberService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 상태가 아니라면
		HttpSession session = request.getSession();
		
		// 로그인 전 : loginMember -> null
		// 로그인 후 : loginMember -> not null
		
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		if(loginMember == null || loginMember.getMemberId().equals("")) {	// 이미 로그인 상태가 아니라면...
			
			response.sendRedirect(request.getContextPath() + "/home");
			return;
			
		}
		
		// 인코딩 : UTF-8
		request.setCharacterEncoding("UTF-8");
		
		Member member = new Member();
		member.setMemberId(loginMember.getMemberId());
		
		this.memberService = new MemberService();
		int resultRow = this.memberService.removeMember(member);
		
		String targetUrl = "/member/memberOne";
		if(resultRow == 1) {
			// 회원 탈퇴 성공하면
			targetUrl = "/home";
			request.getSession().invalidate();	// 세션 리셋
			
		}
		
		response.sendRedirect(request.getContextPath() + targetUrl);
		
		
		
		
		
	}

}
