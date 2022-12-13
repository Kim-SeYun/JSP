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
<button>전송</button>
<p>Hello?</p>
<p>안녕</p>
<div class="message"></div>

</body>
<script>
$(function(){
	$('button').on('click', function(){
		$.ajax({
			type : 'get', // 전송방식
			dataType : 'text', // 데이터 타입
			url : '/pro16_/ajaxTest1', // 전송url
			data : {userName : 'mimi'}, 
			success : function(result){ // 요청 및 응답 성공
				$('.message').html(result +"<br>")
			},
			error : function(){ // 요청 및 응답 실패
				alert('실패')
			},
			complete : function(){ // 마지막에 무조건 실행
				alert('완료')
			}
			
		}); // ajax end
		
	}); // on end
	
}); // document ready end

</script>
</html>