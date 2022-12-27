package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.BoardDao;
import util.DBUtil;
import vo.Board;

public class BoardService {

	private BoardDao boardDao;
	
	public ArrayList<HashMap<String, Object>> pageBoard(String searchText, int currentPage, int rowPerPage) {
		
		ArrayList<HashMap<String, Object>> list = null;
		
		Connection conn = null;
		
		try {
			
			conn = DBUtil.getConnection();
			
			this.boardDao = new BoardDao();
			
			// 페이지 처리
			int pageLength = 10;
			int count = this.boardDao.countBoard(conn, searchText);
			
			int previousPage = Page.getPreviousPage(currentPage, pageLength);
			int nextPage = Page.getNextPage(currentPage, pageLength);
			int lastPage = Page.getLastPage(count, rowPerPage);
			ArrayList<Integer> pageList = Page.getPageList(currentPage, pageLength);
			
			list = new ArrayList<HashMap<String, Object>>();
			
			HashMap<String, Object> m1 = new HashMap<String, Object>();
			m1.put("previousPage", previousPage);
			m1.put("nextPage", nextPage);
			m1.put("lastPage", lastPage);
			m1.put("pageList", pageList);
			list.add(m1);
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
		
	}
	
	public ArrayList<Board> getBoardListByPage(String searchText, int currentPage, int rowPerPage) {
		
		ArrayList<Board> list = null;
		
		/*
			1) connection 생성 <- DBUtil.class
			2) beginRow, endRow 생성 <- currentPage, rowPerPage 를 가공
		
		*/
		
		Connection conn = null;
		
		try {
			
			conn = DBUtil.getConnection();
			
			int beginRow = Page.getBeginRow(currentPage, rowPerPage);
			int endRow = Page.getEndRow(beginRow, rowPerPage);
			
			// 디버깅
			System.out.println(beginRow + " <-- beginRow");
			System.out.println(endRow + " <-- endRow");
			
			this.boardDao = new BoardDao();
			list = this.boardDao.selectBoardListByPage(conn, searchText, beginRow, endRow);
			
			conn.commit();
		} catch (Exception e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
			
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		
		return list;
		
	}
	
	
	
	
	
}
