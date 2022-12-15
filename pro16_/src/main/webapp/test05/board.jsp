<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.2/jquery.min.js" integrity="sha512-tWHlutFnuG0C6nQRlpvrEhE4QpkG1nn2MOUMWmUeRePl4e3Aki0VB6W1v3oLjFtd0hVOtRQ9PHpSfN6u6/QXkQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="BoardService.js"></script>
<script src="board.js"></script>
</head>
<body>
<div class="container">
	<div class="my-2">
		<button class="btn btn-primary newBoardBtn" data-toggle="modal">글쓰기</button>
	</div>
	<table class="table board_list">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<div class="content"></div>	
</div>
 <!-- The Modal -->
  <div class="modal" id="write">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">글쓰기</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        		제목 : <input type="text" class="form-control board_title">
        		내용 : <textarea rows="10" class="form-control board_content"></textarea>
        		작성자 : <input type="text" class="form-control board_writer">
        		<input type="hidden" class="board_bno">
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
       	  <button class="btn btn-primary writeBtn">글등록</button>
       	  <button class="btn btn-primary modBtn">글수정</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
 
</body>
<script>

</script>
</html>