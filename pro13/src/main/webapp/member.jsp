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
<%--<%= list %> --%>
<jsp:useBean id="dao" class="sec01.ex01.MemberDao" />
<jsp:useBean id="member" class="sec01.ex01.MemberBean"/>
<jsp:setProperty property="id" name="member" value='<%= request.getParameter("id") %>'/>
<jsp:setProperty property="pwd" name="member" value='<%= request.getParameter("pwd") %>'/>
<jsp:setProperty property="name" name="member" value='<%= request.getParameter("name") %>'/>
<jsp:setProperty property="email" name="member" value='<%= request.getParameter("email") %>'/>

<!-- 
	property 속성
	값이 pwd -> setPwd() 메소드 호출
	값이 email -> setEamil() 메소드 호출
	값이 name -> setName() 메소드 호출
	name 속성 : 참조대상의 유즈빈 객체
 -->

<%= member%><br>

아이디 : <jsp:getProperty property="id" name="member"/><br>
비밀번호 : <jsp:getProperty property="pwd" name="member"/><br>
이름 : <jsp:getProperty property="name" name="member"/><br>
이메일 : <jsp:getProperty property="email" name="member"/><br>
</body>
</html>