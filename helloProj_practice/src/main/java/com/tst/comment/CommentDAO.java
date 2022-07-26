package com.tst.comment;

import java.sql.SQLException;

import com.tst.common.DAO;

public class CommentDAO extends DAO{

	public void insertComment(CommentVO vo) {
		
		String sql ="insert into comments "
				+ "values(?,(select nvl(max(comment_id),0)+1 from comments), "
				+ "? ,? ,sysdate)";
		connect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBoardId());
			pstmt.setString(2, vo.getCommentContent());
			pstmt.setString(3, vo.getUserId());
			
			int r = pstmt.executeUpdate();
			System.out.println(r+"건 입력.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
}
