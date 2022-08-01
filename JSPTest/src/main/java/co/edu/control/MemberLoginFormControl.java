package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;

public class MemberLoginFormControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpUtil.forward(req, resp, "member/memberLoginForm.tiles");	//tiles라는 요청이 들어오면 web.xml에 TilesServlet으로 연결되게 해놨음
		//board라는 폴더밑에 게시판 관련 jsp들어오도록! 
	}

}
