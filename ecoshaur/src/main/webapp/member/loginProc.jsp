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

<!-- 본문 시작 loginProc.jsp-->
<br><br><br><br>

<h3>로그인 결과</h3>

<!-- 본문시작 -->
	<div align="center">
	<c:if test="${res==1 }">
		<c:set var="memid" value="${s_id }" scope="session"/>
		<meta http-equiv="Refresh" content="0;url=loginForm.do">
	</c:if>
	
	<c:if test="${res==0 }">
		아이디 또는 비밀번호를 확인해주세요<br>
		<a href="javascript:history.go(-1)">[돌아가기]</a>
	</c:if>
	</div>
<!-- 본문끝 -->
<br><br><br><br>
<%@ include file="../e_footer.jsp" %>