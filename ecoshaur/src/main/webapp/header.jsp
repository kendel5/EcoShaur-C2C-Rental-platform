<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>     
<!DOCTYPE html>
<html lang="ko">
 
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/libs/css/style.css">
    <link rel="stylesheet" href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <link rel="stylesheet" href="assets/vendor/charts/chartist-bundle/chartist.css">
    <link rel="stylesheet" href="assets/vendor/charts/morris-bundle/morris.css">
    <link rel="stylesheet" href="assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendor/charts/c3charts/c3.css">
    <link rel="stylesheet" href="assets/vendor/fonts/flag-icon-css/flag-icon.min.css">
    <title>ECOSAUR</title>
</head>

<body>
   <!-- 메뉴 바 -->
   <div class="dashboard-main-wrapper">
   		<!-- 상단 메뉴 바 시작 -->
        <div class="dashboard-header">
            <nav class="navbar navbar-expand-lg bg-white fixed-top">
                <a class="navbar-brand" href="/ecoshaur/">ECOSHAUR</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse " id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto navbar-right-top">
                        <li class="nav-item">
                            <div id="custom-search" class="top-search-bar">
                                <input class="form-control" type="text" placeholder="Search">
                            </div>
                        </li>
                        <li class="nav-item dropdown nav-user">
                            <a class="nav-link nav-user-img" href="#" id="navbarDropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="assets/images/avatar-1.jpg" alt="" class="user-avatar-md rounded-circle"></a>
                            <div class="dropdown-menu dropdown-menu-right nav-user-dropdown" aria-labelledby="navbarDropdownMenuLink2">
                                <div class="nav-user-info">
                                	<!-- 멤버 이름 -->
                                    <h5 class="mb-0 text-white nav-user-name">${id }</h5>
                                    <!-- 멤버 등급 -->
                                    <span class="status"></span><span class="ml-2">Available</span>
                                </div>
                                <a class="dropdown-item" href="./login.do"><i class="fas fa-user mr-2"></i>로그인/회원가입</a>
                                <a class="dropdown-item" href="./mypage.do"><i class="fas fa-power-off mr-2"></i>마이페이지</a>
                                <a class="dropdown-item" href="./Cart.do?nowpage=1&id=${id}"><i class="fas fa-cog mr-2"></i>장바구니</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
		<!-- 상단 메뉴 바 끝 -->
        
        <!-- 사이드 메뉴 바 시작 -->
        <div class="nav-left-sidebar sidebar-dark">
            <div class="menu-list">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="d-xl-none d-lg-none" href="#">ECOSHAUR</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav flex-column">
                            <li class="nav-divider">메뉴</li>
                            <li class="nav-item ">
                                <!-- 대여목록 시작 -->
                                <a class="nav-link active" href="./Point.do" data-toggle="collapse" aria-expanded="false" data-target="#submenu-1" aria-controls="submenu-1"><i class="fas fa-burn"></i>랭킹보드<span class="badge badge-success">6</span></a>
                                <div id="submenu-1" class="collapse submenu" style="">
                                    <ul class="nav flex-column">
                                        <li class="nav-item">
                                            <a class="nav-link" href="./Point.do">포인트 랭킹</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="./Rating.do">좋아요 랭킹</a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="Category.do?nowpage=1" data-toggle="collapse" aria-expanded="false" data-target="#submenu-2" aria-controls="submenu-2"><i class="fa fa-fw fa-rocket"></i>대여목록</a>
                                <div id="submenu-2" class="collapse submenu" style="">
                                    <ul class="nav flex-column">
                                        <li class="nav-item">
                                            <a class="nav-link" href="./CategoryDT.do?category=컴퓨터&nowpage=1">컴퓨터</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="./CategoryDT.do?category=TV/영상가전&nowpage=1">TV/영상가전</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="./CategoryDT.do?category=음향기기&nowpage=1">음향기기</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="./CategoryDT.do?category=콘솔/게이밍&nowpage=1">콘솔/게이밍</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="./CategoryDT.do?category=카메라&nowpage=1">카메라</a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="./Board.do?nowpage=1" aria-expanded="false" data-target="#submenu-3" aria-controls="submenu-3"><i class=" fas fa-comment"></i>커뮤니티</a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href=".Notice.do?nowpage=1" data-toggle="collapse" aria-expanded="false" data-target="#submenu-4" aria-controls="submenu-4"><i class="fas fa-exclamation-circle"></i>고객센터</a>
                                <div id="submenu-4" class="collapse submenu" style="">
                                    <ul class="nav flex-column">
                                        <li class="nav-item">
                                            <a class="nav-link" href="./Notice.do?nowpage=1">공지사항</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="./Qna.do">QnA</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="./QCreate.do">1:1문의</a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>
           </div>
           <!-- 사이드 메뉴 바 끝 -->
        </div>
  </div>       
  <!-- 메뉴 바 끝 -->
  
  <!-- 컨텐츠 시작 -->
  <div class="dashboard-wrapper">
            <div class="dashboard-ecommerce">
                <div class="container-fluid dashboard-content ">
  
  
  
    <!-- Optional JavaScript -->
    <!-- jquery 3.3.1 -->
    <script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <!-- bootstap bundle js -->
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
    <!-- slimscroll js -->
    <script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
    <!-- main js -->
    <script src="assets/libs/js/main-js.js"></script>
    <!-- chart chartist js -->
    <script src="assets/vendor/charts/chartist-bundle/chartist.min.js"></script>
    <!-- sparkline js -->
    <script src="assets/vendor/charts/sparkline/jquery.sparkline.js"></script>
    <!-- morris js -->
    <script src="assets/vendor/charts/morris-bundle/raphael.min.js"></script>
    <script src="assets/vendor/charts/morris-bundle/morris.js"></script>
    <!-- chart c3 js -->
    <script src="assets/vendor/charts/c3charts/c3.min.js"></script>
    <script src="assets/vendor/charts/c3charts/d3-5.4.0.min.js"></script>
    <script src="assets/vendor/charts/c3charts/C3chartjs.js"></script>
    <script src="assets/libs/js/dashboard-ecommerce.js"></script>
</body>
 
</html>