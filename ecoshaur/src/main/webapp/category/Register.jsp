<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register.jsp</title>

<style>
p {
	font-family: "Nanum Gothic", sans-serif;
	font-size: 30px;
	font-weight: 800;
}
</style>
<body>

	<div class="title">대여해 줄 기기 등록</div>

	<form name='frm' method='POST' action='register.do'
		enctype="multipart/form-data">
		<input type='hidden' name='product_no' value='${product_no}'>

		<table class='table'>
			<tr>
				<th>제목</th>
				<td><input type='text' name='title' size='50'></td>
			</tr>
			<tr>
				<th>소제목</th>
				<td width="343" colspan="5"><input type="text" name="name"
					size="47" maxlength="100" value=""></td>
			</tr>
			<tr>
				<th>상품명</th>
				<td width="343" colspan="5"><input type="text" name="name"
					size="47" maxlength="100" value=""></td>
			</tr>
			<tr>
				<th>하루 대여료</th>
				<td width="70">
					<!-- onBlur == 내용을 바꾸지 않더라도 포커스를 잃으면 바로 이벤트 발생 --> <input
					type="text" name="price" size="11" onBlur=""
					onKeyUp='NumFormat(this)' value="">
				</td>
			</tr>
			<tr>
				<th>썸네일</th>
				<td><input type='file' name='thmbMF' size='50'></td>
			</tr>
			<tr>
				<th>제품 이미지</th>
				<td><input type='file' name='imageMF' size='50'></td>
			</tr>
			<tr>
				<th>상세설명</th>
				<td><input type='text' name='description' size='450'></td>
			</tr>

		</table>

		<div class='bottom'>
			<input type='submit' value='등록'> <input type='button'
				value='목록' onclick="window.location.href='list.do'">
		</div>

	</form>
</body>
</html>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>