
$(function(){
	boardService.list(); // 게시물 목록 불러오기
	
	// 게시물 상세
	$('.content').on('click', '.del', function(){
		let bnoValue = $(this).data('bno'); // 게시물번호	
		boardService.remove(bnoValue);
		
	});
	
	//게시물 등록 이벤트
	$('.writeBtn').on('click', function(){
		let title = $('.board_title').val()
		let content = $('.board_content').val()
		let writer = $('.board_writer').val()
		
		let boardVO = {
			title : title,
			content : content,
			writer : writer
		}
		boardService.write(boardVO)
		
		$('.board_title, .board_content, .board_writer').val('')
		$('.modal').modal('hide');
	})
	
	// 게시물 수정 처리
	$('.modBtn').on('click', function(){
		let bno = $('.board_bno').val()
		let title = $('.board_title').val()
		let content = $('.board_content').val()
		console.log(title)
		console.log(content)
		
		let boardVO = {
			bno : bno,
			title : title,
			content : content
		}
		$('.modal').modal('hide');
		//$('.content').html('')
		boardService.modify(boardVO)
		
		
		
		
	});
	
	// 게시물 수정 모달창
	$('.content').on('click', '.mod', function(){
		let bno = $(this).data('bno');
		$.ajax({
			type : 'get',
			url : "/pro16_/board/detail",
			data : {'bno' : bno},
			success : function(vo){
				$('.board_bno').val(vo.bno)
				$('.modal-title').html('글수정')
				$('.writeBtn').hide()
				$('.modBtn').show()
				$('.board_title').val(vo.title)
				$('.board_content').val(vo.content)
				$('.board_writer').val(vo.writer).prop('readonly', true);
				$('#write').modal('show');
			}
		})
	});
	
	// 새로운 글쓰기 모달창
	$('.newBoardBtn').on('click', function(){
		$('.modal-title').html('글쓰기')
		$('.modBtn').hide()
		$('.writeBtn').show()
		$('.board_writer').prop('readonly', false);
		$('.board_title, .board_content, .board_writer').val('')
		$('#write').modal('show');
	})
	
	$('.content').on('click', '.clo', function(){
		$('.content').html('')
	});
	
}); // end