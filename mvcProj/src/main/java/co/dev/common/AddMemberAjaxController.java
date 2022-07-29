package co.dev.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class AddMemberAjaxController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//회원정보 등록 -> Json타입 값 반환
		 resp.setContentType("text/json;charset=UTF-8");
		 
		 MemberService service=MemberService.getInstance();

	     //입력 -> 뷰페이지 
	      String id = req.getParameter("id");
	      String pw=req.getParameter("passwd");
	      String nm=req.getParameter("name");
	      String ml=req.getParameter("mail");
	      
	      MemberVO vo = new MemberVO();
	      
	      vo.setId(id);
	      vo.setName(nm);
	      vo.setPasswd(pw);
	      vo.setMail(ml);
	      
	      service.addMember(vo);
	      
	      //결과값을 Json타입으로 반환
	      	//goson -> json 쉽게 쓰게 해주는 라이브러리 
	      Gson gson = new GsonBuilder().create();
	      try {
			resp.getWriter().print(gson.toJson(vo)); //id, name, passwd, mail 
		} catch (IOException e) {
			e.printStackTrace();
		}
	      
	}

}
