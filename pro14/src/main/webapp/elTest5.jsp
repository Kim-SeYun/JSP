<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	/* String hello = "Hello";
	String str1 = null; // 널
	String str2 = ""; // 빈문자
	String str3 = " "; // 공백문자 */
%>
<c:set var="hello" value="Hello"/>
<c:set var="str1" value="${null}"/>
<c:set var="str2" value=""/>
<c:set var="str3" value=" "/>
</head>
<body>
<h2>empty 연산자</h2>
${hello}<br>
${str1}<br>
${str2}<br>
${str3}<br>
===============<br>
${empty hello}<br>
널 : ${empty str1}<br> <!-- null이면 true -->
빈문자 : ${empty str2}<br> <!-- 빈문자이면 true -->
공백문자 : ${empty str3}<br> <!-- 공백문자이면 false -->

${not empty hello} 
<!-- hello값이 비어있지 않으면 -->
<!-- hello값이 null이 아니고 빈문자가 아니면 -->





</body>
</html>