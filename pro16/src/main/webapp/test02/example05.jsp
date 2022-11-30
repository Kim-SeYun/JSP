<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

</head>
<body>
<h1>prev(), next()</h1>
<p>상위요소에서 하위요소로 탐색하여 가장 가까운 요소 선택</p>
<div class="content">
content Div
	<div>
		<div>테스트05</div>
		<ul class="test">
			<li>자손선택자 1</li>
			<li>자손선택자 2</li>
			<li>자손선택자 3</li>
		</ul>
		<div>자식선택자 1</div>
		<div>자식선택자 2</div>
		<p>자식선택자 3</p>
		<p>자식선택자 4</p>
		</div>
	</div>
	
</body>
<script>
$(function(){
	$('.test').prev().css('border', '1px solid green')
	$('.test').next().css('backgroundColor', 'pink')
	$('.test').nextAll().css('border', '1px solid lightblue')
})
</script>
</html>