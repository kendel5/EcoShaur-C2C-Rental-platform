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
	<H3>공지사항 등록</H3>
	<br>
	<br>
	<form method="post" action="NCreate.do" enctype="multipart/form-data">
		<table align='center' border='1px' cellspacing='0px' cellpadding='5px'>
			<tr>
				<th>말머리</th>
				<td><select name="head">
				<option value="Y">필독</option>
				<option value="N">없음</option>
				</select></td>
			<tr>			
			<tr>
				<th>제목</th>
				<td><input type='text' name='title' size='50'></td>
			</tr>
				<th>내용</th>
				<td><input type='text' name='contents' size='50'></td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><input type='file' name='posterMF' size='50'></td>
			</tr>
		</table>
		<br>
		<br>
		<div class='bottom'>
			<input type='submit' value='등록'> <input type='button'
				value='공지사항 목록' onclick="location.href='Notice.do'">
		</div>

	</form>
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