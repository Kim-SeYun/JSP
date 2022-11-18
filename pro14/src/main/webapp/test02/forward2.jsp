<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberBean vo = new MemberBean();
	vo.setId("lee");
	vo.setPwd("1234");
	vo.setName("이순신");
	vo.setEmail("lee@example.com");
	request.setAttribute("member", vo);
%>
<jsp:forward page="member2.jsp"/>
