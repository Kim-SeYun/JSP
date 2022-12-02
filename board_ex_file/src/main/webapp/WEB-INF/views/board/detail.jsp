<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>  
  

<div class="container">
	<div class="jumbotron">
		<h1>글상세</h1>
	</div>
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${board.bno}</td>
			<th>조회수</th>
			<td>000</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer}</td>
			<th>작성일</th>
			<td>${board.writedate}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				<textarea rows="10" class="form-control" readonly="readonly">${board.content}</textarea>
			</td>
		</tr>
		<tr>
			<th>첨부이미지</th>
			<td colspan="3">
				<div>
				<c:if test="${not empty board.imageFileName}">
					<img src="${contextPath}/fileDownload?bno=${board.bno}&imageFileName=${board.imageFileName}">
				</c:if>
				<c:if test="${empty board.imageFileName}">
					<p>등록된 이미지가 없습니다.</p>
				</c:if>
				</div>
			</td>
		</tr>
	</table>

</div>

<%@ include file="../layout/footer.jsp" %>  