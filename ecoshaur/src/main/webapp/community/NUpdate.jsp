<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 NUpdate.jsp-->
<body>
<div class="container">
	<H3>공지사항 수정하기</H3>
<br><br>	
  <form method="post"
        action="NUpdate.do"
        enctype="multipart/form-data" >  
    <input type='hidden' name='postno' value='${dto.postno }'>       
    <table align='center' border='1px' cellspacing='0px' cellpadding='5px'>
    <tr align='left'>
	  <th>말머리</th>
	  <td><select name="head">
	  <option value="Y">필독</option>
	  <option value="N">없음</option>
	  </select></td>
	<tr>
    <tr>
      <th>제목</th>
      <td><input type='text' name='title' size='50' value='${dto.title }' required></td>    
    </tr>
    <tr>
      <th>내용</th>
      <td><textarea style="resize: none; "name="contents" 
	  cols="53" rows="7" value='${dto.contents }' required></textarea></td>  
    </tr>
    <tr align="left">
      <th>이미지</th>
      <td>
          <img src="./community/storage/${dto.image_name}" width="50"
          onError="this.style.visibility='hidden'"><br><br>
      	  <input type='file' name='posterMF' size='50'>
      </td>  
    </tr>             
  </table>    
	<br><br>
  <input type='submit' value='수정' class="btn btn-success">
  <a href="Notice.do?nowpage=1" class="btn btn-success">수정취소</a>
  </form>
</div>  
</body>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>