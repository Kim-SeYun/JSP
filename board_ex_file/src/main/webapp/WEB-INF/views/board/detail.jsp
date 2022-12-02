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
				<th>내용</th>
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
	$('.viewMode').hide(); // 파일폼 숨김 / 수정,취소 버튼 숨김
	
	let viewForm = $('#viewForm');
	let titleObj = $('input[name="title"]');
	let contentObj = $('textarea[name="content"]');
	let imageFile = "${board.imageFileName}";
	let pTag = $('.preview p').html();
	
	let originImg = $('.originImg').clone();
	let titleVal = titleObj.val();
	let contentVal = contentObj.val();
	
	// 수정모드
	$('.toModForm').on('click',function(){
		$('input[name="title"],textarea[name="content"]').attr("readonly",false);
		$('.viewMode').show();
		$(this).closest('tr').hide();
	});
	
	// 뷰모드
	$('.backViewMode').on('click',function(){
		$('input[name="title"],textarea[name="content"]').attr("readonly",true);
		$('.viewMode').hide();
		$(this).closest('tr').prev().show();
		$('.preview').html(originImg); // 수정전 이미지 복원
		$('input[type="file"]').val(''); // 파일폼 초기화
		titleObj.val(titleVal); // 수정전 제목 복원
		contentObj.val(contentVal); // 수정전 내용 복원
		if(imageFile=='' || imageFile==null){
			$('.preview').html(pTag);
		}
	});
	
	// 목록으로
	$('.toList').on('click',function(){
		viewForm.attr({
			"action" : "${contextPath}/board",
			"method" : "get"
		}).empty() // 파라미터 정보 삭제
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
		if(this.files[0]) {
			let reader = new FileReader(); // 파일읽기 객체
			reader.onload = function(e){ // 파일을 읽으면 이벤트 발생
				let value = e.target.result
				if(value.startsWith("data:image/")) { // 이미지파일인경우
					let imgTag = "<img src='"+value+"'>";
					$('.preview').html(imgTag);
				} else { // 이미지파일이 아닌경우
					alert('이미지 파일만 등록하세요');
					$('input[name="imageFileName"]').val('');
					$('.preview').html('');
				}
			}
			reader.readAsDataURL(this.files[0]); // 파일 읽기 메소드 호출
		}
	});
});
</script>