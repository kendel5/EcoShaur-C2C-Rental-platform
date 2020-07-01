<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../eco.jsp"%>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">

<!-- 본문 시작 pointList.jsp-->
<!-- <p>게시판</p><br> -->                                                 

<div>
<c:forEach var="dto2" items="${memberlist}">
	프로필 : ${dto2.pro_name}<br>
	닉네임 : ${dto2.mem_name}<br>
	등급 : ${dto2.grade}<br>
</c:forEach>
<c:forEach var="dto1" items="${pointlist}">
	포인트 : ${dto1.point}<br>
</c:forEach>
</div>


<!-- 본문 끝 -->			
<%@ include file="../footer.jsp" %>