<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name", "리퀘스트 : 홍길동");
	session.setAttribute("name", "세션 : 이순신");
	application.setAttribute("name", "서블릿 컨텍스트 : 손흥민");
%>
<jsp:forward page="member4.jsp"/>
