package com.edu.boot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.boot.common.Service;

public class MainService implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse reponse) {

		HttpSession session = null;

		session = request.getSession();

		System.out.println(session);

		if (session.isNew() || session == null || session.getAttribute("id") == null
				|| session.getAttribute("id").equals("")) {
			return "login.jsp";

		} else {
			return "main.jsp";

		}
	}

}
