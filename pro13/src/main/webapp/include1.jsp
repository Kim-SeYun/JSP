<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 인클루드 액션 태그 : 시작 </h1>

<%-- <%@ include file="duke_image.jsp" %> --%>
<jsp:include page="duke_image.jsp">
	<jsp:param value="duke2.png" name="imageName"/>
	<jsp:param value="듀크" name="name"/>
</jsp:include>

<h1> 인클루드 액션 태그 : 끝 </h1>
</body>
</html>