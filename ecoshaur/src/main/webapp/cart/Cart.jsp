<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<c:choose>
	<c:when  test="${(grade eq 'U') || (grade eq 'S') || (grade eq 'P') || (grade eq 'M')}">

<link href="assets/css/cart_payment.css" rel="stylesheet" type="text/css">
<script src="../assets/js/cart_payment.js"></script>

<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800&display=swap" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

	<div class="cart-wrap">
	<div class="container">
	<div class="row">
	    <div class="col-lg-12">
	        <div class="main-heading">장바구니</div>
	        <div class="table-cart"   id="cartlist">
            <table>
                <thead>
                    <tr>
                      <th>Product</th>
                      <th>Quantity</th>
                      <th>Total</th>
                      <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="dto" items="${rental_list}" varStatus="status">
                   <tr>
                       <td>
                       	<div class="display-flex align-center">
                            <div class="img-product">
                                <img src="category/storage/${dto.thmb_name}"alt="" width=100 class="mCS_img_loaded">
                            </div>
                            <div class="name-product">
                                ${dto.title}
                                <br>${category_code}
                            </div>
                            <div class="price"><small>
                                	일일 대여료 : ${dto.price_daily}<br>
                                	보증금 : ${dto.deposit}</small>
                            </div>
                           </div>
                       </td>
                       <td class="product-count" ><small>
                         	수량 : ${cart_list[status.index].quantity}개<br>
                         	대여기간 : ${cart_list[status.index].rental_period }일<br>
                         	수령일 : ${cart_list[status.index].receipt_date }</small>
                       </td>
                       <td>
                           <div class="total">
                               ${cart_list[status.index].total_price} 원
                           </div>
                       </td>
                       <td>
                           <input type="button" id="delete" class="btn btn-danger" value="X">
                           <input id="no" type="hidden" value="${cart_list[status.index].cart_no}">
                       </td>
                   </tr>
                  </c:forEach> 
                  <tr>
                  		<td colspan="2"></td>
                  		<td colspan="1"><div class="total">
                              	총 ${price} 원
                           </div>
                        </td>
                        <td/>
                  </tr>
                 </tbody>
             </table>
                  
                  <nav class="nav justify-content-center" aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item">
		    <c:choose><c:when test="${(nowpage-1)==0}"> <a class="page-link disabled">  </c:when>
		    		  <c:otherwise> <a class="page-link" href="Cart.do?id=Buyer&nowpage=${nowpage-1 }"> </c:otherwise>
		    </c:choose>
		    Previous</a></li>
		    
		    <c:forEach var="i" begin="1" end="${count%recordPerPage==0 ? (count/recordPerPage) : (count/recordPerPage)+1}">
		    	<li class="page-item ${nowpage==i ? 'active' : ''}"><a class="page-link" href="Cart.do?id=Buyer&nowpage=${i}"><c:out value="${i}"/></a></li>
		    </c:forEach>
		    
		    <li class="page-item">
		    <c:choose><c:when test="${nowpage == i}"> <a class="page-link disabled">  </c:when>
		    		  <c:otherwise> <a class="page-link" href="Cart.do?id=Buyer&nowpage=${nowpage+1 }"> </c:otherwise>
		    </c:choose>
		    Next</a></li>
		  </ul>
		</nav>
                  
                   
	        </div>
	        <!-- /.table-cart -->
	        <a href="./Category.do?nowpage=1" class="btn btn-primary">쇼핑 계속하기</a>
  <a href="Cartpayment.do?id=${id}&nowpage=1" class="btn btn-info">결제</a>
	    </div>
<script>
	//1)X 버튼을 클릭했을때
	$("#delete").click(function(){
		var params="no=" + $("#no").val();
		$.post("CartDel.do", params, check, "json");
		
	});//click() end
	
	//4)콜백함수 작성
	function check(result){	
		location.reload();
	}//checkID() end
</script>
<!-- 본문끝 -->
	

		
	</c:when>
	<c:otherwise>
	<script>window.location.href = './';</script>
</c:otherwise>
</c:choose>

<%@ include file="../footer.jsp"%>
