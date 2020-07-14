<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>

<link href="assets/libs/css/cart_payment.css" rel="stylesheet" type="text/css">
<script src="../assets/libs/js/cart_payment.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800&display=swap" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<div class="cart-wrap">
   <div class="container">
      <div class="row">
         <div class="col-lg-12">
            <div class="main-heading">Shopping Cart</div>
            <div class="table-cart">
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
                                    <img src="category/storage/${dto.thmb_name}" alt="" class="mCS_img_loaded">
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

                        </tr>
                     </c:forEach>
                  </tbody>
               </table>
               
               
                  <nav class="nav justify-content-center" aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item">
		    <c:choose><c:when test="${(nowpage-1)==0}"> <a class="page-link disabled">  </c:when>
		    		  <c:otherwise> <a class="page-link" href="Cartpayment.do?id=${id }&nowpage=${nowpage-1 }"> </c:otherwise>
		    </c:choose>
		    Previous</a></li>
		    
		    <c:forEach var="i" begin="1" end="${count%recordPerPage==0 ? (count/recordPerPage) : (count/recordPerPage)+1}">
		    	<li class="page-item ${nowpage==i ? 'active' : ''}"><a class="page-link" href="Cartpayment.do?${id }&nowpage=${i}"><c:out value="${i}"/></a></li>
		    </c:forEach>
		    
		    <li class="page-item">
		    <c:choose><c:when test="${nowpage == i}"> <a class="page-link disabled">  </c:when>
		    		  <c:otherwise> <a class="page-link" href="Cartpayment.do?${id }&nowpage=${nowpage+1 }"> </c:otherwise>
		    </c:choose>
		    Next</a></li>
		  </ul>
		</nav>
               
            </div>
            <!-- /.table-cart -->
         </div>
         <!-- /.col-lg-8 -->
         <div class="col-lg-9">
            <form action="Cartpayment.do" method="post" accept-charset="utf-8">
            	<input type="hidden" id="point" name="point" value="0">
            	<input type="hidden" id="cid" name="cid" value="${id}">
               <div class="panel panel-default">
                  <div class="panel-body form-horizontal payment-form">
                     <div class="form-group">
                     	<label for="concept" class="col-sm-2 control-label" style="color:red">보유 point : ${point }
                     	</label>
                     	<label for="concept" class="col-sm-3 control-label" style="color:red">(최대 3000 point)
                     	</label>
                     </div>
                     <div class="form-group">
                        <label for="concept" class="col-sm-2 control-label">사용한 point</label>
                        <div class="col-sm-10">
                           <input class="form-control" id="use_point" type="number" name="use_point" size="4" onkeyup="Point()" min="0" max="3000">
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="concept" class="col-sm-2 control-label">결제방법</label>
                        <div class="col-sm-10">
                           <select class="form-control" id="payment" name="payment" style="height:auto">
                              <option>신용카드</option>
                              <option>체크카드</option>
                           </select>
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="description" class="col-sm-2 control-label">결제카드 종류</label>
                        <div class="col-sm-10">
                           <select class="form-control" id="credit_card" name="credit_card" style="height:auto">
                              <option>VISA</option>
                              <option>Mastercard</option>
                              <option>AMEX</option>
                              <option>UnionPay</option>
                           </select>
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="amount" class="col-sm-2 control-label">결제카드 번호</label>
                        <div class="col-sm-10">
                           <input type="text" class="form-control" id="card_num" name="card_num" placeholder="0000-0000-0000-0000 형식으로 써주세요">
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="status" class="col-sm-2 control-label">배송주소</label>
                        <div class="col-sm-10">
                           <div class="input-group">
                              <input type="text" class="form-control input-group-addon" id="address" name="address" readonly>
                              <div class="input-group-btn">
                                 <input class="btn btn-default" type="button" value="주소찾기" onclick="DaumPostcode();">
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="date" class="col-sm-2 control-label">상세 주소</label>
                        <div class="col-sm-10">
                           <input type="text" class="form-control" id="address_R" name="address_R">
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="description" class="col-sm-2 control-label">배송방법</label>
                        <div class="col-sm-10">
                           <select class="form-control" id="delivery_method" name="delivery_method" style="height:auto">
                              <option>직거래</option>
                              <option>우체국</option>
                              <option>대한통운</option>
                              <option>로젠택배</option>
                              <option>현대택배</option>
                              <option>한진택배</option>
                           </select>
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="date" class="col-sm-2 control-label">받는사람</label>
                        <div class="col-sm-10">
                           <input type="text" class="form-control" id="recipient" name="recipient">
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="date" class="col-sm-2 control-label">연락처</label>
                        <div class="col-sm-10">
                           <input type="text" class="form-control" id="tel" name="tel">
                        </div>
                     </div>
                   </div>
               </div>
         </div>
         <div class="col-lg-3">
         <div class="cart-totals">
         <h3>Cart Totals</h3>
         <table>
         <tbody>
         <tr>
         <td>금액</td>
         <td class="subtotal"><span id="o">${total_price}</span></td>
         </tr>
         <tr>
         <td>사용한 point</td>
         <td class="free-shipping" id="h"></td>
         </tr>
         <tr class="total-row">
         <td>총 금액</td>
         <td class="price-total"><span id="r">${total_price}</span></td>
         </tr>
         </tbody>
         </table>
         <div class="btn-cart-totals">
         <input type="reset" value="초기화">
         <input type="submit" value="결제">
         </div>
         <!-- /.btn-cart-totals -->
         </form>
         <!-- /form -->
         </div>
         <!-- /.cart-totals -->
         </div>
         <!-- /.col-lg-4 -->
      </div>
   </div>
