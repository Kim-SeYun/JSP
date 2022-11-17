<%@page import="sec01.ex01.MemberBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="dao" class="sec01.ex01.MemberDao" />
<jsp:useBean id="member" class="sec01.ex01.MemberBean"/>
<jsp:setProperty property="*" name="member" />


아이디 : <jsp:getProperty property="id" name="member"/><br>
비밀번호 : <jsp:getProperty property="pwd" name="member"/><br>
이름 : <jsp:getProperty property="name" name="member"/><br>
이메일 : <jsp:getProperty property="email" name="member"/><br>
</body>
</html>