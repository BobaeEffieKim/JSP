package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.ShareObject;

@WebServlet("/context3")
public class ServletContextTest3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletContext sc=this.getServletContext();	//ServletContext호출
		
		ShareObject obj1 = new ShareObject();
		obj1.setCount(100);
		obj1.setStr("객체 공유 테스트");
		
		//또다른 값을 담고 싶을때 
		ShareObject obj2 = new ShareObject();
		obj2.setCount(200);
		obj2.setStr("객체 공유 테스트2");
		
		
		sc.setAttribute("data", obj1);	//data속성을 읽어오면 obj1이 가지고있는 주소값 참조할 것이다
		sc.setAttribute("data2", obj2); //값 지정
		
		resp.getWriter().print("ServletContext object add.");
		
	}	//실행하면, attribute값 지정 됨 -> test4하면 값이 들어간 상태를 출력해서 볼 수 있음 
}
