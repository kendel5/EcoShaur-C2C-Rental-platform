<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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

<!-- 본문 시작 emailCheckForm.jsp-->
<div class="container" style="text-align: center">
	<h3>이메일 중복확인</h3>
	<br>
	<form method="post"
		  action="emailCheckPro.do"
		  onsubmit="return blankCheck(this)">
		이메일:
		<input type='text' name='uemail' autofocus>
		<input class="btn btn-default" type="submit" value="중복확인">
	</form>
	<script>
		function blankCheck(f){
			var email = f.email.value;
			email = email.trim();
			email = email.replace(/^\s*|\s*$/g, '');
			if(email.length==0){
				alert("이메일을 입력해주세요");
				f.email.focus();
				return false;
			}//if end
			if(email.length<5){
				alert("이메일은 5글자이상으로 입력해주세요");
				f.email.focus();
				return false;
			}//if end
			return true;
		}// blankCheck() end
	</script>
	<br><hr><br>
</div>




<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- 본문 끝 -->		
