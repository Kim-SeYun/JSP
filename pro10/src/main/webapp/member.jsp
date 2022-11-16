<%@page import="sec04.ex01.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
접속한 사용자 수 : <%= LoginVO.logined.size() %><br>
접속한 사용자 : <%= LoginVO.logined %>
<form action="logout" method="post">
	<button>로그아웃</button>
</form>
</body>
</html>