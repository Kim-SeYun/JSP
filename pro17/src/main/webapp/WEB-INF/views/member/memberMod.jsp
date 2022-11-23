<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>  

<c:set var="m" value="${memberInfo}"/>
<div class="container">
<h1>회원정보수정</h1>
<form action="${contextPath}/member/modify" method="post">
	아이디 : <input type="text" name="id" value="${m.id}" readonly="readonly"><br> 
	비밀번호 : <input type="password" name="pwd" value="${m.pwd}"><br> 
	이름 : <input type="text" name="name" value="${m.name}"><br>
	이메일 : <input type="text" name="email" value="${m.email}"><br>
	<button>수정</button>
</form>
<a href = "${contextPath}">메인으로</a><br>
</div>
<%@ include file="../layout/footer.jsp" %>