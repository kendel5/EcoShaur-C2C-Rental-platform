<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">

<style>
p {
	font-family: "Nanum Gothic", sans-serif;
	font-size: 30px;
	font-weight: 800;
}
</style>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>category/deleteForm.jsp</title>

</head>
<body>

	<div class="title">대여 기기 등록 취소</div>

	<form method="post" action="./delete.do">
		<input type="hidden" name="product_no" value="${dto.product_no}">
		<div class="content">
			<p>등록을 취소하시겠습니까?</p>
			<p>※ 저장했던 기록이 모두 삭제됩니다</p>
		</div>

		<div class='bottom'>
			<input type="submit" value="삭제"> <input type='button'
				value='목록'
				onclick="location.href='list.do?product_no=${dto.product_no}'">
		</div>
	</form>
</body>
</html>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>
