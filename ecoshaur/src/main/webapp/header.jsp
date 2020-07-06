<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>     
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<script src="../js/myscript.js"></script>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link href="css/header.css" rel="stylesheet" type="text/css">
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<!-- 헤더 시작	 -->
<header>
<nav class="navbar container navbar-expand-lg nav-color">
	  <a href="/ecoshaur/"><img src="./images/ㄹㅇ공룡.png" width="100" height="100"></a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
		<ul class="navbar-nav">
	     <li class="nav-item"> <a class="nav-link" href="#">TOP</a> </li>
		  <li class="nav-item dropdown">
		  	<a class="nav-link" href="Category.do?nowpage=1" id="navbarDropdown" role="button">대여목록</a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
			  <a class="dropdown-item" href="./CategoryDT.do?category=컴퓨터">컴퓨터</a>
			  <a class="dropdown-item" href="./CategoryDT.do?category=TV/영상가전">TV/영상가전</a>
			  <a class="dropdown-item" href="./CategoryDT.do?category=음향기기">음향기기</a>
			  <a class="dropdown-item" href="./CategoryDT.do?category=콘솔/게이밍">콘솔/게이밍</a>
			  <a class="dropdown-item" href="./CategoryDT.do?category=카메라">카메라</a>
			</div>
		  </li>
		  <li class="nav-item"> <a class="nav-link" href="Board.do">커뮤니티</a> </li>
		   <li class="nav-item dropdown">
		  	<a class="nav-link dropdown-toggle" href="Notice.do" id="navbarDropdown" role="button" >고객센터</a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
			  <a class="dropdown-item" href="Notice.do">공지사항</a>
			  <a class="dropdown-item" href="Qna.do">QnA</a>
			</div>
		  </li>
		  <li class="nav-item dropdown">
		  	<a class="nav-link dropdown-toggle" href="login.do" id="navbarDropdown" role="button" >마이페이지</a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
			  <a class="dropdown-item" href="login.do">로그인/회원가입</a>
			  <a class="dropdown-item" href="Mypage.do">회원정보</a>
			  <a class="dropdown-item" href="Cart.do?id=Buyer&nowpage=1">장바구니</a>
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
			<button type="reset" class="search" id="search-btn"
					style="left: 100px; top: 33px;">
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
    
<!-- container 시작 -->
<div class="container-fluid bg-3 text-center">    
  <div class="row">
    <div class="col-sm-12">
    
    


