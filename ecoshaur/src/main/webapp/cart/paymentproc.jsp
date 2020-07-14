<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<h3>장바구니결제페이지</h3>
<h3>장바구니</h3>
<table border="1" align="center">
<c:forEach var="dto" items="${cart_list}">

    <tr>
      <td>${dto.product_no}</td>
      
      <td>${dto.title}</td>
      
      <td>${dto.sub_title}</td>
      
      <td>${dto.description}</td>
      
      <td>${dto.price_daily}</td>
       
      <td>${dto.deposit}</td>
       
      <td>${dto.total_quantity}</td>
      
      <td>${dto.remaining_quantity}</td>
      
      <td>${dto.thmb_name}</td>
      
      <td>${dto.thmb_size}</td>
      
      <td>${dto.image_name}</td>
      
      <td>${dto.image_size}</td>
      
      <td>${dto.reg_date}</td>
      
      <td>${dto.id}</td>
      
      <td>${dto.category_code}</td>
      
      	
      
      
    </tr>
  </c:forEach>
  </table>
  
  
  
  <h3>상품목록</h3>
<table border="1" align="center">
<c:forEach var="dto" items="${rental_list}">

    <tr>
      <td>${dto.cart_no}</td>
      <td><a href="../ecoshaur/list.do?Cartno=${dto.cart_no}">${dto.product_no}</a></td>
      
      <td>
      <td>${dto.id}</td>
      
      <td>${dto.quantity}</td>
      
      <td>${dto.rental_period}</td>
      
      <td>${dto.receipt_date}</td>
       
      <td>${dto.cart_date}</td>
       
      <td>${dto.total_price}</td>
      
      	
      
      
    </tr>
  </c:forEach>
  </table>
  
  
  
  <h3>포인트</h3>
<table border="1" align="center">


    <tr>

      <td>${point}</td>
      
      
      	
      
      
    </tr>

  </table>
  <form method="post" action=""> 
  <input type="number" name="total_price" min="100" max="5000000" >
  <input type="button"  value="취소" onclick="location.href='index.do'">
      	<input type="button" value="결제" onclick="location.href='./Cartpayment.do?">
      	</form>
<!-- 본문끝 -->

<%@ include file="../footer.jsp"%>
