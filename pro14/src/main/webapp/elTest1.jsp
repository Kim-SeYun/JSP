<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>표현언어의 자료형</h1>
	불리안 : ${true}, ${false} <br>
	널 : ${null}<br>
	정수와 실수 : ${10}, ${11.2}, ${2+4}<br>
	문자열 : ${"Hello"}, ${'hello'} <!-- 큰따옴표, 작은따옴표 둘다 가능 -->
	
	<h1>표현언어 이스케이프</h1>
	\${10+100}
	
	<h1>연산</h1>
	10+2 : ${10+2}<br>
	9-2 : ${9-2}<br>
	9*2 : ${9*2}<br>
	10/8 : ${10/8}<br>
	
	<h1>문자열 연산</h1>
	<%-- ${'Hello' + 'World'} --%>
	<%-- ${"Hello" + "World""} --%>
	${"Hello" += "World"}
	
	<h1>숫자형 문자열의 계산</h1>
	"10" +"2" : ${"10" +"2"}<br>
	"10" + 2 : ${"10"+2}<br>
	10 +"2" : ${10+"2"}<br>
	
	<h1>null과의 연산</h1>
	${null+10}<br>
	${null+"10"}<br>
	<!-- 숫자,숫자형 문자와 null연산시 null값은 0으로 간주함 -->
</body>
</html>