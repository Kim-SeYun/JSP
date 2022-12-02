<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>  
  
<div class="container">
	<div class="jumbotron">
		<h1>글상세</h1>
	</div>
	
	<form action="${contextPath}/board/write" method="post" enctype="multipart/form-data">
		<div class="form-group">
			제목 : <input type="text" class="form-control" name="title">
		</div>
		<div class="form-group">
			내용 : <textarea rows="10" class="form-control" name="content"></textarea>
		</div>
		<div class="form-group">
			작성자 : <input type="text" class="form-control" name="writer">
		</div>
		<div class="form-group">
			첨부파일 : <input type="file" class="form-control" name="imageFileName">
		</div>
		<button class="btn btn-primary">글쓰기</button>
	</form>
	<div class="preview"></div>
</div>
<%@ include file="../layout/footer.jsp" %>  

<script>
$(function(){
	$('input[type="file"]').on('change', function(){
		console.log();
		if(this.files[0]) {
			let reader = new FileReader(); // 파일읽기 객체
			reader.onload = function(e){ // 파일을 읽으면 이벤트 발생
				let value = e.target.result
				if(value.startsWith("data:image/")) { // 이미지파일인경우
					let imgTag = "<img src='"+value+"'>";
					$('.preview').html(imgTag);
				} else { // 이미지파일이 아닌경우
					alert('이미지 파일만 등록하세요');
					$('input[name="imageFileName"]').val('');
					$('.preview').html('');
				}
			}
			reader.readAsDataURL(this.files[0]); // 파일 읽기 메소드 호출
		}
	});
});
</script>