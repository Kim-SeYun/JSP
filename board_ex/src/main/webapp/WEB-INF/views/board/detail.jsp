<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container">
<h1>게시글 조회</h1>
	<div class="card">
	    <div class="card-header">
	    	${article.title}
	    </div>
	    <div class="card-body">
	    	${article.content}
	    </div> 
	    <div class="card-footer">
	    	<span class="badge badge-primary">${article.writer}</span>
			<span class="badge badge-secondary">${article.writeDate}</span>
	    </div>
	</div>
</div>

<%@ include file="../layout/footer.jsp" %>
