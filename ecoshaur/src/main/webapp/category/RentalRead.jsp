
<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>
<link rel="stylesheet"
   href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery.min.js"></script>
 <script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<link  href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
<link href="assets/libs/css/category.css" rel="stylesheet" type="text/css">

<style>
p {
   font-family: "Nanum Gothic", sans-serif;
   font-size: 30px;
   font-weight: 800;
}
</style>

<br>

<div class="container">
   <div class="row mt-4">
      <div class="col-lg-4 text-center border-right border-secondery">
         <div
            class="tab-content row h-100 d-flex justify-content-center align-items-center"
            id="myTabContent">
            <div class="tab-pane fade show active col-lg-12" id="home"
               role="tabpanel" aria-labelledby="home-tab">
               <img class="img-fluid"
                  src="category/storage/${dto.thmb_name}" />
            </div>
         </div>
      </div>
      <div class="col-lg-7">
         <h5>${dto.title}</h5>
         <h5>${dto.sub_title}</h5>
         <h5>${dto.product_name}</h5>
         <div class="progress">
            <c:choose>
               <c:when test="${good+bad != 0}">
                  <div class="progress-bar bg-success" role="progressbar"
                     style="width:${good}%">좋아요 (${good}%)</div>
                  <div class="progress-bar bg-danger" role="progressbar"
                     style="width:${bad}%">싫어요 (${bad}%)</div>
               </c:when>
               <c:otherwise>
                  <div class="progress-bar" role="progressbar" style="width: 100%">
                     평가없음</div>
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
                  <th><h2><span id="days"></span></h2></th>
               </tr>
               
               <tr>
               <th>대여 기간</th>
                  <td></td>
                  <td></td>                 
               </tr>
               
              <form action="Cart.do" method="post">
               <input type="hidden" value="${id }" id="id" name="id">
               <input type="hidden" value="1" id="nowpage" name="nowpage">
               <input type="hidden" value="${dto.product_no }" id="product_no" name="product_no">
               <input type="hidden" value="" id="RENTAL_PERIOD" name="rental_period">
               <input type="hidden" value="${dto.price_daily}" id="price_daily" name="price_daily">
               <input type="hidden" value="${dto.deposit}" id="deposit" name="deposit">
               <tr>
                  <th>수량</th>
                  <td></td>
                  <th><input type="number" name="quantity" id="quantity"></th>
               </tr>
               <tr>
                  <th>대여 : <input type="date" name="receipt_date" id="receipt_date" onchange="call()"></th>
                  <td></td>
                  <th>반납 : <input type="date" name="regDate2" id="regDate2" onchange="call()"></th>
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
            <td colspan="2"><input type="submit" value="장바구니추가"></td>
         </tr>
         <tr>
         <td colspan="4" align="center"><img class="img-fluid"
                  src="category/storage/${dto.image_name}" /></td>
         </tr>
         <tr>
         <td colspan="4" align="center">${dto.description }</td>
         </tr>
      </table>
   </div>
</div>

 </form>
 
     <script>
         function call() {
            var sdd = document.getElementById("receipt_date").value;
            var edd = document.getElementById("regDate2").value;
            var ar1 = sdd.split('-');
            var ar2 = edd.split('-');
            var da1 = new Date(ar1[0], ar1[1], ar1[2]);
            var da2 = new Date(ar2[0], ar2[1], ar2[2]);
            var dif = da2 - da1;
            var cDay = 24 * 60 * 60 * 1000;// 시 * 분 * 초 * 밀리세컨
            if (sdd && edd) {
               document.getElementById('days').innerHTML = parseInt(dif / cDay) + "일"
               document.getElementById('RENTAL_PERIOD').value = parseInt(dif / cDay)
            }
         }
      </script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<a href="rental_update.do?product_no=${dto.product_no}" class="btn btn-warning">수정하기</a>
<a href="rental_delete.do?product_no=${dto.product_no}" class="btn btn-danger">삭제하기</a>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>