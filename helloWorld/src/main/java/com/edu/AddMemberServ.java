package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addMember")
public class AddMemberServ extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자가 값 입력 : user_name=user2&user_pass=1234&role=1 
			//user_name : 위 페이지를 요청하면서 넘어오는 파라메터
		String name = req.getParameter("user_name");
		String pass = req.getParameter("user_pass");
		String role = req.getParameter("role");
		System.out.println(name+","+ pass+","+ role);
		
		//get 방식으로 요청들어오면 : 수정 기능 만들기 / post 방식으로 요청들어오면 : 입력 기능
		EmpDAO dao = new EmpDAO();
		if(req.getMethod().toUpperCase().equals("GET")) { //가지고오는 값이 소문자인지 대문자인지 몰라서 대문자로 바꿔서 비교
			//get으로 요청오면 업데이트, post로 요청오면 추가 하겠다.
			dao.updateMember(name, pass, role);
			int up =dao.updateMember(name, pass, role);
			if(up<1) {
				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter out = resp.getWriter();
				System.out.println("수정 실패");
				out.println("<script>alert('정보 수정에 실패하였습니다.');</script>");
				out.flush();
			}else {
				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter out = resp.getWriter();
				System.out.println("수정 완료");
				out.println("<script>alert('정보 수정이 완료되었습니다.');</script>");
				out.flush();
			}
		} else {
			dao.insertMember(name, pass, role);
			int up =dao.updateMember(name, pass, role);
			if(up<1) {
				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter out = resp.getWriter();
				System.out.println("전송 실패");
				out.println("<script>alert('등록에 실패하였습니다.');</script>");
				out.flush();
			}else {
				resp.setContentType("text/html;charset=UTF-8");
				PrintWriter out = resp.getWriter();
				System.out.println("전송 완료");
				out.println("<script>alert('정상적으로 등록되었습니다.');</script>");
				out.flush();
			}
		}
		//db에 입력
//		EmpDAO dao = new EmpDAO();
//		dao.insertMember(name, pass, role);
		
//		resp.getWriter().print("Completed.");
		
	}
}
