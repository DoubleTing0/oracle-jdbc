package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Board;

@WebServlet("/ModifyBoardController")
public class ModifyBoardController extends HttpServlet {
	
	private BoardService boardService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 인코딩 : UTF-8
		request.setCharacterEncoding("UTF-8");
		
		String boardNo = request.getParameter("boardNo");
		
		if(boardNo == null || boardNo.equals("")) {
			
			response.sendRedirect(request.getContextPath() + "/BoardListController");
			return;
			
		}
		System.out.println(123);
		
		this.boardService = new BoardService();
		Board board = this.boardService.getBoardOne(Integer.parseInt(boardNo));
		
		request.setAttribute("board", board);
		
		
		request.getRequestDispatcher("/WEB-INF/view/board/modifyBoardForm.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
	}
	
	

}