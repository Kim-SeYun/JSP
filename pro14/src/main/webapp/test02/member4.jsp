<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("name", "페이지 : 김유신");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>우선순위</h3>
<p>pageContext > request > session > application</p>
페이지 컨텍스트 : ${pageScope.name}<br>
세션 : ${sessionScope.name}<br>
리퀘스트 : ${requestScope.name}<br>
서블릿 컨텍스트 : ${applicationScope.name}<br>


</body>
</html>