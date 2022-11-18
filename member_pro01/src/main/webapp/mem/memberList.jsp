<%@page import="model.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
<!-- empty : null 또는 빈문자 -->
<c:if test="${not empty loginId}">
	<h2>${loginId}님이 로그인 중</h2>
</c:if>

<table border=1>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>삭제</th>
	</tr>
	<!-- 반복구간 -->
		<c:forEach items="${memberList}" var="vo">
	<tr>
		<td>${vo.mno}</td>
		<td>${vo.id}</td>
		<td>${vo.pwd}</td>
		<td>${vo.name}</td>
		<td>${vo.email}</td>
		<td><a href="${ctxPath}/member/delMember?mno=${vo.mno}">삭제</a></td>
	</tr>
	</c:forEach>
</table>

<c:if test="${empty loginId}">
	<a href="${ctxPath}/mem/joinMember.jsp">회원가입하기</a><br>
	<a href="${ctxPath}/mem/login.jsp">로그인</a>
</c:if>

</body>
</html>