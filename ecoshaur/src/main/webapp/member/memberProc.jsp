<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="ssi.jsp"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">

<style>
 p {
    font-family: "Nanum Gothic", sans-serif;
    font-size: 30px;
    font-weight: 800;
   }
</style>

<!-- 본문 시작 template.jsp-->
<br><br><br><br>

<h3> * 회 원 가 입  결과 * </h3>
<!-- 본문시작 -->
	<div align="center">
	<c:if test="${res==1 }">
		<meta http-equiv="Refresh" content="0;url=loginForm.do">
	</c:if>
	
	<c:if test="${res==0 }">
		회원가입에 실패했습니다<br>
		<a href="javascript:history.go(-1)">[돌아가기]</a>
	</c:if>
	</div>
<!-- 본문끝 -->




<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- 본문 끝 -->		
<%@ include file="../e_footer.jsp" %>