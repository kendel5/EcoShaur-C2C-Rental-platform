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
<br><br><br><br><br><br><br>

<div class="container">
<form class="form-horizontal"
	  name="mypage"
      method="post"
      onsubmit="return memberCheck(this)" >
      
        
        <div class="col-sm-1"></div><div class="col-sm-10">
            <h4 class="mb-3 text-left"><strong>회원정보</strong></h4>
            
                <div class="card" align="left">
                <span>아이디: ${dto.id }</span><br>
                <span>이름: ${dto.mem_name }</span><br>
                <span>연락처: ${dto.contact_number }</span><br>
                <span>이메일: ${dto.email }</span><br>
                <span>우편번호: ${dto.zip }</span><br>
                <span>주소: ${dto.address }</span><br>
                <span>나머지주소: ${dto.address_r }</span><br>
                <span>등급: ${dto.grade }</span><br>
                <span>포인트: ${dto.point }</span><br>
                <span>가입일: ${dto.joined_date }</span><br>
                <span>최종로그인: ${dto.lastdate }</span><br>
                
                </div>
                <br>
		<tr>
        <td colspan="2">
			<input type="submit" class="btn btn-outline-success" value="로그아웃">
			<input type="submit" class="btn btn-outline-success" value="회원정보수정">
			<input type="reset" class="btn btn-outline-info" value="회원탈퇴">
		</td>
		</tr>
		</form>
    </div>




<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- 본문 끝 -->		
<br><br>
<%@ include file="../e_footer.jsp" %>