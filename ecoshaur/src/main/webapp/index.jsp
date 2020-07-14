<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>     
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html lang="ko">

<head>
	<script src="assets/js/myscript.js"></script>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link href="assets/libs/css/header.css" rel="stylesheet" type="text/css">
	<link href="assets/libs/css/header.css" rel="stylesheet" type="text/css">
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link href="assets/libs/css/index_style.css" rel="stylesheet" type="text/css">
<!-- 헤더 시작	 -->

</head>
	
<body class="bg">	
	<header>
		<nav class="navbar container navbar-expand-lg nav-color">
		<c:choose>
			<c:when  test="${grade eq 'M'}">
		    	<a href="admin/index.do"><button style="width:150px; height:43px; cursor:hand; opacity:0;"></button></a>
			</c:when>
		</c:choose>
	  <input type="image" name="button" src="assets/images/ㄹㅇ공룡.png" width="100" height="100">
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
		<ul class="navbar-nav">
	     <li class="nav-item"> <a class="nav-link" href="Point.do">TOP</a> </li>
		  <li class="nav-item dropdown">
		  	<a class="nav-link" href="Category.do?nowpage=1" id="navbarDropdown" role="button">대여목록</a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
			  <a class="dropdown-item" href="CategoryDT.do?category=컴퓨터&nowpage=1">컴퓨터</a>
			  <a class="dropdown-item" href="CategoryDT.do?category=TV/영상가전&nowpage=1">TV/영상가전</a>
			  <a class="dropdown-item" href="CategoryDT.do?category=음향기기&nowpage=1">음향기기</a>
			  <a class="dropdown-item" href="CategoryDT.do?category=콘솔/게이밍&nowpage=1">콘솔/게이밍</a>
			  <a class="dropdown-item" href="CategoryDT.do?category=카메라&nowpage=1">카메라</a>
			</div>
		  </li>
		  <li class="nav-item"> <a class="nav-link" href="Board.do?nowpage=1">커뮤니티</a> </li>
		   <li class="nav-item dropdown">
		  	<a class="nav-link dropdown-toggle" href="Notice.do?nowpage=1" id="navbarDropdown" role="button">고객센터</a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
			  <a class="dropdown-item" href="Notice.do?nowpage=1">공지사항</a>
			  <a class="dropdown-item" href="Qna.do">QnA</a>
			</div>
		  </li>
		  <li class="nav-item dropdown">
		  	<a class="nav-link dropdown-toggle" href="login.do" id="navbarDropdown" role="button">마이페이지</a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
			  <a class="dropdown-item" href="login.do">로그인/회원가입</a>
			  <a class="dropdown-item" href="mypage.do">회원정보</a>
			  <a class="dropdown-item" href="Cart.do?nowpage=1&id=${id }">장바구니</a>
			</div>
		  </li>
		
		<!-- 검색창/돋보기 -->
		<li>
		<form id="content">
			<!-- 돋보기 아이콘(원형) -->
			<input type="text" name="input1" class="input1" id="search-input"
	   	   	   	   style="margin-top: 35px; margin-right: 0px;
    	      		      margin-left: 100px; border-top-width: 4px;">
			<!-- 돋보기 아이콘(막대기) -->			  
			<button type="reset" class="search" id="search-btn" style="left:100px; top: 33px;">
			</button>
		</form>
		</li>
		</ul>
	  </div>
	 </nav>
 
    <!-- 검색 기능 -->
	<script>
		const input = document.getElementById("search-input");
		const searchBtn = document.getElementById("search-btn");
		const expand = () => {
			searchBtn.classList.toggle("close");
			input.classList.toggle("square");
		};
		searchBtn.addEventListener("click", expand);
	</script>
    </header>
     
	<div class="banner">
      <div class="banner-innner">
	    <div class="container">
		  <div class="row">
		  
		    <div class="col-md-12">
			  <div class="banner-left">
			    <h1> 비싼 가격 때문에 고민이라면 <br> 대여하자! </h1>
				<a href="login.do">글작성하기</a>
			  </div>
			</div>

		  </div>
		</div>
	  </div>
    </div>	
<!-- banner closed with header -->



	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</body>
</html>