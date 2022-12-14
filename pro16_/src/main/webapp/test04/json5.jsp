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
	
	let _jsonInfo = '{"name":"박지성", "age":25, "gender" : "남자", "nick":"두개의 심장"}'
	$('#checkjson').on('click', function(){
		$.ajax({
			type : 'post',
			url : "/pro16_/json1",
			data : {jsonInfo : _jsonInfo},
			success : function(result){
				alert('성공');
				console.log(result);
			},
			error : function(){
				alert('실패');
			}
			
		}); // ajax end
		
	}); //on end
}); // end
</script>

</html>