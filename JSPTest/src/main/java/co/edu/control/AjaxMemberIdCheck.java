package co.edu.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.service.MemberService;
import co.edu.vo.MemberVO;

public class AjaxMemberIdCheck implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberService service = MemberService.getInstance();
		
		String idCheck = req.getParameter("memberId");
		
		MemberVO vo = service.searchMember(idCheck);
		if(vo == null) {
			vo = new MemberVO();
			vo.setMemberId("");
		}

		PrintWriter out = resp.getWriter();
		if (idCheck.equals("user1")) {
			out.print("1");
		} else {
			out.print("0");
		}
	}

}
