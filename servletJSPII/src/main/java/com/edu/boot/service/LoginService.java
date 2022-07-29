package com.edu.boot.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.boot.common.Service;
import com.edu.boot.dao.UserDAO;
import com.edu.boot.vo.UserVO;

public class LoginService implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse reponse) {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(passwd);
		
		System.out.println(vo);

		UserDAO dao = new UserDAO();
		UserVO user = dao.select(vo);

		request.setAttribute("user", user);

		return "main.jsp";
	}

}
