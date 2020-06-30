<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
<link href="css/category.css" rel="stylesheet" type="text/css">
<style>
 p {
    font-family: "Nanum Gothic", sans-serif;
    font-size: 30px;
    font-weight: 800;
   }
</style>

<br><br><br><br><br><br><br><br><br><br><br><br>

<div class="container">
    <div class="row mt-4">
        <div class="col-lg-4 text-center border-right border-secondery">
            <div class="tab-content row h-100 d-flex justify-content-center align-items-center" id="myTabContent">
                <div class="tab-pane fade show active col-lg-12" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <img class="img-fluid" src="https://pbs.twimg.com/media/ENktSOKU0AA9Y-6.jpg" />
                </div>
            </div>
        </div>
        <div class="col-lg-7">
            <h5>
                	${dto.title}
            </h5>
            <h5>
                	${dto.sub_title}
            </h5>
            <h5>
                	${dto.product_name}
            </h5>
            <div class="progress">
            <c:choose>
            	<c:when test="${good+bad != 0}">
	 				<div class="progress-bar bg-success" role="progressbar" style="width:${good}%">
					  좋아요 (${good}%)
					</div>
				  	<div class="progress-bar bg-danger" role="progressbar" style="width:${bad}%">
				  	  싫어요 (${bad}%)
				  	</div>
			  	</c:when>
				<c:otherwise>
					<div class="progress-bar" role="progressbar" style="width:100%">
						평가없음
					</div>
				</c:otherwise>
			</c:choose>
            </div>
            <table class="table">
				<tbody>
				<tr>
					<th>일일가격 : ${dto.price_daily}</th>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>보증금 : ${dto.deposit}</th>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>기간</th>
					<td>2주 이상은 문의</td>
					<td><input type="number" id="num" onkeyup="after_date()" class="form-control"></td>
				</tr>
				<tr>
					<th>대여</th>
					<td></td>
					<th>반납</th>
				</tr>
				<tr>
					<th><h3 id="clock"></h3></th>
					<td></td>
					<th><h3 id="after"></h3></th>
				</tr>
				</tbody>
			</table>         
        </div>
		<table class="table">
			<tr>
				<th width="10%">제공자</th>
				<td width="50%">${dto.id}</td>
				<td width="20%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<th>상품명</th>
				<td>${code}</td>
				<td>
					<a href="payment.do" class="btn btn-success">구매하기</a>
				</td>
				<td>
					<a href="cart.do?id=아이디" class="btn btn-warning">장바구니</a>
				</td>
			</tr>
		</table>
    </div>
</div>
<script>
window.onload = function before_date(){
	 var today = new Date();
	 var str = "";

	 str +=today.getUTCFullYear() +"-";

	 if(today.getMonth()+1<10){
		 str +="0";
	 }
		 str +=(today.getMonth()+1) +"-";

	 if(today.getDate()<10) {
    	str +="0";
    }
        str +=(today.getDate());
	document.getElementById('clock').innerHTML = str;
}

function after_date(){
	var num = document.getElementById('num').value;
	
	var tDate = new Date();
	var str=""; 
	// 날짜(일) 더하기
	tDate.setDate(tDate.getDate()+num);
	
	str += tDate.getFullYear() + "-" + tDate.getMonth() + "-" + (tDate.getDate());

	document.getElementById('after').innerHTML = str;
}
</script>
<br><br><br><br><br><br><br><br><br><br><br><br><br>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- 본문 끝 -->		
<%@ include file="../e_footer.jsp" %>
