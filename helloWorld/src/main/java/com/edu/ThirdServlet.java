package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.EmpDAO;
import com.edu.common.Employee;

@WebServlet("/third.do")
public class ThirdServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청정보 : 질의문자열(키=값)	-> 키와 값이 쌍으로 들어가있는 코드 
		//		third.do?key=Steven
		//질의문자열 -> 사용자가 입력한 값이 무엇인가를 볼 수 있는 것
		//질의문자열 ex=> Query String : name=Hong&age=25
		String value = req.getParameter("key"); //-> 키와 값이 쌍으로 들어가있는 코드넣어주는 변수
		resp.setContentType("text/html;charset=UTF-8");
		
		EmpDAO dao = new EmpDAO();
		List<Employee> list =dao.getEmpInfo(value);
		
		PrintWriter out = resp.getWriter();
		
		out.print("<table border='1'>");
		out.print("<thead><tr><th>사원번호</th><th>성씨</th><th>이름</th><th>이메일</th><th>입사일자</th><th>급여</th><th>직무</th></tr></thead>");
		out.print("<tbody>");
		for(Employee emp : list) {
			out.print("<tr><td>"+emp.getEmployeeId()+"</td>"
			+"<td>"+emp.getLastName()+"</td>"
			+"<td>"+emp.getFirstName()+"</td>"
			+"<td>"+emp.getEmail()+"</td>"
			+"<td>"+emp.getHireDate()+"</td>"
			+"<td>"+emp.getSalary()+"</td>"
			+"<td>"+emp.getJobId()+"</td></tr>");
		}
		out.print("</tbody>");
		out.print("</table>");
	}
}
