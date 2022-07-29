package com.dev.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {

	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) {
		RequestDispatcher rd = request.getRequestDispatcher(path);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void json(HttpServletRequest request, HttpServletResponse resp, Object jsonObj) {
		try {
			PrintWriter out = resp.getWriter();
			out.print(jsonObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
