package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Board;

public class BoardDao {

	// 검색 기능 포함
	// 게시판 전체 출력
	// boardList.jsp , BoardListController.java
	public ArrayList<Board> selectBoardListByPage(Connection conn, String searchText, int beginRow, int endRow) throws Exception {
		
		ArrayList<Board> list = new ArrayList<Board>();
		
		String sql = "SELECT t2.board_no boardNo, t2.board_title boardTitle, createdate"
				+ "	 FROM (SELECT rownum rnum, t.board_no, t.board_title, createdate"
				+ "		 FROM (SELECT board_no, board_title, createdate"
				+ "			 FROM board"
				+ "			 WHERE board_title LIKE ?"
				+ "			 ORDER BY board_no DESC) t) t2"
				+ "	 WHERE rnum BETWEEN ? AND ?";	// --WHERE rnum >= ? AND Rnum <= ?
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,  "%" + searchText + "%");
		stmt.setInt(2,  beginRow);
		stmt.setInt(3, endRow);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Board b = new Board();
			b.setBoardNo(rs.getInt("boardNo"));
			b.setBoardTitle(rs.getString("boardTitle"));
			b.setCreatedate(rs.getString("createdate"));
			list.add(b);
		}
		
		return list;
	}
	
	
	// 게시글 추가
	public int insertBoard(Connection conn, Board board) {
		
		int resultRow = 0;
		
		String sql = "INSERT INTO board {"
				+ "			board_no boardNo"
				+ "			, board_title boardTitle"
				+ "			, board_content boardContent"
				+ "			, member_id memberId"
				+ "			, updatedate"
				+ "			, createdate"
				+ "		) VALUES ("
				+ "			board_seq.nextval"
				+ "			, ?"
				+ "			, ?"
				+ "			, ?"
				+ "			, sysdate"
				+ "			, sysdate"
				+ "		)";
		
		return resultRow;
		
	}
	
	// 검색 후 게시글 총 카운트
	// boardList.jsp , BoardService.java -> pageBoard()
	public int countBoard(Connection conn, String searchText) throws Exception {
		
		int resultCount = 0;
		
		String sql = "SELECT COUNT(board_no) cnt"
				+ "	 FROM board"
				+ "	 WHERE board_title LIKE ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + searchText + "%");
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			resultCount = rs.getInt("cnt");
		}
		
		// 디버깅
		System.out.println(resultCount + " <-- resultCount");
		
		return resultCount;
		
	}
	
	
	// 게시글 한개 상세보기
	// boardOne.jsp , BoardOneController.java
	public Board selectBoardOne(Connection conn, int boardNo) throws Exception {
		
		Board resultBoard = null;
		
		String sql = "SELECT board_no boardNo"
				+ "			, board_title boardTitle"
				+ "			, board_content boardContent"
				+ "			, member_id memberId"
				+ "			, updatedate"
				+ "			, createdate"
				+ "	 FROM board"
				+ "	 WHERE board_no = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, boardNo);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			resultBoard = new Board();
			resultBoard.setBoardNo(rs.getInt("boardNo"));
			resultBoard.setBoardTitle(rs.getString("boardTitle"));
			resultBoard.setBoardContent(rs.getString("boardContent"));
			resultBoard.setMemberId(rs.getString("memberId"));
			resultBoard.setUpdatedate(rs.getString("updatedate"));
			resultBoard.setCreatedate(rs.getString("createdate"));
			
		}
		
		
		return resultBoard;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
