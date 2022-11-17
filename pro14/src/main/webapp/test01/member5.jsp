<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="m1" class="sec01.ex01.MemberBean"/>
<jsp:setProperty property="*" name="m1"/>
<jsp:useBean id="memberList" class="java.util.ArrayList"/>

<jsp:useBean id="memberMap" class="java.util.HashMap"/>
<%
	memberMap.put("id", "park");
	memberMap.put("pwd", "4567");
	memberMap.put("name", "박지성");
	memberMap.put("email", "park@example.com");
	
	MemberBean m2 = new MemberBean();
	m2.setId("son");
	m2.setPwd("1234");
	m2.setName("쏘니");
	m2.setEmail("son@example.com");
	memberList.add(m1);
	memberList.add(m2);
	
	memberMap.put("list", memberList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	아이디 : ${memberMap.id}<br>
	비밀번호 : ${memberMap.pwd}<br>
	이름 : ${memberMap.name}<br>
	이메일 : ${memberMap.email}<br>
</div>
<br>
<div>
	아이디 : ${memberMap.list[0].id}<br>
	비밀번호 : ${memberMap.list[0].pwd}<br>
	이름 : ${memberMap.list[0].name}<br>
	이메일 : ${memberMap.list[0].email}<br>
</div>
<br>
<div>
	아이디 : ${memberMap.list[1].id}<br>
	비밀번호 : ${memberMap.list[1].pwd}<br>
	이름 : ${memberMap.list[1].name}<br>
	이메일 : ${memberMap.list[1].email}<br>
</div>

</body>
</html>