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

@WebServlet("/member/addMember")
public class AddMemberController extends HttpServlet {
	
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
		
		// 회원가입 폼 View
		request.getRequestDispatcher("/WEB-INF/view/member/addMember.jsp").forward(request, response);
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 전에만 진입가능
		HttpSession session = request.getSession();
		
		// 로그인 전 : loginMember -> null
		// 로그인 후 : loginMember -> not null
		
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		if(loginMember != null) {	// 이미 로그인 상태라면...
			
			response.sendRedirect(request.getContextPath() + "HomeController");
			return;
			
		}
		
		request.setCharacterEncoding("UTF-8");	// 인코딩 : UTF-8
		
		this.memberService = null;
		Member member = null;	// 입력 받은 멤버
		int resultRow = 0;
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");

		if(memberId == null || memberPw == null || memberName == null 
				|| memberId.equals("") || memberPw.equals("") || memberName.equals("")) {
			
			response.sendRedirect(request.getContextPath() + "/member/addMember");
			return;
			
		}
		
		member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberName(memberName);
		
		this.memberService = new MemberService();
		resultRow = this.memberService.addMember(member);
		
		
		String targetUrl = "/member/addMember";
		if(resultRow == 1) {
			
			// 회원가입 성공하면 로그인창으로
			targetUrl = "/member/login";
			
		}
		
		response.sendRedirect(request.getContextPath() + targetUrl);
		
		
	}

}
