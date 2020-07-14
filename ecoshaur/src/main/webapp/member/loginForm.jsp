<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<c:choose>
	<c:when  test="${(grade eq 'U') || (grade eq 'S') || (grade eq 'P') || (grade eq 'M')}">

		<script>window.location.href = 'mypage.do';</script>

	</c:when>
	<c:otherwise>
	    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="./assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="./assets/libs/css/style.css">
    <link rel="stylesheet" href="./assets/vendor/fonts/fontawesome/css/fontawesome-all.css">

<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
				<style>


    html,
    body {
        height: 100%;
    }

    body {
        display: -ms-flexbox;
        display: flex;
        -ms-flex-align: center;
        align-items: center;
        padding-top: 40px;
        padding-bottom: 40px;
    }


</style>

<!-- 본문 시작 loginForm.jsp-->
<br>
<br>
<br>
<br>
<br>

<!-- ============================================================== -->
    <div class="splash-container">
        <div class="card ">
            <div class="card-header text-center"><h2 style="color:#5c8bf5; font-weight: bold;">로그인</h2></div>
            <div class="card-body">
                <form name="loginfrm" method="post" action="login.do">
                    <div class="form-group">
                        <input class="form-control form-control-lg" id="id" name="id" type="text" placeholder="아이디" autocomplete="off" required>
                    </div>
                    <div class="form-group">
                        <input class="form-control form-control-lg" id="pw" name="pw" type="password" placeholder="패스워드" required>
                    </div>
                    <div class="form-group">
                        <label class="custom-control custom-checkbox">
                            <input class="custom-control-input" type="checkbox" name="id"  value="SAVE"><span class="custom-control-label">아이디 저장</span>
                        </label>
                    </div>
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="로그인">
                </form>
            </div>
            <div class="card-footer bg-white p-0  ">
                <div class="card-footer-item card-footer-item-bordered">
                    <a href="agree.do" class="footer-link">회원가입</a></div>
                <div class="card-footer-item card-footer-item-bordered">
                    <a href="findpw.do" class="footer-link">비번찾기</a>
                </div>
                <div class="card-footer-item card-footer-item-bordered">
                    <a href="./" class="footer-link">돌아가기</a>
                </div>
            </div>
        </div>
    </div>
  
    <!-- ============================================================== -->
    <!-- end login page  -->
    <!-- ============================================================== -->
    <!-- Optional JavaScript -->
	</c:otherwise>
	        
</c:choose>
    