</div>
<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
   <img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
</div>
<script>
   // 우편번호 찾기 화면을 넣을 element
   var element_layer = document.getElementById('layer');
   
   function closeDaumPostcode() {
       // iframe을 넣은 element를 안보이게 한다.
       element_layer.style.display = 'none';
   }
   
   function DaumPostcode() {
       new daum.Postcode({
           oncomplete: function(data) {
   
   
               // 우편번호와 주소 정보를 해당 필드에 넣는다.
               document.getElementById("address").value = data.address;
               // 커서를 상세주소 필드로 이동한다.
               document.getElementById('address_r').focus();
   
               // iframe을 넣은 element를 안보이게 한다.
               // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
               element_layer.style.display = 'none';
           },
           width : '100%',
           height : '100%',
           maxSuggestItems : 5
       }).embed(element_layer);
   
       // iframe을 넣은 element를 보이게 한다.
       element_layer.style.display = 'block';
   
       // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
       initLayerPosition();
   }
   
   // 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
   // resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
   // 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
   function initLayerPosition(){
       var width = 500; //우편번호서비스가 들어갈 element의 width
       var height = 500; //우편번호서비스가 들어갈 element의 height
       var borderWidth = 1; //샘플에서 사용하는 border의 두께
   
       // 위에서 선언한 값들을 실제 element에 넣는다.
       element_layer.style.width = width + 'px';
       element_layer.style.height = height + 'px';
       element_layer.style.border = borderWidth + 'px solid';
       // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
       element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width+900)/2 - borderWidth) + 'px';
       element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
   }
   
   function Point() {

	      var use_point =document.getElementById('use_point').value;

	      if (use_point < 0)
	    	  use_point = '0';
		  if(use_point >= 3000) 
		  {
			  use_point = "3000"
			var num_use_point = parseFloat(use_point);
			document.getElementById("h").innerHTML   = num_use_point 
		  }
		  if(use_point > ${point}) 
		  {
			document.getElementById("use_point").value   = ${point}
			use_point = ${point}
			var num_use_point = parseFloat(use_point);
			document.getElementById("h").innerHTML   = num_use_point 
		  }
		  
		  
			var num_use_point = parseFloat(use_point);
			document.getElementById("h").innerHTML   = num_use_point 
		  
		  var htStr =document.getElementById('o').innerHTML;

	      if (!htStr)
	        htStr = '0';
			
		  var num_use_point = parseFloat(use_point);
	      var height = parseFloat(htStr);
	      document.getElementById("r").innerHTML =  height - num_use_point;
	      
	      if(isNaN(document.getElementById("h").innerHTML)){
	    	  document.getElementById("h").innerHTML = 0;
	      }
	      if(isNaN(document.getElementById("r").innerHTML)){
	    	  document.getElementById("r").innerHTML = document.getElementById("o").innerHTML;
	      }
	      document.getElementById("point").value =  document.getElementById('use_point').value;
	    }
   
</script>


<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>