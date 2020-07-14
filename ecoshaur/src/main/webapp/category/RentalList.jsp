<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<!--   %@ include file="/admin/sub_menu.jsp"%>-->

<article>
<h1>상품등록</h1>  
<!-- [1] 파일을 업로드 하기 위해서는 폼태그를 post 방식으로 전송하고,
인코딩 타입을 multipart/form-data 로 지정해야 한다. -->
<form name="frm" method="post" enctype="multipart/form-data">
<table id="list">
<tr>
  <th>상품분류</th>
  <td colspan="5">
  <select name="kind">
    <c:forEach items="${kindList}" var="kind" varStatus="status">
      <option value="${status.count}">${kind}</option>
   </c:forEach>
  </select>      
<tr>
  <th>제목</th>
  <td width="343" colspan="5">
       <input type="text" name="name" size="47" maxlength="100" value="">
  </td>
</tr><tr>
  <th>소제목</th>
  <td width="343" colspan="5">
       <input type="text" name="name" size="47" maxlength="100" value="">
  </td>
  <th>평가 - 좋아요 싫어요 게이지</th>
  </td>
</tr>
<tr>
  <th>하루 대여료</th>
  <td width="70">
  					<!-- onBlur == 내용을 바꾸지 않더라도 포커스를 잃으면 바로 이벤트 발생 -->
     <input type="text" name="price" size="11" onBlur="" onKeyUp='NumFormat(this)' value="">
  </td>
  <th>대여 기간</th>
  <td width="70">
     <input type="text" name="price2" size="11" onBlur="" onKeyUp='NumFormat(this)' value="">
  </td>
  </tr>
  
  <tr>
  	<th>아이디: </th>
  	
  
  </tr>
    
  <tr>
    <th>상세설명</th>
    <td colspan="5">
      <textarea name="content" rows="8" cols="70" ></textarea>
    </td>
  </tr>
  <tr>
    <th>썸네일 이미지</th>
    <td width="343" colspan="5">
<!--  [2] 파일 업로드를 하기 위한 input 태그는 타입 속성 값을 file로 지정해야 한다.  -->
      <input type="file" name="thumb_image">
    </td>
  </tr> 
  <tr>
    <th>대여물품 이미지</th>
    <td width="450" colspan="5">
<!--  [2] 파일 업로드를 하기 위한 input 태그는 타입 속성 값을 file로 지정해야 한다.  -->
      <input type="file" name="image">
    </td>
  </tr>    
  
</table>
<input class="btn" type="button" value="등록" onClick="">           
<input class="btn" type="button" value="취소" onClick="">
</form> 
</article>
<%@ include file="/footer.jsp"%>
</body>
</html>