package fileupload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadServlet() {
		super();
	}

	// cache 타입
	private class Node {
		String filename;
		int filepos;
		int filelength;
		StringBuffer data;
		Date lastupdated;
	}

	private static List<Node> memory = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// flyweight 타입
		if (memory == null) {
			memory = new LinkedList<>();
			// cache 가비지 컬렉션
			Executors.newSingleThreadExecutor().execute(() -> {
				while (true) {
					try {
						synchronized (memory) {
							for (int i = 0; i < memory.size(); i++) {
								Date now = new Date();
								// 최종 업데이트가 10초 이상 되면 파일 업데이트 실패로 간주, 제거한다.
								if (now.getTime() - memory.get(i).lastupdated.getTime() > 10000) {
									System.out.println("제거!!");
									memory.remove(i);
									i--;
								}
							}
						}
						// 10초 단위로 실행
						Thread.sleep(10000);
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}
			});
		}

		Node node = null;
		// 파라미터 타입
		String filename = request.getParameter("filename");
		String filelength = request.getParameter("filelength");
		String filepos = request.getParameter("filepos");
		String data = request.getParameter("data");
		// cache에 같은 filename의 업데이트 등록 내용이 있나 확인, 없으면 생성한다.
		synchronized (memory) {
			// 검색
			for (Node n : memory) {
				if (n.filename.equals(filename)) {
					node = n;
					break;
				}
			}
			// 생성
			if (node == null) {
				memory.add(node = new Node());
				node.filename = filename;
				node.data = new StringBuffer();
			}
		}

		// 업데이트 정보 등록
		node.filelength = Integer.parseInt(filelength);
		node.filepos = Integer.parseInt(filepos);
		node.lastupdated = new Date();

		// base64를 연결해서 등록한다.
		node.data.append(data);

		// 입력 위치와 파일 사이즈가 넘어서면 파일을 만든다.
		if (node.filepos >= node.filelength) {
			// cache에서 제거한다.
			synchronized (memory) {
				memory.remove(node);
			}
			// base64 타입의 문자열을 byte 배열의 binary로 변경
			byte[] binary = Base64.getDecoder().decode(node.data.toString());
			// 그대로 파일로 생성한다.
			try (FileOutputStream stream = new FileOutputStream("c:\\tmp\\" + filename)) {
				stream.write(binary, 0, binary.length);
			}
			response.getWriter().write("{\"ret\":\"complete\"}");
		} else {
			response.getWriter().write("{\"ret\":\"continue\"}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
