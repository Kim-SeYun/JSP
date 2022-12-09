<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp" %>  
<script src="${contextPath}/resources/js/detail.js"></script>
  

<div class="container">
	<div class="jumbotron">
		<h1>글상세</h1>
	</div>
	<form id="viewForm" enctype="multipart/form-data">
		<table class="table">
			<tr>
				<th>글번호</th>
				<td>
					${board.bno}
					<input type="hidden" name="bno" value="${board.bno}">
				</td>
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
				<td colspan="3">
				<input type="text" name="title" class="form-control" value="${board.title}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">
					<textarea rows="10" name="content" class="form-control" readonly="readonly">${board.content}</textarea>
				</td>
			</tr>
			<tr>
				<th>첨부이미지</th>
				<td colspan="3">
					<input type="file" name="imageFileName" class="form-control viewMode">
					<div class="my-2">
					<c:if test="${not empty board.imageFileName}">
						<input type="hidden" name="originFileName" value="${board.imageFileName}">
						<div class="preview">
							<img class="originImg" src="${contextPath}/fileDownload?no=${board.bno}&imageFileName=${board.imageFileName}&path=board">
						</div>
					</c:if>
					<c:if test="${empty board.imageFileName}">
						<div class="preview">
							<p>등록된 이미지가 없습니다.</p>
						</div>
					</c:if>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="4" class="text-center">
					<button type="button" class="btn btn-primary toModForm">수정</button>
					<button type="button" class="btn btn-warning remove">삭제</button>
					<button type="button" class="btn btn-success toList">목록</button>
				</td>
			</tr>
			<tr class="viewMode">
				<td colspan="4" class="text-center">
					<button type="button" class="btn btn-primary modify">수정</button>
					<button type="button" class="btn btn-danger backViewMode">취소</button>
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="../layout/footer.jsp" %>  

