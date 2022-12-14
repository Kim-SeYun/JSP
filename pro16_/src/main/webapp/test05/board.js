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