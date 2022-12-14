function get_content(bno) {
	console.log(bno);
	$.ajax({
		type : 'get',
		url : "/pro16_/board/detail",
		data : {bno : bno},
		success : function(detail){
			let aa = "";
			aa += `
			<div class="card">
			  <div class="card-header d-flex justify-content-between">
			  <b>${detail.title}</b>
			  <button class="btn btn-danger del" data-bno="${detail.bno}">삭제</button>
			  </div>
			  <div class="card-body">${detail.content}</div>
			  <div class="card-footer d-flex justify-content-between">
			  	<span>${detail.writer}</span>
			  	<span>${detail.writeDate}</span>
			  </div>
			</div>`;
			$('.content').html(aa);
		},
		error : function(){
			alert('에러')
		}
	})
}

$(function(){
	let boardList = null;
	$.ajax({
		type : 'post',
		url : "/pro16_/board/list",
		success : function(list) {
			boardList = list;
			let output = "";
			for(let b of list) {
				output += `
			    <tr>
			        <td>${b.bno}</td>
			        <td><a href="#" onclick="get_content(${b.bno})">${b.title}</a></td>
			        <td>${b.writer}</td>
			        <td>${b.writeDate}</td>
			    </tr>`;
			}
			$('table').append(output);
		}, 
		error : function() {
			alert('에러');
		}
	}); // ajax end
	
	$('.content').on('click', '.del', function(){
		alert($(this).data('bno'));
	})
	
}); // end