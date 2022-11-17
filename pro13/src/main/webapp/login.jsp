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
	String errMsg = request.getParameter("errMsg");
%>
<% if(errMsg != null){ %>
	<h3><%=errMsg %></h3>
<% } %>
<form action="result.jsp">
	아이디 : <input type="text" name="user_id"><br>
	비밀번호 : <input type="text" name="user_pw"><br>
	<button>로그인</button>
</form>
</body>
</html>