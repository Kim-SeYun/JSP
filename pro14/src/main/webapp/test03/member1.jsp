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
<!-- scope속성 : page, request, session, application 기본값 : page  -->
<!-- var속성 : 변수명, value속성 : 변수에 할당되는 값, 문자열 또는 표현언어 -->
<c:set var="id" value="hong" scope="page"/>
<c:set var="pwd" value="${1234}"/>
<c:set var="name" value="${'홍' += '길동'}"/>
<c:set var="email" value="hong@example.com"/>

아이디 : ${id}<br>
비밀번호 : ${pwd}<br>
이름 : ${name}<br>
이메일 : ${email}<br>

</body>
</html>