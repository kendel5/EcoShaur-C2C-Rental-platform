<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>     
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/view/color.jspf" %>

<!DOCTYPE html>
<html lang="ko">

<style>
body, html {
  height: 100%;
  width: 100%;
}

.bg {
  /* The image used */
  background-image: url("https://cdn.imweb.me/thumbnail/20200415/590a940fa6c5a.jpg");

  /* Full height */
  height: 100%;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  
  position: fixed; 
  top: 0; 
  left: 0; 
    
  /* Preserve aspet ratio */
  min-width: 100%;
  min-height: 100%;
}

header{
	position:absolute;
	width:100%;
	top:0;
	z-index:11;
	font-color:white;
}
.banner {
	height:100vh;
	position:relative;
	width:100%;
	overflow: hidden;
	margin-top:30px;
	margin-left: 200px;
}

.banner-innner {
    padding: 200px 0;
}

.banner-left {
    text-align: right;
    width: 65%;
    margin: 0 auto;
}

.banner-left h1 {
    color: #fff;
    text-transform: uppercase;
    font-size: 42px;
    font-weight: 800;
    line-height: 50px;
    text-shadow: 1px 2px #000;
	margin-bottom:15px;
	text-align: right;
}

.banner-left p {
    color: #fff;
    letter-spacing: 0.5px;
    line-height: 28px;
	margin-bottom:30px;
}

.custom-btn {
    width: 100%;
    background: #E91E63;
    color: #fff;
    letter-spacing: 2.5px;
	transition:0.8 ease;
}

.banner-left a {
    background: #e91e63;
    color: #fff;
    text-decoration: none;
    text-transform: uppercase;
    letter-spacing: 2.5px;
    padding: 8px 35px;
    border-radius: 4px;
	transition:0.8 ease;
}

.banner-left a:hover{
	letter-spacing:3px;
	transition:0.8 ease;
}

.custom-btn:hover{
	letter-spacing:3px;
	transition:0.8 ease;
}

.navbar-light .navbar-brand {
    color: 	#fff;
    font-weight: 700;
    font-size: 30px;
    text-transform: uppercase;
    text-shadow: 1px 2px #000;
}
.navbar-light .navbar-nav .active>.nav-link, .navbar-light .navbar-nav .nav-link.active, .navbar-light .navbar-nav .nav-link.show, .navbar-light .navbar-nav .show>.nav-link {
    color: #fff;
}
.navbar-light .navbar-nav .active>.nav-link, .navbar-light .navbar-nav .nav-link.active, .navbar-light .navbar-nav .nav-link.show, .navbar-light .navbar-nav .show>.nav-link:hover {
    color: 	#DC143C;
}
.navbar-light .navbar-brand:focus, .navbar-light .navbar-brand:hover {
    color: #fff;
}
.navbar-light .navbar-nav .nav-link:focus, .navbar-light .navbar-nav .nav-link:hover {
    color: 	#DC143C;
}

.dropdown-menu {
    padding: 0px;
}

.dropdown-menu {
    padding: 0px;
}

span.navbar-toggler-icon {
    background-image: url(https://i.ibb.co/1v9M0dZ/menu.png) !important;
    width: 25px;
    height: 25px;
	cursor:pointer;
}

/* 드롭다운 서브메뉴 배경 */
a.dropdown-item {
    padding: 10px;
    background: #515156;
    color: #fff;
}



@media only screen and (max-width: 800px ){
.banner-left h1 {
    color: #fff;
    text-transform: uppercase;
    font-size: 30px;
    font-weight: 800;
    line-height: 35px;
    text-shadow: 1px 2px #000;
}

.banner{
	padding:120px 0;
	height: auto;
}

.nav-color{
	background:#fff;
	border-color: transparent;
}

.navbar-light .navbar-nav .nav-link{
	padding-left:0;
}
.banner-innner {
    padding: 120px 0;
}
}
.dropdown:hover .dropdown-menu {
    display: block;
    margin-top: 0;
}

.nav-link{
	rgb(90, 187, 255);
}

/* 검색창 */
#content {
  position: relative;
  height: 50px;
  width: 300px;
  margin-left: 90%;
}

#content.on {
  -webkit-animation-name: in-out;
  animation-name: in-out;
  -webkit-animation-duration: 0.7s;
  animation-duration: 0.7s;
  -webkit-animation-timing-function: linear;
  animation-timing-function: linear;
  -webkit-animation-iteration-count: 1;
  animation-iteration-count: 1;
}

/* 검색창-입력창 */
.input1 {
  box-sizing: border-box;
  width: 35px;
  height: 35px;
  border: 3px solid #ffffff;
  border-radius: 50%;
  background: none;
  color: #fff;
  font-size: 16px;
  font-weight: 400;
  font-family: Roboto;
  -webkit-transition: width 0.4s ease-in-out, border-radius 0.8s ease-in-out,
    padding 0.2s;
  transition: width 0.4s ease-in-out, border-radius 0.8s ease-in-out,
    padding 0.2s;
  -webkit-transition-delay: 0.4s;
  transition-delay: 0.4s;
  -webkit-transform: translate(-100%, -50%);
  -ms-transform: translate(-100%, -50%);
  transform: translate(-100%, -50%);
}

