package co.edu.common;

public class MemberService {

	//컨트롤러 역할(MVC Model1)
	
	
	//싱글톤
	private static MemberService instance = new MemberService();
	private MemberService() {
		
	}
	public static MemberService getInstance() {
		return instance;
	}
	
	
	MemberDAO dao = new MemberDAO();
	//입력기능 /삭제기능 /수정기능 / 입력, 삭제 / 입력, 수정/.... 같이 memberDAO에서 최대한 세분화한다
	public void memberAdd(MemberVO vo) {
		dao.insertMember(vo);
		
	}
	
}
