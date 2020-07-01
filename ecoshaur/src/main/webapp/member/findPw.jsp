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

<!-- 본문 시작 template.jsp-->
<h3> 비밀번호 찾기 </h3>

<div class="container">
	<form name=memberUpdate
	      method='post'
	      action="find_passwordProc.do"
		  onsubmit="return findPasswdCheck(this)">
		<div class="col-sm-4"></div><div class="col-sm-4">
	 	<div class="row">
	 	<div class="login-box well">
			<div class="form-group text-left">
				<div class="input-group">
					<span class="input-group-addon font1" style="min-width:120px; font-size:120%;">이름</span>
					<input type="text" class="form-control" name="mem_name" id="mem_name" size="20" placeholder="이름을 입력하세요" required>
	 			</div>
	        </div>
			<div class="form-group text-left">
				<div class="input-group">
					<span class="input-group-addon font1" style="min-width:120px; font-size:120%;">이메일</span>
					<input type="text" class="form-control" name="email" id="email" size="50" placeholder="이메일을 입력하세요" required>
	 			</div>
	        </div>
	        <input type="submit" id="login-submit" class="btn btn-default btn-block" value="비밀번호 찾기">
	     </div>
	</div>
	<div class="col-sm-4"></div>
	</div>
	</form>
</div>




<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- 본문 끝 -->		
<%@ include file="../e_footer.jsp" %>