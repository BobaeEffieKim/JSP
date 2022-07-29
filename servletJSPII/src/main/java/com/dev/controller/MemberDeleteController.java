package com.dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;

public class MemberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");

		MemberService service = MemberService.getInstance();
		service.memberDelete(id);

		HttpUtil.forward(request, response, "memberResult/memberDeleteOutput.jsp");
	}

}
