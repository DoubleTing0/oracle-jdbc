package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import vo.Board;
import vo.Member;

@WebServlet("/board/addBoard")
public class AddBoardController extends HttpServlet {
	
	private BoardService boardService;
	
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
		
		request.getRequestDispatcher("/WEB-INF/view/board/addBoard.jsp").forward(request, response);
		
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
		
		String boardTitle = request.getParameter("boardTitle");
		String memberId = request.getParameter("memberId");
		String boardContent = request.getParameter("boardContent");
		
		if(boardTitle == null || memberId == null || boardContent == null 
				|| boardTitle.equals("") || memberId.equals("") || boardContent.equals("")) {
			
			response.sendRedirect(request.getContextPath() + "/board/addBoard");
			return;
			
		}
		
		Board board = new Board();
		board.setBoardTitle(boardTitle);
		board.setMemberId(memberId);
		board.setBoardContent(boardContent);
		
		this.boardService = new BoardService();
		int resultRow = this.boardService.addBoard(board);
		
		String targetUrl = "/board/addBoard";
		if(resultRow == 1) {
			// 게시글 입력 성공하면
			targetUrl = "/board/boardList";
		}
		
		response.sendRedirect(request.getContextPath() + targetUrl);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
