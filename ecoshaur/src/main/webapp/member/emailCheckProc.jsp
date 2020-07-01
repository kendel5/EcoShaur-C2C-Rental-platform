<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.sql.Timestamp"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="ssi.jsp"%>

<!DOCTYPE html>
<html lang="ko">
<head>

<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">

<style>
 p {
    font-family: "Nanum Gothic", sans-serif;
    font-size: 30px;
    font-weight: 800;
   }
</style>

<!-- 본문 시작 template.jsp-->

<div style="text-align: center">
<h3>* 이메일 중복확인  결과 *</h3>

<c:if test="${requestScope.cnt==1 }">
	<p style='color:red'>해당 이메일은 사용할 수 없습니다!!</p>
</c:if>

<c:if test="${requestScope.cnt==0 }">
	<p>사용 가능한 이메일입니다</p>
	<a class='btn btn-success' href='javascript:apply(\"" + id + "\")'>적용</a>
		<script>
	function apply(email){
		//alert(id);
		// 중복이 확인된 id를 부모창(opener)에 적용
		opener.memberForm.email.value=email;
		window.close();
	}// apply() end
	</script>
</c:if>



	<hr>
	<a class="btn btn-default" href="javascript:history.back()">다시입력</a>
	&nbsp;&nbsp;
	<a class="btn btn-default" href="javascript:window.close()">창닫기</a>

</div>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- 본문 끝 -->		
</body>
</html>
