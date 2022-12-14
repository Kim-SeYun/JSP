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
<table>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
	</tr>
</table>
 
</body>
<script>
$(function(){
	
	$.ajax({
		type : 'post',
		url : "/pro16_/board",
		success : function(list){
			let output = "";
			for(let b of list){
				output += "<tr>"
				output += "<td>"+ b.bno+"</td>"
				output += "<td>"+ b.content+"</td>"
				output += "<td>"+ b.writer+"</td>"
				output += "<td>"+ b.writeDate+"</td>"
				output += "</tr>"
			}
			$('table').append(output);
		},
		error : function(){
			alert('실패');
		}
		
	}); // ajax end
	
}); // end
</script>

</html>