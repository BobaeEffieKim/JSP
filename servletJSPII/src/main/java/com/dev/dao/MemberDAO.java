package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.dev.vo.MemberVO;

public class MemberDAO {
	private static MemberDAO dao = new MemberDAO();

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		return dao;
	}

	public Connection connect() {
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

	public void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
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

	// 입력
	public void memberInsert(MemberVO member) {
		conn = connect();
		String sql = "insert into member(id, name, passwd, mail) values(?,?,?,?)";

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

	// 조회
	public MemberVO memberSearch(String id) {
		conn = connect();
		String sql = "select * from member where id = ?";
		MemberVO member = new MemberVO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				member.setId(rs.getString("id"));
				member.setMail(rs.getString("mail"));
				member.setName(rs.getString("name"));
				member.setPasswd(rs.getString("passwd"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return member;
	}

	// 수정
	public void memberUpdate(MemberVO member) {
		conn = connect();
		String sql = "update member set passwd=?, name=?, mail=? where id=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getPasswd());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getMail());
			psmt.setString(4, member.getId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 삭제
	public void memberDelete(String id) {
		conn = connect();
		String sql = "delete from member where id=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제.");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close();

		}
	}

	// 리스트
	public List<MemberVO> memberList() {
		conn = connect();
		String sql = "select id, name, passwd, mail from member order by 1";
		List<MemberVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setMail(rs.getString("mail"));
				member.setName(rs.getString("name"));
				member.setPasswd(rs.getString("passwd"));
				list.add(member);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}
}
