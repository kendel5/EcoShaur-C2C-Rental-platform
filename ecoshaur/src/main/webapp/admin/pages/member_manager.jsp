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
                        <!-- ============================================================== -->
                        <!-- valifation types -->
                        <!-- ============================================================== -->
                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                            <div class="card">
                                <h5 class="card-header">회원 수정</h5>
                                <div class="card-body">
                                    <form method="post" action="member_manager.do" enctype="multipart/form-data" data-parsley-validate="" novalidate="">
                                        <input type="hidden" value="${mymem.pro_name}" name="old_pro_name" id="old_pro_name">
                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-form-label text-sm-right">프로필 이미지</label>
                                            <div class="col-12 col-sm-8 col-lg-6">
                                                <input type="file" class="form-control" name="pro_name1" id="pro_name1" size="15" required>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-form-label text-sm-right">아이디</label>
                                            <div class="col-12 col-sm-8 col-lg-6">
                                                <input type="text" class="form-control" name="id" id="id" size="15" value="${mymem.id}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-form-label text-sm-right">비밀번호</label>
                                            <div class="col-12 col-sm-8 col-lg-6">
                                                <input type="text" class="form-control" name="pw" id="pw" size="15" value="${mymem.pw }">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-form-label text-sm-right">이름</label>
                                            <div class="col-12 col-sm-8 col-lg-6">
                                                <input type="text" class="form-control" name="mem_name" id="mem_name" size="15" value="${mymem.mem_name }">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-form-label text-sm-right">생년월일</label>
                                            <div class="col-12 col-sm-8 col-lg-6">
                                                <input type="date" id="birth" name="birth" value="${mymem.birth }">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-form-label text-sm-right">이메일</label>
                                            <div class="col-12 col-sm-8 col-lg-6">
                                                <input type="text" class="form-control" name="email" id="email" size="15" value="${mymem.email}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-form-label text-sm-right">연락처</label>
                                            <div class="col-12 col-sm-8 col-lg-6">
                                                <input type="text" class="form-control" name="contact_number" id="contact_number" size="15" value="${mymem.contact_number }">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-form-label text-sm-right">우편번호</label>
                                            <div class="col-12 col-sm-8 col-lg-6">
                                                <input type="email" class="form-control" name="zip" id="zip" size='7' value="${mymem.zip }">
						                        <div class="input-group-btn">
						                     		<input type="button" value="우편번호찾기" class="btn btn-default" onclick="DaumPostcode()">
						                    	</div>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-form-label text-sm-right">주소</label>
                                            <div class="col-12 col-sm-8 col-lg-6">
                                                <input type="text" class="form-control" name="address" id="address" size='45' value="${mymem.address }">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-3 col-form-label text-sm-right">나머지 주소</label>
                                            <div class="col-12 col-sm-8 col-lg-6">
                                                <input type="text" class="form-control" name="address_r" id="address_r" size='45' value="${mymem.address_r }">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-3 col-form-label text-sm-right">등급</label>
                                            <div class="col-12 col-sm-8 col-lg-6">
                                                <label class="custom-control custom-radio custom-control-inline">
                                                	<c:choose>
                                                		<c:when test="${mymem.grade eq 'U'}">
                                                			<input type="radio"  name="grade" id="grade"  checked="" class="custom-control-input" value="U">
                                                		</c:when>
                                                		<c:otherwise>
                                                			<input type="radio"  name="grade" id="grade"  class="custom-control-input" value="U">
                                                		</c:otherwise>
                                                	</c:choose>
                                                	<span class="custom-control-label">U (일반 유저)</span>
	                                            </label>
	                                            <label class="custom-control custom-radio custom-control-inline">
	                                                <c:choose>
                                                		<c:when test="${mymem.grade eq 'S'}">
                                                			<input type="radio"  name="grade" id="grade"  checked="" class="custom-control-input" value="S">
                                                		</c:when>
                                                		<c:otherwise>
                                                			<input type="radio"  name="grade" id="grade"  class="custom-control-input" value="S">
                                                		</c:otherwise>
                                                	</c:choose>
                                                	<span class="custom-control-label">S (슈퍼 유저)</span>
	                                            </label>
	                                            <label class="custom-control custom-radio custom-control-inline">
	                                                <c:choose>
                                                		<c:when test="${mymem.grade eq 'P'}">
                                                			<input type="radio"  name="grade" id="grade"  checked="" class="custom-control-input" value="P">
                                                		</c:when>
                                                		<c:otherwise>
                                                			<input type="radio"  name="grade" id="grade"  class="custom-control-input" value="P">
                                                		</c:otherwise>
                                                	</c:choose>
                                                	<span class="custom-control-label">P (프리미엄 유저)</span>
	                                            </label>
	                                            <label class="custom-control custom-radio custom-control-inline">
	                                               <c:choose>
                                                		<c:when test="${mymem.grade eq 'D'}">
                                                			<input type="radio"  name="grade" id="grade"  checked="" class="custom-control-input" value="D">
                                                		</c:when>
                                                		<c:otherwise>
                                                			<input type="radio"  name="grade" id="grade"  class="custom-control-input" value="D">
                                                		</c:otherwise>
                                                	</c:choose>
                                                	<span class="custom-control-label">D (휴먼 유저)</span>
	                                            </label>
	                                            <label class="custom-control custom-radio custom-control-inline">
	                                               <c:choose>
                                                		<c:when test="${mymem.grade eq 'W'}">
                                                			<input type="radio"  name="grade" id="grade"  checked="" class="custom-control-input" value="W">
                                                		</c:when>
                                                		<c:otherwise>
                                                			<input type="radio"  name="grade" id="grade"  class="custom-control-input" value="W">
                                                		</c:otherwise>
                                                	</c:choose>
                                                	<span class="custom-control-label">W (탈퇴 유저)</span>
	                                            </label>
	                                            <label class="custom-control custom-radio custom-control-inline">
	                                                <c:choose>
                                                		<c:when test="${mymem.grade eq 'M'}">
                                                			<input type="radio"  name="grade" id="grade"  checked="" class="custom-control-input" value="M">
                                                		</c:when>
                                                		<c:otherwise>
                                                			<input type="radio"  name="grade" id="grade"  class="custom-control-input" value="M">
                                                		</c:otherwise>
                                                	</c:choose>
                                                	<span class="custom-control-label">M (마스터)</span>
	                                            </label>
	                                        </div>
                                        </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-form-label text-sm-right">계정 등록일</label>
                                            <div class="col-12 col-sm-8 col-lg-6">
                                                <input type="date" id="joined_date" name="joined_date" value="${mymem.joined_date }">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-form-label text-sm-right">마지막 접속일</label>
                                            <div class="col-12 col-sm-8 col-lg-6">
                                                <input type="date" id="lastdate" name="lastdate" value="${mymem.lastdate }">
                                            </div>
                                        </div>
                                        <div class="form-group row text-right">
                                            <div class="col col-sm-10 col-lg-9 offset-sm-1 offset-lg-0">
                                                <button type="submit" class="btn btn-space btn-primary">수정</button>
                                                <button class="btn btn-space btn-secondary">취소</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    
                    <!-- ============================================================== -->
                    <!-- end basic table  -->
                    <!-- ============================================================== -->
                </div>               
                </div>
            </div>
            
<!-- ----- DAUM 우편번호 API 시작 ----- -->
<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 110px;position:absolute;top:50%;left:50%;margin-left:-150px;margin-left:-250px;z-index:3;">
  <img src="//i1.daumcdn.net/localimg/localimages/07/postcode/320/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">

</div>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    // 우편번호 찾기 화면을 넣을 element
    var element_wrap = document.getElementById('wrap');

    function foldDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_wrap.style.display = 'none';
    }
    
    function DaumPostcode() {
        // 현재 scroll 위치를 저장해놓는다.
        var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
        new daum.Postcode({
        	
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = data.address; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 기본 주소가 도로명 타입일때 조합한다.
                if(data.addressType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('zip').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('address').value = fullAddr;

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_wrap.style.display = 'none';

                // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
                document.body.scrollTop = currentScroll;
                
                $('#address_r').focus();
            },
            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
            onresize : function(size) {
                element_wrap.style.height = size.height+'px';
            },
            width : '100%',
            height : '100%'
        }).embed(element_wrap);
      

        // iframe을 넣은 element를 보이게 한다.
        element_wrap.style.display = 'block';
    }
</script>
<!-- ----- DAUM 우편번호 API 종료----- -->
            
            
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
