<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 NResult.jsp-->

<div class="container">
<br><br><br><br><br><br><br><br><br>
	
  <H3>[ 알 림 창 ]</H3>
 	<br><br>
  <div class="content">
	<dl>
		<dd>${msg }</dd>
	</dl>
  </div>
  	<br><br>		
	<div class='bottom'>
		<input type='button' value='공지사항 목록'
			onclick="location.href='Notice.do?nowpage=1'">
	</div>
	
<br><br><br><br><br><br><br><br><br>
<!-- 본문 끝 -->
<%@ include file="../e_footer.jsp"%>