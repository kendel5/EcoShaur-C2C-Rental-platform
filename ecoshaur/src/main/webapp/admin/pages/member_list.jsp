<!doctype html>
<html lang="en">
 
<head>
   <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Data Tables</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../../assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="../../assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="../../assets/libs/css/style.css">
    <link rel="stylesheet" href="../../assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <link rel="stylesheet" type="text/css" href="../../assets/vendor/datatables/css/dataTables.bootstrap4.css">
    <link rel="stylesheet" type="text/css" href="../../assets/vendor/datatables/css/buttons.bootstrap4.css">
    <link rel="stylesheet" type="text/css" href="../../assets/vendor/datatables/css/select.bootstrap4.css">
    <link rel="stylesheet" type="text/css" href="../../assets/vendor/datatables/css/fixedHeader.bootstrap4.css">
</head>
<%@ include file="header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
        <!-- ============================================================== -->
        <!-- end left sidebar -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- wrapper  -->
        <!-- ============================================================== -->
        <div class="dashboard-wrapper">
            <div class="container-fluid  dashboard-content">
                <!-- ============================================================== -->
                <!-- pageheader -->
                <!-- ============================================================== -->
                
                <div class="row">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="page-header">
                            <h2 class="pageheader-title">회원관리</h2>
                            <div class="page-breadcrumb">
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item active" aria-current="page">회원관리</li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- end pageheader -->
                <!-- ============================================================== -->
                
                <div class="row">
                    <!-- ============================================================== -->
                    <!-- basic table  -->
                    <!-- ============================================================== -->
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card">
                            <h5 class="card-header">회원관리</h5>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered first">
                                        <thead>
                                            <tr>
                                              <th>프로필</th>
	                                          <th>id</th>
	                                          <th>pw</th>
	                                          <th>이름</th>
	                                          <th>생년월일</th>
	                                          <th>연락처</th>
	                                          <th>이메일</th>
	                                          <th>우편번호</th>
	                                          <th>주소</th>
	                                          <th>상세주소</th>
	                                          <th>등급</th>
	                                          <th>가입한날짜</th>
	                                          <th>최근 로그인</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        
                                      <c:forEach var="dto" items="${list}">
                                      <form name="rentalfrm" method="post" action="member_list.do" enctype="multipart/form-data">
                                      <tr>
                                              <td><div class="m-r-10"><img src="../../member/storage/${dto.pro_name}" alt="user" class="rounded" width="45"></div></td>
                                              <td><a href="member_manager.do?id=${dto.id}">${dto.id}</a></td>
                                              <td>${dto.pw}</td>
                                              <td>${dto.mem_name}</td>
                                              <td>${dto.birth}</td>
                                              <td>${dto.contact_number}</td>
                                              <td>${dto.email}</td>
                                              <td>${dto.zip}</td>
                                              <td>${dto.address}</td>
                                              <td>${dto.address_r}</td>
                                              <td>
                                              	<c:choose>
                                              		<c:when test="${dto.grade eq 'M'}">관리자<span style="display:none">master</span>  </c:when>
                                              		<c:when test="${dto.grade eq 'P'}">프리미엄<span style="display:none">premium</span>  </c:when>
                                              		<c:when test="${dto.grade eq 'S'}">슈퍼등급<span style="display:none">super</span>  </c:when>
                                              		<c:when test="${dto.grade eq 'U'}">일반유저<span style="display:none">user</span>  </c:when>
                                              		<c:when test="${dto.grade eq 'D'}">휴먼계정<span style="display:none">human Dormant</span> </c:when>
                                              		<c:when test="${dto.grade eq 'W'}">탈퇴계정<span style="display:none">del Withdrawal</span>  </c:when>
		    		  							</c:choose>
                                              </td>
                                              <td>${dto.joined_date}</td>
                                              <td>${dto.lastdate}</td>
                                          </tr>
                                      </c:forEach>
                                      

                                        </tbody>
                                        <tfoot>
                                            <tr>
                                              <th>프로필</th>
	                                          <th>id</th>
	                                          <th>pw</th>
	                                          <th>이름</th>
	                                          <th>생년월일</th>
	                                          <th>연락처</th>
	                                          <th>이메일</th>
	                                          <th>우편번호</th>
	                                          <th>주소</th>
	                                          <th>상세주소</th>
	                                          <th>등급</th>
	                                          <th>가입한날짜</th>
	                                          <th>최근 로그인</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- ============================================================== -->
                    <!-- end basic table  -->
                    <!-- ============================================================== -->
                </div>               
                </div>
            </div>
            

            
            
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- end main wrapper -->
    <!-- ============================================================== -->
    <!-- Optional JavaScript -->
    <script src="../../assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <script src="../../assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="../../assets/vendor/slimscroll/jquery.slimscroll.js"></script>
    <script src="../../assets/vendor/multi-select/js/jquery.multi-select.js"></script>
    <script src="../../assets/libs/js/main-js.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script src="../../assets/vendor/datatables/js/dataTables.bootstrap4.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script>
    <script src="../../assets/vendor/datatables/js/buttons.bootstrap4.min.js"></script>
    <script src="../../assets/vendor/datatables/js/data-table.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.print.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.colVis.min.js"></script>
    <script src="https://cdn.datatables.net/rowgroup/1.0.4/js/dataTables.rowGroup.min.js"></script>
    <script src="https://cdn.datatables.net/select/1.2.7/js/dataTables.select.min.js"></script>
    <script src="https://cdn.datatables.net/fixedheader/3.1.5/js/dataTables.fixedHeader.min.js"></script>
    
</body>
 
</html>
