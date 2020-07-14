<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="../assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="../assets/libs/css/style.css">
    <link rel="stylesheet" href="../assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <link rel="stylesheet" href="../assets/vendor/charts/chartist-bundle/chartist.css">
    <link rel="stylesheet" href="../assets/vendor/charts/morris-bundle/morris.css">
    <link rel="stylesheet" href="../assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="../assets/vendor/charts/c3charts/c3.css">
    <link rel="stylesheet" href="../assets/vendor/fonts/flag-icon-css/flag-icon.min.css">
</head>
<%@ include file="./header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
        <!-- ============================================================== -->
        <!-- end left sidebar -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- wrapper  -->
        <!-- ============================================================== -->
        <div class="dashboard-wrapper">
            <div class="dashboard-ecommerce">
                <div class="container-fluid dashboard-content ">
                    <!-- ============================================================== -->
                    <!-- pageheader  -->
                    <!-- ============================================================== -->
                    <div class="row">
                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                            <div class="page-header">
                                <h2 class="pageheader-title">통합 대시보드</h2>
                                <div class="page-breadcrumb">
                                    <nav aria-label="breadcrumb">
                                        <ol class="breadcrumb">
                                            <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">대시보드</a></li>
                                            <li class="breadcrumb-item active" aria-current="page">통합 대시보드</li>
                                        </ol>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- ============================================================== -->
                    <!-- end pageheader  -->
                    <!-- ============================================================== -->
                    <div class="ecommerce-widget">
                        <div class="row">
                            <!-- ============================================================== -->
                            <!-- sales  -->
                            <!-- ============================================================== -->
                            <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 col-12">
                                <div class="card border-3 border-top border-top-primary">
                                    <div class="card-body">
                                        <h5 class="text-muted">총 거래금액</h5>
                                        <div class="metric-value d-inline-block">
                                            <h1 class="mb-1">${total_price} 원</h1>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                            <!-- ============================================================== -->
                            <!-- end sales  -->
                            <!-- ============================================================== -->
                            <!-- ============================================================== -->
                            <!-- new customer  -->
                            <!-- ============================================================== -->
                            <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 col-12">
                                <div class="card border-3 border-top border-top-primary">
                                    <div class="card-body">
                                        <h5 class="text-muted">신규회원 수</h5>
                                        <div class="metric-value d-inline-block">
                                            <h1 class="mb-1">${new_user}</h1>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                            <!-- ============================================================== -->
                            <!-- end new customer  -->
                            <!-- ============================================================== -->
                            <!-- ============================================================== -->
                            <!-- visitor  -->
                            <!-- ============================================================== -->
                            <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 col-12">
                                <div class="card border-3 border-top border-top-primary">
                                    <div class="card-body">
                                        <h5 class="text-muted">방문자</h5>
                                        <div class="metric-value d-inline-block">
                                            <h1 class="mb-1">${visitor }</h1>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                            <!-- ============================================================== -->
                            <!-- end visitor  -->
                            <!-- ============================================================== -->
                            <!-- ============================================================== -->
                            <!-- total orders  -->
                            <!-- ============================================================== -->
                            <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12 col-12">
                                <div class="card border-3 border-top border-top-primary">
                                    <div class="card-body">
                                        <h5 class="text-muted">총 주문수</h5>
                                        <div class="metric-value d-inline-block">
                                            <h1 class="mb-1">${total_order }</h1>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- ============================================================== -->
                            <!-- end total orders  -->
                            <!-- ============================================================== -->
                        </div>
                        <div class="row">
                            <!-- ============================================================== -->
                      
                            <!-- ============================================================== -->

                                          <!-- recent orders  -->
                            <!-- ============================================================== -->
                            <div class="col-xl-9 col-lg-12 col-md-6 col-sm-12 col-12">
                                <div class="card">
                                    <h5 class="card-header">최근 주문목록</h5>
                                    <div class="card-body p-0">
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead class="bg-light">
                                                    <tr class="border-0">
                                                        <th class="border-0">#</th>
                                                        <th class="border-0">이미지</th>
                                                        <th class="border-0">상품이름</th>
                                                        <th class="border-0">주문자</th>
                                                        <th class="border-0">갯수</th>
                                                        <th class="border-0">총 금액</th>
                                                        <th class="border-0">결제일</th>
                                                        <th class="border-0">결제방법</th>
                                                        <th class="border-0">상태</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="dto" items="${Olist}" varStatus="status">
                                                    <tr>
                                                        <td>${status.index+1 }</td>
                                                        <td>
                                                            <div class="m-r-10"><img src="../category/storage/${Rlist[status.index].thmb_name}" alt="user" class="rounded" width="45"></div>
                                                        </td>
                                                        <td>${Rlist[status.index].product_name }</td>
                                                        <td>${IDlist[status.index].id  } </td>
                                                        <td>${dto.quantity }</td>
                                                        <td>${dto.total_price }</td>
                                                        <td>${dto.payment_date }</td>
                                                        <td>${dto.payment }</td>

                                                        <c:choose>
															<c:when  test="${dto.order_condition eq 'C'}">
														    	<td>대여완료 <span class="badge-dot badge-success mr-1"></span>
															</c:when>
															<c:when  test="${dto.order_condition eq 'P'}">
														    	<td>대여중 <span class="badge-dot badge-brand mr-1"></span>
															</c:when>
															<c:when  test="${dto.order_condition eq 'F'}">
														    	<td>환불 <span class="badge-dot badge-danger mr-1"></span>
															</c:when>
														</c:choose>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                    <tr>
                                                        <td colspan="9"><a href="./pages/newOrderList.do" class="btn btn-outline-light float-right">상세보기</a></td>
                                                    </tr>

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- ============================================================== -->
                            <!-- end recent orders  -->

    
                            <!-- ============================================================== -->
                            <!-- ============================================================== -->
                            <!-- customer acquistion  -->
                            <!-- ============================================================== -->
                            <div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
                                <div class="card">
                                    <h5 class="card-header">Top 유저 포인트</h5>
                                    <div class="card-body p-0">
                                        <div class="table-responsive">
                                            <table class="table no-wrap p-table">
                                                <thead class="bg-light">
                                                    <tr class="border-0">
                                                        <th class="border-0">ID</th>
                                                        <th class="border-0">포인트</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="dto" items="${top_point}" varStatus="status">
                                                    <tr>
                                                        <td>${dto.id }</td>
                                                        <td>${dto.point } </td>
                                                    </tr>
                                                </c:forEach>
                                                    
                                                    <tr>
                                                        <td colspan="2">
                                                            <a href="./pages/top_point.do" class="btn btn-outline-light float-right">상세보기</a>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- ============================================================== -->
                            <!-- end customer acquistion  -->
                            <!-- ============================================================== -->
                        </div>
                        
						<div class="row">
                    <!-- ============================================================== -->
                    <!-- top selling products  -->
                    <!-- ============================================================== -->
                    <div class="col-xl-9 col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card">
                            <h5 class="card-header">카테고리별 요약</h5>
                            <div class="card-body p-0">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead class="bg-light">
                                            <tr class="border-0">
                                                <th class="border-0">#</th>
                                                <th class="border-0">카테고리</th>
                                                <th class="border-0">상품게시물 갯수</th>
                                                <th class="border-0">평균 상품금액</th>
                                                <th class="border-0">총 상품금액</th>
                                                <th class="border-0">평균 보증금</th>
                                                <th class="border-0">총 보증금</th>
                                                <th class="border-0">평균 거래금액</th>
                                                <th class="border-0">총 거래금액</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="i" begin="0" end="4">
                                            <tr>
                                                <td>${i+1 }</td>
                                                <td>${Category_info[i][0]}</td>
                                                <td>${Category_info[i][1]}</td>
                                                <td>${Category_info[i][2]}</td>
                                                <td>${Category_info[i][3]}</td>
                                                <td>${Category_info[i][4]}</td>
                                                <td>${Category_info[i][5]}</td>
                                                <td>${Category_info[i][6]}</td>
                                                <td>${Category_info[i][7]}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
                                <div class="card">
                                    <h5 class="card-header">환불 Top 대여자</h5>
                                    <div class="card-body p-0">
                                        <div class="table-responsive">
                                            <table class="table no-wrap p-table">
                                                <thead class="bg-light">
                                                    <tr class="border-0">
                                                        <th class="border-0">ID</th>
                                                        <th class="border-0">상품번호</th>
                                                        <th class="border-0">환불갯수</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="dto" items="${topFail_rental}" varStatus="status">
                                                    <tr>
                                                        <td>${dto.id }</td>
                                                        <td>${dto.product_no } </td>
                                                        <td>${topFail_condition[status.index].deposit } </td>
                                                    </tr>
                                                </c:forEach>
                                                   
                                                    <tr>
                                                        <td colspan="3">
                                                            <a href="./pages/BadTopUser.do" class="btn btn-outline-light float-right">상세보기</a>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                    
                    
                    <!-- ============================================================== -->
                    <!-- end revenue locations  -->
                    <!-- ============================================================== -->
                </div>
                        
                    </div>
                </div>
            </div>
            
        </div>
        <!-- ============================================================== -->
        <!-- end wrapper  -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- end main wrapper  -->
    <!-- ============================================================== -->
    <!-- Optional JavaScript -->
    <!-- jquery 3.3.1 -->
    <script src="../assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <!-- bootstap bundle js -->
    <script src="../assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
    <!-- slimscroll js -->
    <script src="../assets/vendor/slimscroll/jquery.slimscroll.js"></script>
    <!-- main js -->
    <script src="../assets/libs/js/main-js.js"></script>
    <!-- chart chartist js -->
    <script src="../assets/vendor/charts/chartist-bundle/chartist.min.js"></script>
    <!-- sparkline js -->
    <script src="../assets/vendor/charts/sparkline/jquery.sparkline.js"></script>
    <!-- morris js -->
    <script src="../assets/vendor/charts/morris-bundle/raphael.min.js"></script>
    <script src="../assets/vendor/charts/morris-bundle/morris.js"></script>
    <!-- chart c3 js -->
    <script src="../assets/vendor/charts/c3charts/c3.min.js"></script>
    <script src="../assets/vendor/charts/c3charts/d3-5.4.0.min.js"></script>
    <script src="../assets/vendor/charts/c3charts/C3chartjs.js"></script>
    <script src="../assets/libs/js/dashboard-ecommerce.js"></script>
</body>
 
</html>