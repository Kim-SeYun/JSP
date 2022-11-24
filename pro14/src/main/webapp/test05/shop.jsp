<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<c:if test="${empty param.lang or param.lang=='ko'}">
		<fmt:setLocale value="ko_KR"/>
	</c:if>
	<c:if test="${param.lang=='en'}">
		<fmt:setLocale value="en_US"/>
	</c:if>
	
<fmt:bundle basename="resources.shop">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>     
      <li><a href="#"><fmt:message key="shop.product.add"/></a></li>
      <li><a href="#"><fmt:message key="shop.product.mod"/></a></li>
      <li><a href="#"><fmt:message key="shop.product.list"/></a></li>
      <li><a href="#"><fmt:message key="shop.product.detail"/></a></li>
    </ul>
    
    <a href="?lang=ko" class="btn btn-danger navbar-btn">
		<fmt:message key="lang.ko"/>    
	</a>
    <a href="?lang=en" class="btn btn-danger navbar-btn">
    	<fmt:message key="lang.en"/>    
	</a>
  </div>
</nav>
</fmt:bundle>
</body>
</html>