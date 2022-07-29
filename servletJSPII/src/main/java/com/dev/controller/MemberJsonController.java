package com.dev.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberJsonController implements Controller {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("text/html;charset=UTF-8");

		MemberService service = MemberService.getInstance();
		List<MemberVO> list = service.memberList();

		JSONArray ary = new JSONArray();
		for (MemberVO vo : list) {
			JSONObject obj = new JSONObject();
			obj.put("id", vo.getId());
			obj.put("name", vo.getName());
			obj.put("ps", vo.getPasswd());
			obj.put("mail", vo.getMail());

			ary.add(obj);

		}

		HttpUtil.json(request, response, ary);
	}

}
