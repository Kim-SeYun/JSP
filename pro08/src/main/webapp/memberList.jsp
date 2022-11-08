<%@page import="sec04.ex04.MemberVO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 자바 코드 올수 있음
	List<MemberVO> memberList = (List<MemberVO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
<table border=1>
	<tr>
		<th>회원번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>가입일</th>
	</tr>
	<% for(MemberVO vo : memberList) {%>
	<tr>
		<td><%=vo.getMno()%></td>
		<td><%=vo.getId()%></td>
		<td><%=vo.getPassword()%></td>
		<td><%=vo.getName()%></td>
		<td><%=vo.getEmail()%></td>
		<td><%=vo.getJoinDate()%></td>
	</tr>
	<%}%>
	
</table>
</body>
</html>