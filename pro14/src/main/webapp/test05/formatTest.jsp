<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>숫자 형식화</h2>
<c:set var="price" value="10000000"/>
바로 출력 : <fmt:formatNumber value="${price}" type="number"/><br>
변수로 저장 : <fmt:formatNumber var="priceNumber" value="${price}" type="number"/><br>
${priceNumber}<br>

<h2>퍼센트</h2>
<fmt:formatNumber value="${price}" type="percent"/><br>

<h2>통화 표현</h2>
원화 : <fmt:formatNumber value="${price}" type="currency" currencySymbol="￦" groupingUsed="false"/><br>
달러 : <fmt:formatNumber value="${price}" type="currency" currencySymbol="$" groupingUsed="true"/><br>
원화 : <fmt:formatNumber value="${price}" type="currency" currencyCode="KRW" /><br>
달러 : <fmt:formatNumber value="${price}" type="currency" currencyCode="USD" /><br>
유로화 : <fmt:formatNumber value="${price}" type="currency" currencyCode="EUR"/><br>

<!--
	type : number | percent | currency
	groupingUsed : 세 자리마다 콤마 추가, 기본값 : true
	currencyCode : 통화 코드 지정 KRW | USD | EUR | JPY | CNY
-->

<h2>날짜 형식화</h2>
<c:set var="now" value="<%= new Date() %>"/>
형식화 전 : ${now}<br>
형식화 후 : <fmt:formatDate value="${now}"/><br>
date : <fmt:formatDate value="${now}" type="date"/><br><!-- 기본값 -->
time : <fmt:formatDate value="${now}" type="time"/><br>
both : <fmt:formatDate value="${now}" type="both"/><br>

<br>
<h3>dateStyle</h3>
<!-- 
	full | long | medium | short
 -->
지정하지 않음 : <fmt:formatDate value="${now}" type="both"/><br>
full : <fmt:formatDate value="${now}" type="both" dateStyle="full"/><br>
long : <fmt:formatDate value="${now}" type="both" dateStyle="long"/><br>
medium : <fmt:formatDate value="${now}" type="both" dateStyle="medium"/><br><!-- 기본값 -->
short : <fmt:formatDate value="${now}" type="both" dateStyle="short"/><br> 

<h3>timeStyle</h3>
지정하지 않음 : <fmt:formatDate value="${now}" type="both"/><br>
full : <fmt:formatDate value="${now}" type="both" timeStyle="full"/><br>
long : <fmt:formatDate value="${now}" type="both" timeStyle="long"/><br>
medium : <fmt:formatDate value="${now}" type="both" timeStyle="medium"/><br><!-- 기본값 -->
short : <fmt:formatDate value="${now}" type="both" timeStyle="short"/><br>

<h3>직접 지정</h3>
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd a hh:mm:ss"/><br>
<fmt:formatDate value="${now}" pattern="yyyy년MM월dd일 a hh시mm분 SS z"/>

<h4>타임존 지정</h4>
<fmt:timeZone value="America/New York">
	뉴욕 : <fmt:formatDate value="${now}" type="both" timeStyle="full"/>
</fmt:timeZone>

<%
	String[] local = TimeZone.getAvailableIDs();
	for(String s : local){
		out.print(s + "<br>");
	}
%>

</body>
</html>