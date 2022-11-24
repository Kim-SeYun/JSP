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
</body>
</html>