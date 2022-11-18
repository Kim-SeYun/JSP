<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${ctxPath}/login" method="post">
	아이디 : <input type="text" name="user_id"><br>
	비밀번호 : <input type="password" name="user_pw"><br>
	<div><b>${msg}</b></div>
	<button>로그인</button>
</body>
</html>