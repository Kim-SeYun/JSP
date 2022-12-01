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
제목 : <input type="text" name="title" id="title" value="">
<button class="btn">클릭</button><br>

내용 : <input type="text" name="content" id="content">
<button class="btn2">클릭2</button><br>
<p>Hello</p>
</body>
<script>
$(function(){
	
	$('.btn').on('click', function(){
		let value = $('#title').val();
		alert(value);
	});
	
	$('.btn2').click(function(){
		let pTag = $('p').text();
		$('#content').val(pTag);
	});
});
</script>
</html>