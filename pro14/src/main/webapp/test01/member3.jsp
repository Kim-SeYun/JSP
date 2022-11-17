<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="member" class="sec01.ex01.MemberBean"/>
<jsp:setProperty property="*" name="member"/>

아이디 : ${member.id}<br> <!-- MemberBean의 getId() 호출 -->
<%-- 비밀번호 : ${member.pwd}<br> <!-- MemberBean의 getPwd() 호출 -->
이름 : ${member.name}<br> <!-- MemberBean의 getName() 호출 -->
이메일 : ${member.email}<br> <!-- MemberBean의 getEmail() 호출 --> --%>

</body>
</html>