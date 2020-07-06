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

<!-- 본문 시작 idCheckForm.jsp-->
<div class="container" style="text-align: center">
	<h3>아이디 중복확인</h3>
	<br>
	<form method="post"
		  action="idCheckPro.do"
		  onsubmit="return blankCheck(this)">
		아이디:
		<input type='text' name='uid' maxlength='10' autofocus>
		<input class="btn btn-default" type="submit" value="중복확인">
	</form>
	<script>
		function blankCheck(f){
			var id = f.id.value;
			id = id.trim();
			id = id.replace(/^\s*|\s*$/g, '');
			if(id.length==0){
				alert("아이디를 입력해주세요");
				f.id.focus();
				return false;
			}//if end
			if(id.length<5){
				alert("아이디는 5글자이상으로 입력해주세요");
				f.id.focus();
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
</body>
</html>