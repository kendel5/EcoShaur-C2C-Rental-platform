<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">

<!doctype html>
<html lang="en">
 
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="../assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="./assets/libs/css/style.css">
    <link rel="stylesheet" href="./assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
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
</head>

<body>
    <!-- ============================================================== -->
    <!-- forgot password  -->
    <!-- ============================================================== -->
    <div class="splash-container">
        <div class="card">
            <div class="card-header text-center"><h2 style="color:#5c8bf5; font-weight: bold;">비밀번호 찾기</h2></div>
            <div class="card-body">
                <form name=findpw method='post' action="findPw.do" onsubmit="return findPasswdCheck(this)">
                    <div class="form-group">
                        <input class="form-control form-control-lg" type="id" name="id" required="" placeholder="아이디를 입력하세요" autocomplete="off">
                    </div>
                    <div class="form-group">
                        <input class="form-control form-control-lg" type="email" name="email" required="" placeholder="이메일을 입력하세요" autocomplete="off">
                    </div>
                    <div class="form-group pt-1"><input type="submit" id="login-submit" class="btn btn-primary btn-block" value="비밀번호 찾기"></div>
                </form>
            </div>
            <div class="card-footer text-center">
                <span>아직 계정이 없으신가요?  <a href="agree.do">회원가입</a></span>
                <div class="card-footer-item card-footer-item-bordered">
                    <a href="./" class="footer-link">돌아가기</a>
                </div>
            </div>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- end forgot password  -->
    <!-- ============================================================== -->
    <!-- Optional JavaScript -->
    <script src="./assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <script src="./assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
</body>

 
</html>


