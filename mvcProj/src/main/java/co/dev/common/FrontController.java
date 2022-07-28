package co.dev.common;

//컨트롤러 페이지
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class FrontController extends HttpServlet {
   String enc;
   Map<String, Controller> mappings; //1.mappings라는 객체에다가 요청 url과 Controller를 담겠다
   
   @Override
   public void init(ServletConfig config) throws ServletException {
//      config.getInitParameter(getServletName())
      enc = config.getInitParameter("charset"); // enc = encoding
      
      mappings = new HashMap<>();//2.push로 담아주기
      mappings.put("/memberInsert.do", new MemberInsertController());//Controller가 구현하는 객체를 실행할것
      //path값이 위의 값                                               //MemberInsertController()<=구현객체
      mappings.put("/memberList.do", new MemberListController());
      mappings.put("/memberSearch.do", new MemberSearchController());
      mappings.put("/memberUpdate.do", new MemberUpdateController());
      mappings.put("/memberDelete.do", new MemberDeleteController());
      mappings.put("/memberJason.do", new MemberJasonController());
   }

   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setCharacterEncoding(enc);

      String uri = req.getRequestURI(); // context
      System.out.println(uri); // /mvcProj/*.do

      // 잠시 확인하는용
      String contextPath = req.getContextPath();
      System.out.println(contextPath); // /mvcProj
      String path = uri.substring(contextPath.length()); // uri - contextPath길이만큼 뺀 값을 substring함
      System.out.println(path); // 요청하는 페이지 정보 가져와보기 /*.do => path에 memberInsert 넣으면 /memberInsert.do가 됨
      
      //3.해당되는 controller타입을 매칭시켜줌 = path
      Controller cntr = mappings.get(path);
      cntr.execute(req,  resp);
      
      MemberService service = MemberService.getInstance();
      // 입력요청이 들어오면 -> 뷰페이지로 이동

      if (path.equals("/memberInsert.do")) {
   

      } else if (path.equals("/memberList.do")) {
         req.setAttribute("list", service.memberList()); // list라는 변수에service.memberList()라는 변수 담아서

         RequestDispatcher rd = req.getRequestDispatcher("memberResult/memberListOutput.jsp");// <=페이지로 위의 멤버에 담아준 어트리뷰트 속성 vo를 전송
         rd.forward(req, resp);
      }
   }
}