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

@WebServlet("/member/modifyMember")
public class ModifyMemberController extends HttpServlet {
	
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
		
		request.getRequestDispatcher("/WEB-INF/view/member/modifyMember.jsp").forward(request, response);
		
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
		
		String memberId = request.getParameter("memberId");
		String memberName = request.getParameter("memberName");
		
		if(memberId == null || memberName == null || memberId.equals("") || memberName.equals("")) {
			
			response.sendRedirect(request.getContextPath() + "/member/modifyMember");
			return;
			
		}
		
		
		// 수정할 회원정보 저장
		Member member = new Member();
		
		member.setMemberId(memberId);
		member.setMemberName(memberName);
		
		
		this.memberService = new MemberService();
		
		int resultRow = this.memberService.modifyMember(member);
		
		
		
		String targetUrl = "/member/modifyMember";
		
		if(resultRow == 1) {
			// 수정 성공하면
			
			session.setAttribute("loginMember", member);
			targetUrl = "/member/memberOne";
			
		}
		
		response.sendRedirect(request.getContextPath() + targetUrl);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
