function replyListRender(replyList){
	let output = '';
	for(let r of replyList){
		output += `
		<li class="list-group-item d-flex justify-content-between">
  			<div>${r.reply}</div>
  			<div class="badge badge-warning">${r.writer}</div>
		</li>`
	}
	$('.replyList ul').html(output);
}

let replyService = {
	
	list : function(bno){
		console.log('댓글목록')
		$.ajax({
			type : 'get',
			url : `${contextPath}/reply/list`,
			data : {bno : bno},
			success : function(replyList){
				replyListRender(replyList)
			},
			error : function(){
				alert('댓글목록 조회 실패')
			}
		});
	},
	
	detail : function(){
		console.log('댓글조회')
	},
	
	write : function(replyVO){
		
		$.ajax({
			type : 'post',
			url : `${contextPath}/reply/write`,
			data : replyVO,
			success : function(result){
				$('#feedback').find('.modal-body').html(result)
				$('#feedback').modal('show')
			},
			error : function(){
				alert('댓글 등록 에러')
			}
		}); //ajax end
	},
	
	modify : function(){
		console.log('댓글수정')
	},
	
	remove : function(){
		console.log('댓글삭제')
	}
	
}