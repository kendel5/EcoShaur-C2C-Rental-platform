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

<!-- 본문 시작 memberProc.jsp-->

<h3> * 회 원 가 입  결과 * </h3>
<div class="container">

<div align="center">
	<c:if test="${check==1}">
		<script>
			alert("회원가입에 성공하였습니다.");
			window.location.href = './login.do';
		</script>
	</c:if>
	
	<c:if test="${check==0 }">
		<script>
			alert("회원가입에 성공하였습니다.");
			histroy.go(-1);
		</script>
	</c:if>
	</div>

</div>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- 본문 끝 -->		
<%@ include file="../footer.jsp" %>