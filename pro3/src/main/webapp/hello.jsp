<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	 // 스트립틀닛
	// 자바 코드 가능
	String[] names = {"홍길동", "김길동", "박길동", "임꺽정"};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello Jsp</h1>
<ul>
<% for(String str : names){%>
	<li><% out.println(str); %></li>
<% } %>
</ul>
</body>
</html>