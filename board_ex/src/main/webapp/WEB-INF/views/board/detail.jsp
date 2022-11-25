<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container">
	<div class="jumbotron my-3">
		<h1>게시글 조회</h1>
	</div>
	<div class="card mb-3">
	    <div class="card-header">
	    	${article.title}
	    </div>
	    <div class="card-body">
	    	${article.content}
	    </div> 
	    <div class="card-footer d-flex justify-content-between">
			<div>
	    	<span class="badge badge-primary">${article.writer}</span>
			<span class="badge badge-secondary">${article.writeDate}</span>
			</div>
			<div>
				<a href="${contextPath}/board/delArticle?bno=${article.bno}" class="btn btn-danger">삭제</a>
				<a href="${contextPath}/board/modifyForm?bno=${article.bno}" class="btn btn-warning">수정</a>
			</div>
	    </div>
	</div>
</div>

<%@ include file="../layout/footer.jsp" %>
