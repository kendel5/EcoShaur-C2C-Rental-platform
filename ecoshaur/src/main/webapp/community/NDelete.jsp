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
<br><br><br><br><br><br><br><br><br><br>

	<form method="post" action="NDelete.do">
		<input type="hidden" name="postno" value="${dto.postno}">
		<div class="content">
			<p>정말 공지사항을 삭제하시겠습니까?</p>
			<p>삭제된 공지사항은 복구할 수 없습니다.</p>
		</div>

		<div class='bottom'>
			<input type="submit" value="삭제하기"> <input type='button'
				value='삭제취소'
				onclick="location.href='NRead.do?postno=${dto.postno}'">
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