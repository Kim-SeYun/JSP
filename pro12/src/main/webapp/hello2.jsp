<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "이순신";
	String age = request.getParameter("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 표현식 : HTML주석-->
<%-- <h1>안녕하세요 <%= name %></h1> --%>
<h1>나이는 <%= age %></h1>

<%-- <%
	String email = "aaa@naver.com"
--%>
</body>
</html>