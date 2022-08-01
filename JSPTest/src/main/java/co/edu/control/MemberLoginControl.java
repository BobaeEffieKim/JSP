package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.vo.MemberVO;

public class MemberLoginControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberService service = MemberService.getInstance();
		
		String id = req.getParameter("memberId");
		String password = req.getParameter("memberPasswd");
		
		MemberVO vo = service.searchMember(id);
		
		// 로그인 실패 시 memberLoginFail.jsp로 이동.
		if(vo ==null || !password.equals(vo.getMemberPasswd())) {
			HttpUtil.forward(req, resp, "member/memberLoginFail.tiles");
		} else {
		// 로그인 성공 시 memberLoginSuccess.jsp로 이동.
			req.setAttribute("member", vo);
			HttpUtil.forward(req, resp, "member/memberLoginSuccess.tiles");
		
		}
	}

}
