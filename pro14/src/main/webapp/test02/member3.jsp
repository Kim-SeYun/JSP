<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${list}
<br>
<div>
	아이디 : ${list[0].id}<br>
	비밀번호 : ${list[0].pwd}<br>
	이름 : ${list[0].name}<br>
	이메일 : ${list[0].email}<br>

</div>
<div>
	아이디 : ${list[1].id}<br>
	비밀번호 : ${list[1].pwd}<br>
	이름 : ${list[1].name}<br>
	이메일 : ${list[1].email}<br>

</div>
</body>
</html>