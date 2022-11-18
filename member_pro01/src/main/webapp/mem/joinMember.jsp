<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<form action="/member_pro01/member/addMember" method="post">
	아이디 : <input type="text" name="id"><br>
	비밀번호 : <input type="password" name="pwd"><br>
	이름 : <input type="text" name="name"><br>
	이메일 : <input type="text" name="email"><br>
	<button>회원가입</button>
</body>
</html>