package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Member;

public class MemberDao {
	
	// 로그인 체크
	// login.jsp / LoginController
	public Member loginCheck(Connection conn, String memberId, String memberPw) throws Exception {
		
		Member resultMember = null;
		
		String sql = "SELECT member_id memberId"
				+ "			, member_pw memberPw"
				+ "			, member_name memberName"
				+ "	 FROM member"
				+ "	 WHERE member_id = ? AND member_pw = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, memberId);
		stmt.setString(2, memberPw);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			resultMember = new Member();
			resultMember.setMemberId(rs.getString("memberId"));
			resultMember.setMemberName(rs.getString("memberName"));
		}
				
		
		return resultMember;
		
	}
	
	// 회원가입
	// 추후에 ID 중복체크 추가
	public int addMember(Connection conn, Member member) throws Exception {
		
		int resultRow = 0;
		
		String sql = "INSERT INTO member ("
				+ "			member_id"
				+ "			, member_pw"
				+ "			, member_name"
				+ "			, updatedate"
				+ "			, createdate"
				+ "	) VALUES ("
				+ "			?"
				+ "			, ?"
				+ "			, ?"
				+ "			, SYSDATE"
				+ "			, SYSDATE"
				+ ")";
				
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		stmt.setString(3, member.getMemberName());
		
		resultRow = stmt.executeUpdate();
		
		if(resultRow == 1) {
			System.out.println("회원가입 성공!");
		} else {
			System.out.println("회원가입 실패!");
		}
		
		return resultRow;
		
	}
	
	
	// 회원 정보 수정
	// 추후에 비밀번호 확인 후 수정 & ID 중복확인도 수정되도록
	public int modifyMember(Connection conn, Member member) throws Exception {
		
		int resultRow = 0;
		
		String sql = "UPDATE member "
				+ "	 SET member_name = ?"
				+ "	 WHERE member_id = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1,  member.getMemberName());
		stmt.setString(2, member.getMemberId());
		
		resultRow = stmt.executeUpdate();
		
		if(resultRow == 1) {
			System.out.println("회원정보 수정 성공!");
		} else {
			System.out.println("회원정보 수정 실패!");
		}
		
		return resultRow;
		
	}
	
	
	// 회원 삭제
	// 추후에 비밀번호 확인 후 삭제
	public int removeMember(Connection conn, Member member) throws Exception {
		
		int resultRow = 0;
		
		String sql = "DELETE member"
				+ "	 WHERE member_id = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, member.getMemberId());
		
		resultRow = stmt.executeUpdate();
		
		if(resultRow == 1) {
			System.out.println("회원 탈퇴 성공!");
		} else {
			System.out.println("회원 탈퇴 실패!");
		}
		
		return resultRow;
		
	}
	
	
	// 비밀번호 확인
	// 추후에 사용하는 곳 적기
	public boolean checkPassword(Connection conn, Member member) throws Exception {
		
		boolean result = false;
		
		String sql = "SELECT member_id"
				+ "	 FROM member"
				+ "	 WHERE member_id = ?"
				+ "		 AND member_pw = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			result = true;
		}
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
