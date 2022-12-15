
let boardService = (function(){
	function list(){
		$.ajax({ // 게시물 목록
		type : 'post',
		url : "/pro16_/board/list",
		success : function(list) {
			boardList = list;
			let output = "";
			for(let b of list) {
				output += `
			    <tr>
			        <td>${b.bno}</td>
			        <td><a href="#" onclick="boardService.detail(${b.bno})">${b.title}</a></td>
			        <td>${b.writer}</td>
			        <td>${b.writeDate}</td>
			    </tr>`;
			}
			$('.board_list tbody').html(output);
		}, 
		error : function() {
			alert('에러');
		}
	}); // ajax end
	}
	
	function remove(bnoValue){
		$.ajax({
		type : 'post',
		url : "/pro16_/board/remove",
		data : {bno : bnoValue},
		success : function(result){
			alert(result);
			boardService.list(); // 게시물 불러오고
			$('.content').html(''); // 게시물 상세 내용 삭제
		},
		error : function(){
			alert('에러')
		}
	}); // ajax end
}
	
	function detail(bno){
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
				  <div>
				 	 <button class="btn btn-info mod" data-bno="${detail.bno}">수정</button>
				 	 <button class="btn btn-danger del" data-bno="${detail.bno}">삭제</button>
				 	 <button class="btn btn-secondary clo" data-bno="${detail.bno}">X</button>
				  </div>
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
	
	function write(vo){
		$.ajax({
			type : 'post',
			url : '/pro16_/board/write',
			data : vo,
			success : function(result){
				alert(result);
				boardService.list();
			},
			error : function(){
				alert('에러')
			}
		}); // ajax end
	}
	
	function modify(vo){
		$.ajax({
			type : 'post',
			url : '/pro16_/board/modify',
			data : vo,
			success : function(result){
				alert(result);
				boardService.list()
				boardService.detail(vo.bno)
			},
			error : function(){
				alert('에러')
			}
		});
	}
	
	return{
		list : list,
		remove : remove,
		detail : detail,
		write : write,
		modify : modify
	};
	
})();
