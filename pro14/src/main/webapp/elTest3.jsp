<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>비교 연산자</h2>

<h4>~와 같다</h4>
${10 == 10}<br>
${10 eq 10}<br>
${'Hello' eq 'hello'}<br>

<h4>~와 같지 않다</h4>
${10 != 11}<br>
${10 ne 11}<br>
${'Hello' ne 'hello'}<br>

<h4>~보다 작다</h4>
${10 < 10}<br>
${10 lt 11}<br>

<h4>~보다 크다</h4>
${11 > 10}<br>
${10 gt 11}<br>

<h4>~보다 작거나 같다</h4>
${10 <= 10}<br>
${10 le 11}<br>

<h4>~보다 크거나 같다</h4>
${11 >= 10}<br>
${10 ge 11}<br>

</body>
</html>