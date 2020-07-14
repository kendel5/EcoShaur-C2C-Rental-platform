<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/i18n/defaults-*.min.js"></script>

<style>
 p {
    font-family: "Nanum Gothic", sans-serif;
    font-size: 30px;
    font-weight: 800;
   }
</style>

<!-- 본문 시작 template.jsp-->
<div class="container">
	<h3>* 상품 등록 *</h3>
	<p>
		<a href="Category.do?nowpage=1" class="btn btn-success">상품 목록</a>
	</p>
	<form name="rentalfrm" method="post" action="Rental_resister.do" enctype="multipart/form-data">
		<input type="hidden" value="${id }" name="id">
		<table class="table">
			<tr style="font-family: 'NanumSquare', sans-serif; font-size: 120%;">
				<th>제목</th>
				<td><input type="text" name="title" size="10" maxlength="30"
					required class="form-control"></td>
			</tr>
			<tr style="font-family: 'NanumSquare', sans-serif; font-size: 120%;">
				<th>소제목</th>
				<td><input type="text" name="sub_title" size="30" maxlength="30"
					required class="form-control"></td>
			</tr>
			<tr style="font-family: 'NanumSquare', sans-serif; font-size: 120%;">
				<th>상품명</th>
				<td><input type="text" name="product_name" size="30" maxlength="30"
					required class="form-control"></td>
			</tr>
			<tr style="font-family: 'NanumSquare', sans-serif; font-size: 120%;">
				<th>내용</th>
				<td>
					<textarea class="form-control" id="description" name="description"></textarea>
				</td>
			</tr>
			<tr>
				<th style="font-family: 'NanumSquare', sans-serif; font-size: 120%;">일일가격</th>
				<td><input type="text" name="price_daily" size="10"
					maxlength="10" required class="form-control"></td>
			</tr>
						<tr>
				<th style="font-family: 'NanumSquare', sans-serif; font-size: 120%;">보증금</th>
				<td><input type="text" name="deposit" size="10"
					maxlength="10" required class="form-control"></td>
			</tr>
			<tr>
				<th style="font-family: 'NanumSquare', sans-serif; font-size: 120%;">수량</th>
				<td><input type="text" name="total_quantity" size="10"
					maxlength="10" required class="form-control"></td>
			</tr>
			<tr>
				<th style="font-family: 'NanumSquare', sans-serif; font-size: 120%;">썸네일</th>
				<td align="left"><input type='file' name='posterMF' size='50' accept=".gif, .png, .jpg"></td>
			</tr>
			<tr>
				<th style="font-family: 'NanumSquare', sans-serif; font-size: 120%;">이미지</th>
				<td align="left"><input type='file' name='filenameMF' size='50' accept=".gif, .png, .jpg"></td>
			</tr>
			<tr>
				<th style="font-family: 'NanumSquare', sans-serif; font-size: 120%;">카테고리 선택</th>
				<td align="left">
					<select name="ctCode" id="ctCode" class="selectpicker" data-live-search="true">
					    <option value="">게시판명 선택</option>
					    <c:forEach var="mn" items="${minor}">
					        <option value="${mn.minor}">${mn.minor}</option>
					    </c:forEach>
					    	<option value=""></option>
					    	<option value=""></option>
					    	<option value=""></option>
					</select>
				</td>
				
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="쓰기"
					class="btn btn-success"> <input type="reset" value="취소"
					class="btn btn-success"></td>
			</tr>
		</table>
	</form>
</div>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- 본문 끝 -->		
<%@ include file="../footer.jsp" %>