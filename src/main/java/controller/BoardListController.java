package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import vo.Board;
import vo.Member;

@WebServlet("/board/boardList")
public class BoardListController extends HttpServlet {
	
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
		
		session.setAttribute("pageName", "board");
		
		// 인코딩 : UTF-8
		request.setCharacterEncoding("UTF-8");
		
		String searchCategory = "board_title";
		if(request.getParameter("searchCategory") != null) {
			searchCategory = request.getParameter("searchCategory");
		}
		
		String searchText = "";
		if(request.getParameter("searchText") != null) {
			searchText = request.getParameter("searchText");
		}
		
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int rowPerPage = 10;
		if(request.getParameter("rowPerPage") != null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		
		this.boardService = new BoardService();
		ArrayList<Board> list = boardService.getBoardListByPage(searchCategory, searchText, currentPage, rowPerPage);
		
		// 디버깅
		System.out.println(list.size() + " <-- list.size()");
		
		// 페이징 처리
		ArrayList<HashMap<String, Object>> pageList = this.boardService.getPageBoard(searchCategory, searchText, currentPage, rowPerPage); 
		
		for(HashMap<String, Object> hm : pageList) {
			
			request.setAttribute("previousPage", (int) hm.get("previousPage"));
			request.setAttribute("nextPage", (int) hm.get("nextPage"));
			request.setAttribute("lastPage", (int) hm.get("lastPage"));
			request.setAttribute("pageList", (ArrayList<Integer>) hm.get("pageList"));
		}
		
		
		
		request.setAttribute("boardList", list);
		request.setAttribute("searchText", searchText);	// view에서 필요
		request.setAttribute("currentPage", currentPage);	// view에서 필요
		request.setAttribute("rowPerPage", rowPerPage);		// view에서 필요
		
		request.getRequestDispatcher("/WEB-INF/view/board/boardList.jsp").forward(request, response);
		
		
		
		
	}

}
