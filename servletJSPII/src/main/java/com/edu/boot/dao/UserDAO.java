package com.edu.boot.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.boot.common.DAO;
import com.edu.boot.common.DbInterface;
import com.edu.boot.vo.UserVO;

public class UserDAO extends DAO implements DbInterface<UserVO> {
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public ArrayList<UserVO> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO select(UserVO vo) {
		String sql = "select * from b_users where id = ?";
		UserVO user = new UserVO();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int insert(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
