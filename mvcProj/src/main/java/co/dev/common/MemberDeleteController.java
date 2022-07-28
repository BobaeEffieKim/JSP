package co.dev.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

//삭제컨트롤
public class MemberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		//파라미터
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String nm = req.getParameter("name");
		String ml = req.getParameter("mail");
		                              
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(pw);
		vo.setName(nm);
		vo.setMail(ml);
		
		/////////////////////////////////		
		MemberService service = MemberService.getInstance();
		service.removeMember(vo);
		
		//공유 : vo
		req.setAttribute("member", vo);
		Utils.forward(req, resp, "memberResult/memberDeleteOutput.jsp");
	}

}
