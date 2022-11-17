<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="m1" class="sec01.ex02.MemberBean"/>
<jsp:setProperty property="id" name="m1" value="mimi"/>
<jsp:setProperty property="pwd" name="m1" value="1234"/>
<jsp:setProperty property="name" name="m1" value="미미"/>
<jsp:setProperty property="email" name="m1" value="mimi@naver.com"/>

<jsp:useBean id="addr" class="sec01.ex02.Address"/>
<jsp:setProperty property="city" name="addr" value="대구광역시"/>
<jsp:setProperty property="zipcode" name="addr" value="07654"/>

<jsp:setProperty property="address" name="m1" value="${addr}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 : ${m1.id}<br>
비밀번호 : ${m1.pwd}<br>
이름 : ${m1.name}<br>
이메일 : ${m1.email}<br>
주소 : ${m1.address.city} ${m1.address.zipcode}<br>
</body>
</html>