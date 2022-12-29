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
	public ArrayList<Board> selectBoardListByPage(Connection conn, String searchCategory, String searchText, int beginRow, int endRow) throws Exception {
		
		ArrayList<Board> list = new ArrayList<Board>();
		
		String sql = "SELECT t2.board_no boardNo, t2.board_title boardTitle, t2.member_id memberId, t2.createdate"
				+ "	 FROM (SELECT rownum rnum, t.board_no, t.board_title, t.member_id, t.createdate"
				+ "		 FROM (SELECT board_no, board_title, member_id, createdate"
				+ "			 FROM board"
				+ "			 WHERE " + searchCategory + " LIKE ?"
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
			b.setMemberId(rs.getString("memberId"));
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
	public int countBoard(Connection conn, String searchCategory, String searchText) throws Exception {
		
		int resultCount = 0;
		
		String sql = "SELECT COUNT(board_no) cnt"
				+ "	 FROM board"
				+ "	 WHERE " + searchCategory + " LIKE ?";
		
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
	
	
	// 게시글 입력하기
	// boardList.jsp , BoardListController.java
	public int addBoard(Connection conn, Board board) throws Exception {
		
		int resultRow = 0;
		
		String sql = "INSERT INTO board ("
				+ "		board_no"
				+ "		, board_title"
				+ "		, board_content"
				+ "		, member_id"
				+ "		, updatedate"
				+ "		, createdate"
				+ "	) VALUES ("
				+ "		board_seq.nextval"
				+ "		, ?"
				+ "		, ?"
				+ "		, ?"
				+ "		, SYSDATE"
				+ "		, SYSDATE"
				+ ")";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, board.getBoardTitle());
		stmt.setString(2, board.getBoardContent());
		stmt.setString(3, board.getMemberId());
		
		resultRow = stmt.executeUpdate();
		
		if(resultRow == 1) {
			System.out.println("게시글 입력 성공!");
		} else {
			System.out.println("게시글 입력 실패!");
		}
		
		return resultRow;
		
	}
	
	
	// 게시글 수정하기
	public int modifyBoard(Connection conn, Board board) throws Exception {
		
		int resultRow = 0;
		
		String sql = "UPDATE board"
				+ "	 SET board_title = ?"
				+ "		, board_content = ?"
				+ "		, updatedate = SYSDATE"
				+ "	 WHERE board_no = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, board.getBoardTitle());
		stmt.setString(2, board.getBoardContent());
		stmt.setInt(3, board.getBoardNo());
		
		resultRow = stmt.executeUpdate();
		
		if(resultRow == 1) {
			System.out.println("게시글 수정 성공!");
		} else {
			System.out.println("게시글 수정 실패!");
		}
		
		
		return resultRow;
		
	}
	
	
	// 게시글 삭제하기
	public int removeBoard(Connection conn, Board board) throws Exception {
		
		int resultRow = 0;
		
		String sql = "DELETE"
				+ "	 FROM board"
				+ "	 WHERE board_no = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, board.getBoardNo());
		
		resultRow = stmt.executeUpdate();
		
		if(resultRow == 1) {
			System.out.println("게시글 삭제 성공!");
		} else {
			System.out.println("게시글 삭제 실패!");
		}
		
		
		return resultRow;
		
	}
	
	
	
	
	
	
	
}
