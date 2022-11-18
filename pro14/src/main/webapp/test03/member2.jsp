<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="memberList" class="java.util.ArrayList"/>
<jsp:useBean id="memberMap" class="java.util.HashMap"/>
<%
	MemberBean vo1 = new MemberBean("son", "1234", "손흥민", "son@example.com");
	MemberBean vo2 = new MemberBean("lee", "2345", "이강인", "lee@example.com");
	memberList.add(vo1);
	memberList.add(vo2);
	
	memberMap.put("memberList", memberList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="list" value="${memberMap.memberList}"/>
<div>
아이디 : ${list[0].id}<br>
비밀번호 : ${list[0].pwd}<br> 
이름 : ${list[0].name}<br>
이메일 : ${list[0].email}<br>

</div><br>
<div>
아이디 : ${list[1].id}<br>
비밀번호 : ${list[1].pwd}<br> 
이름 : ${list[1].name}<br>
이메일 : ${list[1].email}<br>

</div><br>


</body>
</html>