<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberBean vo1 = new MemberBean("lee", "1234", "이순신", "lee@example.com");
	MemberBean vo2 = new MemberBean("son", "2342", "손흥민", "son@example.com");
	List<MemberBean> memberList = new ArrayList<>();
	memberList.add(vo1);
	memberList.add(vo2);
	
	request.setAttribute("list", memberList);
%>
<jsp:forward page="member3.jsp"/>
