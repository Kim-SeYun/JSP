package sec01.ex01;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/upload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		System.out.println(title);
		System.out.println(content);
		System.out.println(writer);
		
		// 파일 업로드 경로
		File fileRepository = new File("c:/file_repo");
		
		// 전송된 파일을 임시 메모리에 저장하기 위한 객체
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 전송된 파일의 업로드 크기 설정, 요청정보의 파라미터 및 파일을 가져올 수 있음
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(1024*1024*10); // 업로드 파일 최대 크기 : 10MB
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem item : items) {
				if(item.isFormField()) { // 파일이 아니면, 즉 일반적인 폼필드이면
					String fieldName = item.getFieldName(); // input name 속성 
					String value = item.getString("utf-8"); // input value 속성
					System.out.println(fieldName + " : " + value);
				} else { // 파일이면
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					long fileSize = item.getSize();
					System.out.println("필드이름 : " +fieldName);
					System.out.println("파일이름 : " +fileName);
					System.out.println("파일크기 : " +fileSize);
					System.out.println("=====================");
					
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
	}

}
