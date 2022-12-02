package conn.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import conn.dao.BoardDao;
import conn.domain.BoardVO;
import conn.service.BoardService;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {

	private BoardService service;
	
	@Override
	public void init() throws ServletException {
		BoardDao dao = new BoardDao();
		service = new BoardService(dao);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		String contextPath = request.getContextPath();
		final String PRIFIX = "/WEB-INF/views/board/";
		final String SUFFIX = ".jsp";
		
		RequestDispatcher rd = null;
		String nextPage = null;
		
		// 글목록
		if(pathInfo==null || pathInfo.equals("/") || pathInfo.equals("/list")) {
			List<BoardVO> boardList = service.boardList();
			request.setAttribute("list", boardList);
			nextPage = "list";
		}
		
		// 글상세
		else if(pathInfo.equals("/detail")) {
			String parambno = request.getParameter("bno");
			int bno = Integer.parseInt(parambno);
			BoardVO board = service.findBoard(bno);
			request.setAttribute("board", board);
			nextPage = "detail";
		}
		
		// 글쓰기폼
		else if(pathInfo.equals("/writeForm")) {
			nextPage = "writeForm";
		}
		
		// 글쓰기 처리
		else if(pathInfo.equals("/write")) {
			Map<String, String> req = getMultipartRequest(request);
			String imageFileName = req.get("imageFileName");
			
			BoardVO vo = BoardVO.builder()
					.title(req.get("title"))
					.content(req.get("content"))
					.writer(req.get("writer"))
					.imageFileName(req.get("imageFileName"))
					.build();
			int boardNo = service.addBoard(vo);

			// 이미지파일을 첨부한 경우
			if(imageFileName!=null && imageFileName.length()>0) {
				File srcFile = new File("c:/file_repo/temp",imageFileName);
				File destFile = new File("c:/file_repo/"+boardNo);
				destFile.mkdirs();
				FileUtils.moveFileToDirectory(srcFile, destFile, false);
			}
			
			response.sendRedirect(contextPath+"/board");
			return;
		}
		
		else {
			System.out.println("존재하지 않는 페이지");
		}
		
		rd = request.getRequestDispatcher(PRIFIX+nextPage+SUFFIX);
		rd.forward(request, response);
		
	}
	
	private Map<String ,String> getMultipartRequest(HttpServletRequest request) {
		Map<String, String> boardMap = new HashMap<>();
		File currentDirPath = new File("c:/file_repo/temp");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload repository = new ServletFileUpload(factory);
		repository.setFileSizeMax(1024*1024*10); // 10MB
		
		try {
			List<FileItem> items = repository.parseRequest(request);
			for(FileItem item : items) {
				if(item.isFormField()) { // 파일이 아니면
					boardMap.put(item.getFieldName(), item.getString("utf-8"));
				} else { // 파일이면
					if(item.getSize()>0) {
						String fileName = item.getName(); // 파일이름
						boardMap.put(item.getFieldName(), fileName);
						File uploadFile = new File(currentDirPath, fileName);
						item.write(uploadFile);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardMap;
		
	}

}