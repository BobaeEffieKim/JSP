package co.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.edu.vo.MemberVO;

public class MemberDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Statement stmt;
	
	public void connect() {
		
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
			
		} catch(SQLException e) {	
			e.printStackTrace();
		}
	}
	
	
	public void insertMember(MemberVO vo) {
		
		String sql = "insert into test_member(id, passwd, name, address) "
				+ "values(?, ?, '?, ?)";
		connect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemberId());
			pstmt.setString(2, vo.getMemberPasswd());
			pstmt.setString(3, vo.getMemberName());
			pstmt.setString(4, vo.getMemberAddress());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("회원 가입이 완료되었습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
	public MemberVO searchMember(String id) {
		
		String sql = "select * from test_member where id='" +id+ "'";
		connect();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMemberId(rs.getString("id"));
				vo.setMemberPasswd(rs.getString("passwd"));
				vo.setMemberName(rs.getString("name"));
				vo.setMemberAddress(rs.getString("address"));
				return vo;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
}
