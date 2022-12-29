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

@WebServlet("/board/modifyBoard")
public class ModifyBoardController extends HttpServlet {
	
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
		
		
		// 인코딩 : UTF-8
		request.setCharacterEncoding("UTF-8");
		
		String boardNo = request.getParameter("boardNo");
		
		if(boardNo == null || boardNo.equals("")) {
			
			response.sendRedirect(request.getContextPath() + "/board/boardList");
			return;
			
		}
		
		this.boardService = new BoardService();
		Board board = this.boardService.getBoardOne(Integer.parseInt(boardNo));
		
		request.setAttribute("board", board);
		
		
		request.getRequestDispatcher("/WEB-INF/view/board/modifyBoard.jsp").forward(request, response);
		
		
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
		
		String boardNo = request.getParameter("boardNo");
		String memberId = request.getParameter("memberId");
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		
		if(boardNo == null || memberId == null || boardTitle == null || boardContent == null 
				|| boardNo.equals("") || memberId.equals("") || boardTitle.equals("") || boardContent.equals("")) {
			
			response.sendRedirect(request.getContextPath() + "/board/boardList");
			return;
			
		}
		
		Board board = new Board();
		board.setBoardNo(Integer.parseInt(boardNo));
		board.setMemberId(memberId);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		
		this.boardService = new BoardService();
		int resultRow = this.boardService.modifyBoard(board);
		
		String targetUrl = "/board/modifyBoard";
		if(resultRow == 1) {
			targetUrl = "/board/boardOne?boardNo=" + board.getBoardNo();
		}
		
		response.sendRedirect(request.getContextPath() + targetUrl);
		
		
		
		
		
		
	}
	
	

}
