<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="ssi.jsp"%>
<%@ include file="../header.jsp"%>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">

<style>
 p {
    font-family: "Nanum Gothic", sans-serif;
    font-size: 30px;
    font-weight: 800;
   }
   body {
       color: #999;
	   font-family: 'Varela Round', sans-serif;
	}
	

	.form-control {
		box-shadow: none;
		border-color: #ddd;
	}
	.form-control:focus {
		border-color: #4aba70; 
	}
	.login-form {
        width: 350px;
		margin: 0 auto;
		padding: 30px 0;
	}
    .login-form form {
        color: #434343;
		border-radius: 1px;
    	margin-bottom: 15px;
        background: #fff;
		border: 1px solid #f3f3f3;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
	}
	.login-form h4 {
		text-align: center;
		font-size: 22px;
        margin-bottom: 20px;
	}
    .login-form .avatar {
        color: #fff;
		margin: 0 auto 30px;
        text-align: center;
		width: 80px;
		height: 80px;
		border-radius: 50%;
		z-index: 9;
		padding: 15px;
		box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
	}
    .login-form .avatar i {
        font-size: 62px;
    }
    .login-form .form-group {
        margin-bottom: 20px;
    }
	.login-form .form-control, .login-form .btn {
		min-height: 40px;
		border-radius: 2px; 
        transition: all 0.5s;
	}
	.login-form .close {
        position: absolute;
		top: 15px;
		right: 15px;
	}
	.login-form .btn {
		background: #00D7FF;
		border: none;
		line-height: normal;
	}
	.login-form .btn:hover, .login-form .btn:focus {
		background: 	#DC143C;
	}
    .login-form .checkbox-inline {
        float: left;
    }
    .login-form input[type="checkbox"] {
        margin-top: 2px;
    }
    .login-form .forgot-link {
        float: right;
    }
    .login-form .small {
        font-size: 13px;
    }
    .login-form a {
        color: 	#DC143C;
    }  
} 
</style>

<!-- 본문 시작 loginForm.jsp-->
<br>
<br>
<br>
<br>
<br>


<h4>* 로 그 인 *</h4>
<div class="login-form">    
    <form name="loginfrm"
	      method="post"
	      action="loginProc.do"
	      onsubmit="return loginCheck(this)">
    	<h4 class="modal-title"></h4>
        <div class="form-group">
            <input type="text" name="id" value="${dto.id }" placeholder="아이디" required>
        </div>
        <div class="form-group">
            <input type="password" name="pw" placeholder="비밀번호" required>
        </div>
        <div class="form-group small clearfix">
            <input type="checkbox" name="c_id"  value="SAVE" >아이디저장
            <a href="#" class="forgot-link">아이디/비밀번호를 잊으셨나요?</a>
        </div> 
        <input type="submit" class="btn btn-primary btn-block btn-lg" value="Login">              
    </form>			
    <div class="text-center small">회원이 아니신가요? <a href="agree.do">회원가입</a></div>
</div>




<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- 본문 끝 -->		
<%@ include file="../e_footer.jsp" %>