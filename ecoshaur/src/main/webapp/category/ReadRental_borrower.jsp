<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!--  %@ include file="/admin/sub_menu.jsp"%> -->

<style>
 p {
    font-family: "Nanum Gothic", sans-serif;
    font-size: 30px;
    font-weight: 800;
   }
</style>

<html>
<body>
<div class="container">
<article>
<h1>상품 상세 보기</h1> 
<form name="frm" method="post">
<table border="1" id="list">
  <tr>
    <th>상품 분류</th>
    <td  colspan="5">
  		${kind}
     </td>    
    </tr>    
    <tr>
     <td colspan="5" text-align="center">
  <!--[7] 상품 이미지를 출력하기 -->     
     <img src="rental_thumbimages/${RentalDTO.thumb_image}" width="200pt">    
     </td>
    </tr>
    <th>제목</th>
  <td width="343" colspan="5">
       <input type="text" name="name" size="47" maxlength="100" value="">
  </td>
</tr>
<tr>
  <th>소제목</th>
  <td width="343" colspan="5">
       <input type="text" name="name" size="47" maxlength="100" value="">
  </td>
</tr><tr>
  <th>상품명</th>
  <td width="343" colspan="5">
       <input type="text" name="name" size="47" maxlength="100" value="">
  </td>
</tr>
 <tr>
  <th>평가 - 좋아요 싫어요 게이지</th>
  </tr>
<tr>
  <th>하루 대여료</th>
  <td width="70">
  					<!-- onBlur == 내용을 바꾸지 않더라도 포커스를 잃으면 바로 이벤트 발생 -->
     <input type="text" name="price" size="11" onBlur="" onKeyUp='NumFormat(this)' value="">
  </td>
</tr>
	<tr>
		<th>수령일</th>
	  <td width="70">
	  <input type="date" value="xxx" min="yyy" max="zzz">
	  <th>대여일수</th>
	  <td width="70">
	     <select name="period">
		    <option value="">기간</option>
		    <option value="1">1일</option>
		    <option value="2">2일</option>
		    <option value="3">3일</option>
		    <option value="4">4일</option>
		    <option value="5">5일</option>
		    <option value="6">6일</option>
		    <option value="7">7일</option>
		    <option value="8">8일</option>
		    <option value="9">9일</option>
		    <option value="10">10일</option>
		    <option value="11">11일</option>
		   	<option value="12">12일</option>	    
</select>
	     <p>장기 대여는 따로 문의해주세요~:D</p>
	  </td>

  </tr>
  
  <tr>
  	<th>제공자: </th>
  	
  </tr>


 
    <tr>
     <th>대여물품 이미지</th>
     <td colspan="5" align="center">
  <!--[7] 상품 이미지를 출력하기 -->     
     <img src="rental_images/${RentalDTO.image}" width="200pt">    
     </td>
    </tr>
    
    <tr>
        <th>상세설명</th>
        <td colspan="15" >${RentalDTO.description}</td>
    </tr>
     
</table>  
<input class="btn"  type="button" value="구매하기" onClick="go_buy('${tpage}','${RentalDTO.pseq}')">
<input class="btn"  type="button" value="장바구니" onClick="go_cart('${tpage}','${RentalDTO.pseq}')">  
<!--[9] 목록 버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다. --> 
<input class="btn"  type="button" value="목록" onClick="go_list('${tpage}')">          
</form>
</article>

</div>
</body>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<%@ include file="../footer.jsp"%>
</html>