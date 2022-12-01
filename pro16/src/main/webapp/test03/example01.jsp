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
<h1>attr()메서드</h1>
<form class="myForm">
	파라미터 : <input type="text" name="title"><br>
	<button type="button" class="getBtn">get요청</button>
	<button type="button" class="postBtn">post요청</button>
</form>

</body>
<script>
$(function(){
	// 이벤트 처리 : on(param1, param2)
	// param1 : 이벤트 종류
	// param2 : 이벤트 발생 시 실행될 함수 
	
	let myForm = $('.myForm')
	
	function myFunction(){
		alert('get 요청 버튼클릭');
		myForm.attr({
			"action" : "getresult.jsp",
			"method" : "get"
		}).submit();
			  	
	}
	
	// attr(속성명, 속성값)
	$('.getBtn').on('click', myFunction);
	
	$('.postBtn').on('click', function(){
		alert('post 요청 버튼클릭');
		myForm.attr({
			"action" : "postresult.jsp",
			"method" : "post"
		}).submit();
	});
	
});
</script>
</html>