<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<c:set var="a" value="${article}"/>
<div class="container">
	<div class="jumbotron mb-3">
		<h1>글수정</h1>
	</div>

	<form action="${contextPath}/board/modArticle" method="post">
		<input type="hidden" value="${a.bno}" name="bno">
		<div class="form-group">
 			<label for="title">제목:</label>
  			<input type="text" class="form-control" id="title" name="title" value="${a.title}">
		</div>
		
		<div class="form-group">
 			 <label for="content">내용:</label>
  			<textarea class="form-control" rows="5" id="content" name="content">${a.content}</textarea>
		</div>
		
		<div class="form-group">
 			<label for="writer">작성자:</label>
  			<input type="text" class="form-control" id="writer" name="writer" value="${a.writer}" readonly="readonly">
		</div>
		<button class="btn btn-primary">수정하기</button>
		<a class="btn btn-secondary">목록으로</a>
		
		
	</form>
</div>


<%@ include file="../layout/footer.jsp" %>
