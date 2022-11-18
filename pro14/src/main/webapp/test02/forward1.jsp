<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("id", "hong");
	request.setAttribute("pwd", "1234");
	request.setAttribute("name", "홍길동");
	request.setAttribute("email", "hong@example.com");
%>
<jsp:forward page="member1.jsp"/>
