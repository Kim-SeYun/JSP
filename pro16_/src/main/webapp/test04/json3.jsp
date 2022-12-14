<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.2/jquery.min.js" integrity="sha512-tWHlutFnuG0C6nQRlpvrEhE4QpkG1nn2MOUMWmUeRePl4e3Aki0VB6W1v3oLjFtd0hVOtRQ9PHpSfN6u6/QXkQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
<button id="checkjson">출력</button>
<div class="output"></div>
</body>
<script>
$(function(){
	
	
	$('#checkjson').on('click', function(){
		let jsonStr = '{"name" : "박지성", "age" : 25, "gender":"남자", "nickname":"두개의심장"}';
		let jsonInfo = JSON.parse(jsonStr);
		
		let output = "회원정보<br>";
		output += "이름 : " +jsonInfo.name
		output += " 나이 : " +jsonInfo.age
		output += " 성별 : " +jsonInfo['gender']
		output += " 별명 : " +jsonInfo['nickname']
		
		$('.output').html(output);

		
	}); // on end
}); // end
</script>

</html>