<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 template.jsp-->

<%
		
//2 : 로그인 페이지로 이동시킴 
response.sendRedirect("login.do");

%>


<!-- 본문 끝 -->		
<%@ include file="../footer.jsp" %>