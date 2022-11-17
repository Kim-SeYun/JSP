<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String userId = request.getParameter("user_id");
	 
%>
<% if(userId == null || userId.trim().equals("")){ %>
	<jsp:forward page="login.jsp">
		<jsp:param value="아이디를 입력하세요" name="errMsg"/>
	</jsp:forward>

<% } else { %>
	<h1>안녕하세요. <%=userId %>님</h1>
<%} %>

</body>
</html>