package co.edu.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.service.MemberService;
import co.edu.vo.BoardVO;

public class InsertBoardControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String title = req.getParameter("title");
		String content= req.getParameter("content");
		String writer = req.getParameter("writer");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		
		MemberService service = MemberService.getInstance();
		service.addBoard(vo);
		
		HttpUtil.forward(req, resp, "board/addBoardOutput.tiles");

	}

}
