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

<div class="content">
content Div
	<div>
		<div>테스트03</div>
		<ul>
			<li id="test">자손선택자 1</li>
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
	$('#test').closest('div').css('border', '1px solid green')
})
</script>
</html>