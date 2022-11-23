<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>   

<div class="container">

	<h1>회원가입</h1>
	<form action="${contextPath}/member/join" method="post">
		아이디 : <input type="text" name="id"><br> 
		비밀번호 : <input type="text" name="pwd"><br> 
		이름 : <input type="text" name="name"><br>
		이메일 : <input type="text" name="email"><br>
		<button>회원가입</button>
	</form>
	<a href = "${contextPath}">메인으로</a><br>
</div>
<%@ include file="../layout/footer.jsp" %>