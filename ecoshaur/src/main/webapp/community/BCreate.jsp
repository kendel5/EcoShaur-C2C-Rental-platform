<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 BCreate.jsp-->
<body>
<div class="container">
	<H3>게시물 등록</H3>
<br><br>	
  <form method="post"
        action="BCreate.do"
        enctype="multipart/form-data" >         
    <table align='center' border='1px' cellspacing='0px' cellpadding='5px'>
    <tr>
      <th>제목</th>
      <td><input type='text' name='title' size='50' required></td>    
    </tr>
    <tr>
      <th>내용</th>
	  <td><textarea style="resize: none; "name="contents" 
	  cols="53" rows="7" wrap="hard" required></textarea></td>
    </tr>
    <tr>
      <th>이미지</th>
      <td align='left'><input type='file' name='posterMF' size='50'></td>    
    </tr>    
    <tr>
      <th>아이디</th>
      <td><input type='text' name='id' size='50'></td>    
    </tr>            
  </table>      
<br><br>
  <input type='submit' value='등록' class="btn btn-success">
  <a href="Board.do?nowpage=1" class="btn btn-success">등록취소</a>
  </form>
  </div>
</body>

<!-- 본문 끝 -->		
<%@ include file="../footer.jsp" %>