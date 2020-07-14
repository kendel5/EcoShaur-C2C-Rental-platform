<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 BRead.jsp-->
<body>
<div class="container">
	
  <H3>[ 알 림 창 ]</H3>
 	<br><br>
  <div class="content">
	<dl>
		<dd>${msg }</dd>
	</dl>
  </div>
  	<br><br>		
	<div class='bottom'>
		<input type='button' value='게시판 목록'
			onclick="location.href='Board.do?nowpage=1'">
	</div>
</div>	
</body>
<!-- 본문 끝 -->		
<%@ include file="../footer.jsp" %>