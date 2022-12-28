package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.BoardDao;
import dao.MemberDao;
import util.DBUtil;
import vo.Board;
import vo.Member;

public class MemberService {

	private MemberDao memberDao;
	
	// 로그인 체크
	public Member loginCheck(String memberId, String memberPw) {
		
		Member resultMember = null;
		
		Connection conn = null;
		
		try {
			
			conn = DBUtil.getConnection();
			
			this.memberDao = new MemberDao();
			resultMember = this.memberDao.loginCheck(conn, memberId, memberPw);
			
			// SELECT라 commit X
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return resultMember;
		
	}
	
	
	// 회원가입
	// 추후에 중복체크
	public int addMember(Member member) {
		
		int resultRow = 0;
		
		Connection conn = null;
		
		try {
			
			conn = DBUtil.getConnection();
			this.memberDao = new MemberDao();
			
			resultRow = this.memberDao.addMember(conn, member);
			
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
	
	// 회원 정보 수정
	// 추후에 비밀번호 확인 및 ID 중복 체크 후 수정 가능하도록
	public int modifyMember(Member member) {
		
		int resultRow = 0;
		
		Connection conn = null;
		
		try {
			
			conn = DBUtil.getConnection();
			this.memberDao = new MemberDao();
			
			resultRow = this.memberDao.modifyMember(conn, member);
			
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
