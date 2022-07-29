package com.dev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberService service = MemberService.getInstance();
		List<MemberVO> list = service.memberList();

		request.setAttribute("list", list);

		HttpUtil.forward(request, response, "member/memberListOutput.tiles");
	}

}