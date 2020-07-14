<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>
<!-- 본문 시작 rental_delete.jsp-->


<div class="container">
	<h1 style="color:red;">정말 상품을 삭제하시겠습니까?</h1>
	<form action="rental_delete.do" method="post">
	<input type="hidden" value="${product_no}" name="product_no">
	<br><br><br>
		<input class="btn btn-danger" type="submit" value="삭제">
		<a class="btn btn-warning" href="Category.do">취소</a>
	</form>
</div>

<!-- 본문 끝 -->		
<%@ include file="../footer.jsp" %>