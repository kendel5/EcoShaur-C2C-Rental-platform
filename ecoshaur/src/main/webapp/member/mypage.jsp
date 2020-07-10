<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
<link href="./css/mypage.css" rel="stylesheet" type="text/css">

<style>
   
input.hidden {
    position: absolute;
    left: -9999px;
}

#profile-image1 {
    cursor: pointer;
  
     width: 100px;
    height: 100px;
	border:2px solid #03b1ce ;}
	.tital{ font-size:16px; font-weight:500;}
	 .bot-border{ border-bottom:1px #f8f8f8 solid;  margin:5px 0  5px 0}	
</style>

<!-- 본문 시작 template.jsp-->
<br><br><br><br><br><br><br><br><br>

<div class="container emp-profile">
            <form method="post">
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog" alt=""/>
                            <div class="file btn btn-lg btn-primary">
                                Change Photo
                                <input type="file" name="file"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                                    <h5>
                                        ${mymem.mem_name }
                                    </h5>
                                    <h6>
                                        ${grade }
                                    </h6>
                                    <p class="proile-rating">RANKINGS : <span>8/10</span></p>
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">회원정보</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">활동내역</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <input type="submit" class="profile-edit-btn" name="btnAddMore" value="프로필 편집"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-work">
                            <p>프로필 소개</p>
                            
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>아이디 </label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${id }</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>연락처</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${mymem.contact_number }</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>이메일</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${mymem.email }</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>우편번호</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${mymem.zip }</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>주소</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${mymem.address }</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>나머지주소</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${mymem.address_r }</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>가입일</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${mymem.joined_date }</p>
                                            </div>
                                        </div>
                                         <div class="row">
                                            <div class="col-md-6">
                                                <label>최종로그인</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${mymem.lastdate }</p>
                                            </div>
                                        </div>
                            </div>
                            
                            
                            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">

                            	<table class="table">
                            		<thead class="thead-light">
      									<tr>
        								<th>상품게시번호</th>
        								<th>상품명</th>
        								<th>상품등록일</th>
        								<th>제목</th>
      									</tr>
    								</thead>  
    							
    								<tbody>
    								<c:forEach var="dto" items="${mypage}">
      									<tr>
	        								<td>${dto.product_no }</td>
	        								<td>${dto.product_name }</td>
	        								<td>${dto.reg_date }</td>
	        								<td>${dto.title }</td>
      									</tr>  
      								</c:forEach>        
									</tbody>
										
								</table>
					
					
					</div>
					</div>
					</div>
					</div>
					
					
					</form>		
					
					</div>
					<a href="ModifyForm.do?id=${id }" >수정</a>
					<a href="delete.do" class="btn btn-danger">탈퇴</a>
					<a class="btn btn-primary" href="logout.do">로그아웃</a>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

   

<!-- 본문 끝 -->		
<%@ include file="../e_footer.jsp" %>