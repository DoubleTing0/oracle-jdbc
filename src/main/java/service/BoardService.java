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
	
	// BoardList 페이징 처리
	public ArrayList<HashMap<String, Object>> getPageBoard(String searchCategory, String searchText, int currentPage, int rowPerPage) {
		
		ArrayList<HashMap<String, Object>> list = null;
		
		Connection conn = null;
		
		try {
			
			conn = DBUtil.getConnection();
			
			this.boardDao = new BoardDao();
			
			// 페이지 처리
			int pageLength = 10;
			int count = this.boardDao.countBoard(conn, searchCategory, searchText);
			
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
	
	// BoardList 출력
	public ArrayList<Board> getBoardListByPage(String searchCategory, String searchText, int currentPage, int rowPerPage) {
		
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
			list = this.boardDao.selectBoardListByPage(conn, searchCategory, searchText, beginRow, endRow);
			
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
	
	
	// BoardOne 출력
	public Board getBoardOne(int boardNo) {
		
		Board resultBoard = null;
		
		Connection conn = null;
		
		try {
			
			conn = DBUtil.getConnection();
			this.boardDao = new BoardDao();
			
			resultBoard = this.boardDao.selectBoardOne(conn, boardNo);
			
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

		
		return resultBoard;
		
	}
	
	
	// 게시글 입력하기
	public int addBoard(Board board) {
		
		int resultRow = 0;
		
		Connection conn = null;
		
		try {
			
			conn = DBUtil.getConnection();
			this.boardDao = new BoardDao();
			
			resultRow = this.boardDao.addBoard(conn, board);
			
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
		
		return resultRow;
		
	}
	
	// 게시글 수정하기
	public int modifyBoard(Board board) {
		
		int resultRow = 0;
		
		Connection conn = null;
		
		try {
			
			conn = DBUtil.getConnection();
			this.boardDao = new BoardDao();
			
			resultRow = this.boardDao.modifyBoard(conn, board);
			
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
		
		return resultRow;
		
	}
	
	
	// 게시글 삭제하기
	public int removeBoard(Board board) {
		
		int resultRow = 0;
		
		Connection conn = null;
		
		try {
			
			conn = DBUtil.getConnection();
			this.boardDao = new BoardDao();
			
			resultRow = this.boardDao.removeBoard(conn, board);
			
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
		
		return resultRow;
		
	}

	
	
	
	
}
