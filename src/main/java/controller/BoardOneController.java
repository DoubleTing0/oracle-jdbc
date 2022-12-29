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

@WebServlet("/board/boardOne")
public class BoardOneController extends HttpServlet {
	
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
		
		request.getRequestDispatcher("/WEB-INF/view/board/boardOne.jsp").forward(request, response);
		
		
		
		
	}

}
