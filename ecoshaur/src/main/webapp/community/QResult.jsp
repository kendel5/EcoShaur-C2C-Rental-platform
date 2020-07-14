<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 QResult.jsp-->
<body>
<div class="container">
  <div class="content">
	<dl>
		<dd>${msg }</dd>
	</dl>
  </div>
  	<br><br>		
	<div class='bottom'>
		<input type='button' value='돌아가기'
			onclick="location.href='Qna.do'">
	</div>
</div>
</body>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>