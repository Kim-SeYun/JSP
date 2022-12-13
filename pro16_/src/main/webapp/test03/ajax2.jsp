<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디중복체크</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
<form action="test.jsp" method="post">
	아이디 : <input type="text" class="userId" name="email">
	<button class="button" class="idCheck">아이디중복체크</button>
	<div class="message"></div>

	이메일 : <input type="text" name="email">
	<div>
	<button type="button" class="join">회원가입</button>
	</div>



</form>
</body>
<script>
$(function(){
	let idChecked = false;
	$('button').on('click', function(){
		let userId = $('.userId').val();
		$.ajax({
			type : 'post',
			url : '/pro16_/member',
			data : {'userId' : userId},
			success : function(result){
				if(result=='true'){
					$('.message').html('중복된 ID 입니다.')
					idChecked = false;
				} else{
					$('.message').html('사용사능한 ID 입니다.')
					idChecked = true;
				}
			},
			error : function(){
				alert('에러')
			}
			
		}); // ajax end
		
	}); // on end
	
	$('.join').on('click', function(){
		if(idChecked){
			$('form').submit();
					
		}else{
			alert('아이디 중복여부를 확인하세요');
		}
		
	})
	
}); // document ready end

</script>
</html>