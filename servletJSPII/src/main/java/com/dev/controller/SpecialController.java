package com.dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpecialController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		HttpUtil.forward(request, response, "WEB-INF/spec.jsp");

	}

}
