<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="m1" class="sec01.ex01.MemberBean"/>
<jsp:setProperty property="*" name="m1"/>
<jsp:useBean id="memberList" class="java.util.ArrayList"/>
<%
	MemberBean m2 = new MemberBean();
	m2.setId("son");
	m2.setPwd("1234");
	m2.setName("쏘니");
	m2.setEmail("son@example.com");
	memberList.add(m1);
	memberList.add(m2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<h3>첫번째 회원</h3>
	아이디 : ${memberList[0].id}
	비밀번호 : ${memberList[0].pwd}
	이름 : ${memberList[0].name}
	이메일 : ${memberList[0].email}
</div>
<div>
	<h3>두번째 회원</h3>
	아이디 : ${memberList[1].id}
	비밀번호 : ${memberList[1].pwd}
	이름 : ${memberList[1].name}
	이메일 : ${memberList[1].email}
</div>

</body>
</html>