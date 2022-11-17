<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="ctxPath" value="${pageContext.request.contextPath}" />
<!-- <a href="/pro14/member/memberJoin.jsp">회원가입 페이지로</a><br> -->

<!-- 컨텍스트 패스 구하기 -->
<%= request.getContextPath() %><br>
${pageContext.request.contextPath}<br>

<%-- <a href="<%= request.getContextPath()%>/member/memberJoin.jsp">회원가입 페이지로</a><br> --%>
<%-- <a href="${pageContext.request.contextPath}/member/memberJoin.jsp">회원가입 페이지로</a><br> --%>
<a href="${ctxPath}/member/memberJoin.jsp">회원가입 페이지로</a><br>
</body>
</html>