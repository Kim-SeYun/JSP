<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${empty param.lang or param.lang=='ko'}">
	<fmt:setLocale value="ko_KR"/>
</c:if>
<c:if test="${param.lang=='en'}">
	<fmt:setLocale value="en_US"/>
</c:if>
<fmt:setBundle var="member" basename="resources.member"/>
<fmt:setBundle var="shop" basename="resources.shop"/>

	이름 : <fmt:message bundle="${member}" key="mem.name"/><br>
	주소 : <fmt:message bundle="${member}" key="mem.address"/><br>
	직업 : <fmt:message bundle="${member}" key="mem.job"/><br>

<a href="?lang=en">
	<fmt:message bundle="${shop}" key="lang.en"/>
</a>
<a href="?lang=ko">
	<fmt:message bundle="${shop}" key="lang.ko"/>
</a>

</body>
</html>