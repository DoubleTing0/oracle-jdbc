package util;

import java.sql.*;	

public class DBUtil {
	
	// DB 연결하는 메서드
	public static Connection getConnection() {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUser = "gdj58";
		String dbPw = "java1234";
		
		Connection conn = null;
		
		try {
			
			// 드라이버 로딩
			Class.forName(driver);
			
			// DB 접속
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
			
			conn.setAutoCommit(false);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return conn;
		
	}
	
	// DB 연결 종료하는 메서드
	public void close(ResultSet rs, PreparedStatement stmt,Connection conn) {
		
		try {
			
			if(rs != null) {
				rs.close();
			}
			
			if(stmt != null) {
				stmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
