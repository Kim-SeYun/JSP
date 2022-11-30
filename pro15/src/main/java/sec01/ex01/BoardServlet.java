package sec01.ex01;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/board")
public class BoardServlet extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> boardReqMap = getMultipartRequest(request);
		String title = boardReqMap.get("title");
		String content = boardReqMap.get("content");
		String writer = boardReqMap.get("writer");
		
		System.out.println("제목 : " + title);
		System.out.println("내용 : " + content);
		System.out.println("작성자 : " + writer);
	}
	
	private Map<String, String> getMultipartRequest(HttpServletRequest request) throws ServletException, IOException {
		Map<String, String> multipartReq = new HashMap<>();
		
		File fileRepository = new File("c:/file_repo");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(1024*1024*10); 
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem item : items) {
				if(item.isFormField()) { // 파일이 아니면, 즉 일반적인 폼필드이면
					multipartReq.put(item.getFieldName(), item.getString("utf-8"));
				} else {
					String fileName = item.getName();
					
					if(item.getSize()>0) {
						File uploadFile = new File(fileRepository, fileName);
						// c:/file_repo/뱅갈호랑이.png
						item.write(uploadFile);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return multipartReq;
	}

}
