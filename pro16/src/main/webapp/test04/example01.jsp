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
<div class="test01"></div>
<div class="test02"></div>
<div class="test03">
	<h1>Hello</h1>
</div>

<form action="test01.jsp"></form>
</body>

<script>
$(function(){
	$('.test01').html('<h1>hello</h1>');
	$('.test02').text('<h1>hello</h1>');
	let str1 = $('.test03').html();
	let str2 = $('.test03').text();
	console.log(str1);
	console.log(str2);
	
	let action = $('form').attr('action');
	console.log(action);
	$('form').removeAttr('action');
	let after = $('form').attr('action');
	console.log(after);
});
</script>
</html>