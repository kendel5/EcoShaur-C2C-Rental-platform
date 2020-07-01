<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<br><br><br><br><br><br><br><br>

<h3>장바구니</h3>
<table border="1" align="center">
<c:forEach var="dto" items="${list}">

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
  
  <input type="button"  value="쇼핑계속하기" onclick="location.href='./'">
      	<input type="button" value="결제" onclick="location.href='./Cartpayment.do?id=${id}'">
<!-- 본문끝 -->

<%@ include file="../e_footer.jsp"%>
