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
	
	let test = {"name" : ["홍길동", "이순신", "김꺽정"]}
	
	$('#checkjson').on('click', function(){
		let jsonStr = '{"name" : ["홍길동", "이순신", "김꺽정"]}'; // 문자열
		let jsonInfo = JSON.parse(jsonStr); // 문자열을 자바스크립트 객체로 변환
		console.log(jsonInfo); // 결과 확인
		console.log(jsonInfo.name); // name속성에 해당되는 배열
		console.log(jsonInfo.name[0]); // 홍길동
		console.log(jsonInfo.name[1]); // 이순신
		console.log(jsonInfo.name[2]); // 임꺽정
		
		let output = "회원이름<br>"
		output += "====================<br>"
		for(let n of jsonInfo.name){
			output += n + "<br>";
		}
		// console.log(output);
		$('.output').html(output);
		
	}); // on end
}); // end
</script>

</html>