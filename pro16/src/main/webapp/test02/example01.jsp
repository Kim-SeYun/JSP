<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<style>
div div{border: 1px solid green;}
div li {color: orange;}
ul +div {font-weight: bold;}
</style>
</head>
<body>

부모요소 - 조상요소<br>
자식요소 - 자손요소<br>
<!-- 
	> : 자식선택자
	공백 : 자손선택자
	+ : 인접선택자, 형제선택자
 -->
<div class="content">
	테스트01
	<ul>
		<li>자손선택자 1</li>
		<li>자손선택자 2</li>
		<li>자손선택자 3</li>
	</ul>
	<div>자식선택자 1</div>
	<div>자식선택자 2</div>
	<p>자식선택자 3</p>
	<p>자식선택자 4</p>
</div>
</body>
<script>
</script>
</html>