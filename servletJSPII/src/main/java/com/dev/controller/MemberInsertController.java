package com.dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");

		if (id.isEmpty() || passwd.isEmpty() || name.isEmpty() || mail.isEmpty()) {
			request.setAttribute("error", "모든 항목입력하세요!");
			HttpUtil.forward(request, response, "memberView/memberInsert.jsp");
			return;
		}

		MemberVO member = new MemberVO();
		member.setId(id);
		member.setName(name);
		member.setPasswd(passwd);
		member.setMail(mail);

		MemberService service = MemberService.getInstance();
		service.memberInsert(member);

		request.setAttribute("id", id);
		HttpUtil.forward(request, response, "memberResult/memberInsertOutput.jsp");
	}

}