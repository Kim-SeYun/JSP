<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="num1" value="20"/>
<c:set var="num2" value="10"/>
${num1+num2}

<!-- test속성 : 조건은 표현언어로 나타낸다. -->
<c:if test="${num1+num2 > 20}">
	<p>결과값은 20보다 크다</p>
</c:if>

<c:if test="${num1+num2 < 20}">
	<p>결과값은 20보다 작다</p>
</c:if>

<c:choose>
	<c:when test="${num1+num2 > 10 and num1+num2 < 20}">
		<p>10보다 크고 20보다 작다</p>
	</c:when>
	<c:when test="${num1+num2 < 10}">
		<p>10보다 작다</p>
	</c:when>
	<c:otherwise>
		<p>잘 모르겠다</p>
	</c:otherwise>
</c:choose>

</body>
</html>