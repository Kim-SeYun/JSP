<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<div class="jumbotron">
		<h1>글상세</h1>
	</div>
	<form id="viewForm" enctype="multipart/form-data">
		<table class="table">
			<tr>
				<th>글번호</th>
				<td>
					${board.bno}
					<input type="hidden" name="bno" value="${board.bno}">
				</td>
				<th>조회수</th>
				<td>000</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.writer}</td>
				<th>작성일</th>
				<td>${board.writedate}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">
				<input type="text" name="title" class="form-control" value="${board.title}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<th>내용></th>
				<td colspan="3">
				<textarea rows="10" name="content" class="form-control" readonly="readonly">${board.content}</textarea>
				</td>
			</tr>
			<tr>
				<th>첨부이미지</th>
				<td colspan="3">
					<input type="file" name="imageFileName" class="form-control viewMode">
					<div class="my-2">
					<c:if test="${not empty board.imageFileName}">
					<div style='width:80px;float: right;'>

						<input type='button' class='pbtn' value='X'>

					</div>
						<input type="hidden" name="originFileName" value="${board.imageFileName}">
						<div class="preview">
							<img class="originImg" src="${contextPath}/fileDownload?bno=${board.bno}&imageFileName=${board.imageFileName}">
						</div>
					</c:if>
					<c:if test="${empty board.imageFileName}">
						<div class="preview">
							<p>등록된 이미지가 없습니다.</p>
						</div>
					</c:if>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="4" class="text-center">
					<button type="button" class="btn btn-primary toModForm">수정</button>
					<button type="button" class="btn btn-warning remove">삭제</button>
					<button type="button" class="btn btn-success toList">목록</button>
				</td>
			</tr>
			<tr class="viewMode">
				<td colspan="4" class="text-center">
					<button type="button" class="btn btn-primary modify">수정</button>
					<button type="button" class="btn btn-danger backViewMode">취소</button>
				</td>
			</tr>
		</table>
	</form>
</div>

<%@ include file="../layout/footer.jsp" %>

<script>
$(function(){
	$('.viewMode').hide();
	$('.pbtn').hide();
	
	let viewForm = $('#viewForm');
	let titleObj = $('input[name="title"]');
	let contentObj = $('textarea[name="content"]');
	let imageFile = "${board.imageFileName}";
	let pTag = $('.preview p').html();
	
	let originImg = $('.originImg').clone();
	let titleVal = titleObj.val();
	let contentVal = contentObj.val();
	
	// 수정모드
	$('.toModForm').on('click', function(){
		$('input[name="title"], textarea[name="content"]').attr("readonly", false);
		$('.viewMode').show();
		$(this).closest('tr').hide();
		$('.pbtn').show();
		
		
	});
	
	// 뷰모드
	$('.backViewMode').on('click', function(){
		$('input[name="title"],textarea[name="content"]').attr("readonly", true);
		$('.viewMode').hide();
		$(this).closest('tr').prev().show();
		$('.preview').html(originImg);
		$('input[type="file"]').val('');
		titleObj.val(titleVal);
		contentObj.val(contentVal);
		if(imageFile=='' || imageFile==null){
			$('.preview').html(pTag);
		}
	});
	
	// 목록으로
	$('.toList').on('click', function(){
		viewForm.attr({
			"action" : "${contextPath}/board",
			"method" : "get"
		}).empty()
		.submit();
	});
	
	// 수정처리
	$('.modify').on('click', function(){
		
		viewForm.attr({
			"action" : "${contextPath}/board/modBoard",
			"method" : "post"
		}).submit();
		
	});
	
	// 삭제처리
	$('.remove').on('click', function(){
		viewForm.attr({
			"action" : "${contextPath}/board/removeBoard",
			"method" : "post"
		}).submit();
	});
	
	$('input[type="file"]').on('change', function(){
		if(this.files[0]){
			let reader = new FileReader();
			reader.onload = function(e){
				let value = e.target.result
				if(value.startsWith("data:image/")){
					let imgTag = "<img src ='"+value+"'>";
					$('.preview').html(imgTag);
				} else{
					alert('이미지 파일만 등록하세요');
					$('input[name="imageFileName"]').val('');
					$('.preview').html('');
				}
			}
			reader.readAsDataURL(this.files[0]);
		}
	});
	
	$('.pbtn').on('click', function(){
		$('input[name="imageFileName"]').val('');
		$('.preview').html('');
		$(this).hide();
	});
	
	
});
</script>