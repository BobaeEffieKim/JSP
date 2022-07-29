package com.edu.test.jstl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.test.dao.CustomDAO;
import com.edu.test.dao.EmployeeVO;

@WebServlet("/jstlServlet01")
public class JstlServlet01 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomDAO dao = new CustomDAO();
		List<EmployeeVO> list = dao.getEmpList();

		req.setAttribute("data", list);

		RequestDispatcher rd = req.getRequestDispatcher("jsp/jstl01.jsp");
		rd.forward(req, resp);

	}
}
