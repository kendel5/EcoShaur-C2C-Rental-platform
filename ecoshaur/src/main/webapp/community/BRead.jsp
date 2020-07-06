<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice.jsp</title>
<style>
p {
	font-family: "Nanum Gothic", sans-serif;
	font-size: 30px;
	font-weight: 800;
}
</style>
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean"
	rel="stylesheet">
</head>

<!-- 본문 시작 Notice.jsp-->
<body>
<br><br><br><br><br><br><br><br><br>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel-body">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>글번호</th>
								<td>${dto.postno}</td>
							</tr>
							<tr>
								<th>제목</th>
								<td>${dto.title}</td>
							</tr>
							<tr>
								<th>내용</th>
								<td>${dto.contents}<br><br><br>								
								<img src="./community/storage/${dto.image_name}"
								onError="this.style.visibility='hidden'"></td>
							</tr>
							<tr>
								<th>작성일</th>
								<c:set var="date" value="${dto.post_date}" />
								<td>${fn:substring(date,0,10)}</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>${dto.id}</td>
							</tr>
							<tr>
								<th>조회수</th>
								<td>${dto.view}</td>
							</tr>
							<tr>
								<th>좋아요</th>
								<td>${dto.good}</td>
							</tr>
							<tr>
								<th>싫어요</th>
								<td>${dto.bad}</td>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class='bottom'>
		<input type='button' value='좋아요' 
		onclick="location.href='Good.do?postno=${dto.postno}'">
		<input type='button' value='싫어요' 
		onclick="location.href='Bad.do?postno=${dto.postno}'">
		<br>
		<input type='button' value='게시판 목록' onclick="location.href='Board.do'">
		<input type="button" value="수정"
			onclick="location.href='BUpdate.do?postno=${dto.postno}'">
		<input type="button" value="삭제"
			onclick="location.href='BDelete.do?postno=${dto.postno}'">
	</div>
</body>




<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<!-- 본문 끝 -->
<%@ include file="../e_footer.jsp"%>