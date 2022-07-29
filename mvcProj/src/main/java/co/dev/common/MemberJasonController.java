package co.dev.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberJasonController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//Json형태의 데이터 
		//[{"name" : "hong", "age" : 15}, {"name" : "hwang", "age" : 25}] 
		resp.setContentType("text/json;charset=UTF-8");
		
		MemberService service = MemberService.getInstance();
		List<MemberVO> members = service.memberList();
		
		String json = "[{\"name\" : \"hong\", \"age\" : 15}, {\"name\" : \"hwang\", \"age\" : 25}]";
		
		
		JsonArray jary = new JsonArray();
		for(MemberVO vo : members) {
		JsonObject jobj = new JsonObject();
		jobj.addProperty("id",vo.getId());
		jobj.addProperty("name", vo.getName());
		jobj.addProperty("passwd", vo.getPasswd());
		jobj.addProperty("mail", vo.getMail());
		
		//jary 추가
		jary.add(jobj);
		
		}
		
		try {
			resp.getWriter().print(jary);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
