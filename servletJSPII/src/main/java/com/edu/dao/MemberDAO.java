package com.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.edu.beans.Member;

public class MemberDAO {
	Connection conn;
	PreparedStatement psmt;

	public Connection getConnection() {
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
			System.out.println("connected.");
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void close() {
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertMember(Member member) {
		conn = getConnection();
		String sql = "insert into member values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getPasswd());
			psmt.setString(4, member.getMail());

			int r = psmt.executeUpdate();
			System.out.println(r + " 건 입력.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
