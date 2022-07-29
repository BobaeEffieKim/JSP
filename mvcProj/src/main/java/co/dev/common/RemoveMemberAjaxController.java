package co.dev.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;

public class RemoveMemberAjaxController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		//삭제 처리 -> json반환
		resp.setContentType("text/json;charset=utf-8");
		String id = req.getParameter("id");
		
		MemberService service = MemberService.getInstance();
		boolean isDeleted = service.removeMember(id); //메소드든 함수든 -> 반환값, 매개변수가 제일 중요!
		
		// {"retCode" : "Success"}
		try {
			
			if(isDeleted)
				resp.getWriter().print("{\"retCode\" : \"Success\"}");
			else
				resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
