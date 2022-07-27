package co.dev.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;

public class MemberListController implements Controller {

   @Override
   public void execute(HttpServletRequest req, HttpServletResponse resp) {
      MemberService service = MemberService.getInstance();
      
      req.setAttribute("list", service.memberList()); // list라는 변수에service.memberList()라는 변수 담아서
//
//      RequestDispatcher rd = req.getRequestDispatcher("memberResult/memberListOutput.jsp");// <=페이지로 위의 멤버에 담아준 어트리뷰트 속성 vo를 전송
//      try {
//         rd.forward(req, resp);
//      } catch (Exception e) {
//         e.printStackTrace();
//      }
      
      Utils.forward(req, resp, "memberResult/memberListOutput.jsp");
      
   }

}