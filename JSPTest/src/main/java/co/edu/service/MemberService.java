package co.edu.service;

import java.util.List;

import co.edu.dao.BoardDAO;
import co.edu.dao.MemberDAO;
import co.edu.vo.BoardVO;
import co.edu.vo.MemberVO;

public class MemberService {
	
	MemberDAO dao = new MemberDAO();
	BoardDAO bdao = new BoardDAO();
	private static MemberService instance = null;
	private MemberService() {}
	
	public static MemberService getInstance() {
		if(instance == null){
			instance = new MemberService();
		}
		
		return instance;
	}
	
	//회원가입
	public void addMember(MemberVO vo) {
		dao.insertMember(vo);
	}
	
	//회원찾기
	public MemberVO searchMember(String id) {
		return dao.searchMember(id);
	}
	
	public void addBoard(BoardVO vo) {
		bdao.insertBoard(vo);
	}
	
	public List<BoardVO> getList(){
		return bdao.boardList();
	}
}
