package co.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.edu.vo.BoardVO;


public class BoardDAO {

	

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
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
			if(conn != null) conn.close();
			
		} catch(SQLException e) {	
			e.printStackTrace();
		}
	}
	
	
	//등록
		public void insertBoard(BoardVO vo) {
			
			String sql = "insert into test_board( seq, title, writer, content, write_date, visit_cnt) "
					+ "values( (BOARD_SEQ.nextval), ? , ? , ? , sysdate, 0)";
			connect();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getWriter());
				pstmt.setString(3, vo.getContent());
				
				int r = pstmt.executeUpdate();
				System.out.println(r+"건 입력.");
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
		
		//목록
		public List<BoardVO> boardList(){
			
			connect();
			String sql = "select * from test_board order by 1";
			List<BoardVO> list = new ArrayList<>();
			
			try {
				pstmt= conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					BoardVO vo = new BoardVO(rs.getInt("seq"), rs.getString("title"), rs.getString("writer"),
									rs.getString("content"), rs.getString("write_date"), rs.getInt("visit_cnt"));
					list.add(vo);
//					return list;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return list;
		}
		
		//단건조회
		public BoardVO getBoard(int seq) {
			String sql = "select * from test_board where seq = ?";
			connect();
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, seq);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					BoardVO vo = new BoardVO();
					vo.setSeq(rs.getInt("seq"));
					vo.setTitle(rs.getString("title"));
					vo.setWriter(rs.getString("writer"));
					vo.setContent(rs.getString("content"));
					vo.setWriteDate(rs.getString("write_date"));
					vo.setVisitCnt(rs.getInt("visit_cnt"));
					
					//카운트증가 메소드 호출
					setCnt(seq);
					
					return vo;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return null;
		}
		
		//조회수 
		public void setCnt(int seq) {
			String sql = "update test_board set visit_cnt=visit_cnt+1 where seq=?";
			connect();
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, seq);
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
		
		
		//글내용 수정
		public void updateBoard(BoardVO vo) {
			String sql = "update test_board set title=?, content=? where seq=?";
			connect();
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setInt(3, vo.getSeq());
				
				int r = pstmt.executeUpdate();	//쿼리실행
				System.out.println(r+"건 변경");
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
		
		//게시글 삭제
		public void deleteBoard(BoardVO vo) {
			String sql = "DELETE from test_board where seq=?";
			connect();
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, vo.getSeq());
				
				int r = pstmt.executeUpdate();
				System.out.println(r+"건 삭제.");
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
	
}