/* 검색-돋보기 */
.search {
  background: none;
  position: absolute;
  top: 0px;
  left: 0;
  height: 40px;
  width: 40px;
  padding: 0;
  border-radius: 100%;
  border: 0;
  color: inherit;
  cursor: pointer;
  -webkit-transition: 0.2s ease-in-out;
  transition: 0.2s ease-in-out;
  -webkit-transform: translate(-100%, -50%);
  -ms-transform: translate(-100%, -50%);
  transform: translate(-100%, -50%);
}

.search:before {
  content: "";
  position: absolute;
  width: 20px;
  height: 4px;
  background-color: #fff;
  -webkit-transform: rotate(45deg);
  -ms-transform: rotate(45deg);
  transform: rotate(45deg);
  margin-top: 20px;
  margin-left: 17px;
  -webkit-transition: 0.2s ease-in-out;
  transition: 0.2s ease-in-out;
}

.close {
  -webkit-transition: 0.4s ease-in-out;
  transition: 0.4s ease-in-out;
  -webkit-transition-delay: 0.4s;
  transition-delay: 0.4s;
}

.close:before {
  content: "";
  position: absolute;
  width: 27px;
  height: 4px;
  margin-top: -1px;
  margin-left: -13px;
  background-color: #fff;
  -webkit-transform: rotate(45deg);
  -ms-transform: rotate(45deg);
  transform: rotate(45deg);
  -webkit-transition: 0.2s ease-in-out;
  transition: 0.2s ease-in-out;
}

.close:after {
  content: "";
  position: absolute;
  width: 27px;
  height: 4px;
  background-color: #fff;
  margin-top: -1px;
  margin-left: -13px;
  cursor: pointer;
  -webkit-transform: rotate(-45deg);
  -ms-transform: rotate(-45deg);
  transform: rotate(-45deg);
}

.square {
  box-sizing: border-box;
  padding: 0 40px 0 10px;
  width: 200px;
  height: 35px;
  border: 4px solid #ffffff;
  border-radius: 0;
  background: none;
  color: #fff;
  font-family: Roboto;
  font-size: 18px;
  font-weight: 400;
  -webkit-transition: width 0.4s ease-in-out, border-radius 0.4s ease-in-out,
    padding 0.2s;
  transition: width 0.4s ease-in-out, border-radius 0.4s ease-in-out,
    padding 0.2s;
  -webkit-transition-delay: 0.4s, 0s, 0.4s;
  transition-delay: 0.4s, 0s, 0.4s;
  -webkit-transform: translate(-100%, -50%);
  -ms-transform: translate(-100%, -50%);
  transform: translate(-100%, -50%);
}

</style>

<head>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
<!-- 헤더 시작	 -->
<header>
<nav class="navbar container navbar-expand-lg nav-color">
	  <input type="image" name="button" src="images/ㄹㅇ공룡.png" width="100" height="100">
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
		<ul class="navbar-nav">
	     <li class="nav-item"> <a class="nav-link" href="ranking/Top.jsp">TOP</a> </li>
		  <li class="nav-item dropdown">
		  	<a class="nav-link" href="Category.do?nowpage=1" id="navbarDropdown" role="button">대여목록</a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
			  <a class="dropdown-item" href="./category/CategoryDT.do?category=컴퓨터">컴퓨터</a>
			  <a class="dropdown-item" href="./category/CategoryDT.do?category=TV/영상가전">TV/영상가전</a>
			  <a class="dropdown-item" href="./category/CategoryDT.do?category=음향기기">음향기기</a>
			  <a class="dropdown-item" href="./category/CategoryDT.do?category=콘솔/게이밍">콘솔/게이밍</a>
			  <a class="dropdown-item" href="./category/CategoryDT.do?category=카메라">카메라</a>
			</div>
		  </li>
		  <li class="nav-item"> <a class="nav-link" href="Board.do">커뮤니티</a> </li>
		   <li class="nav-item dropdown">
		  	<a class="nav-link dropdown-toggle" href="Notice.do" id="navbarDropdown" role="button">고객센터</a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
			  <a class="dropdown-item" href="Notice.do">공지사항</a>
			  <a class="dropdown-item" href="Qna.do">QnA</a>
			</div>
		  </li>
		  <li class="nav-item dropdown">
		  	<a class="nav-link dropdown-toggle" href="login.do" id="navbarDropdown" role="button">마이페이지</a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdown">
			  <a class="dropdown-item" href="login.do">로그인/회원가입</a>
			  <a class="dropdown-item" href="member/Mypage.do">회원정보</a>
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
</head>
	
<body class="bg">	 
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