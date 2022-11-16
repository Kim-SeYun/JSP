<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>결과출력</h1>
<%
	request.setCharacterEncoding("utf-8");
	String userId = request.getParameter("user_id");
	String userPw = request.getParameter("user_pw");
%>
<%
	if(userId==null || userId.equals("")){%>
		아이디를 입력하세요<br>
		<a href = "/pro12/login.html">로그인하기</a>
<%} else {%>
	<h1>환영합니다. <%=userId %>님</h1>
<%} %>


</body>
</html>