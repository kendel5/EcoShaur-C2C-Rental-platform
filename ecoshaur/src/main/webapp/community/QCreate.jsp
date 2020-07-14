<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 QCreate.jsp-->
<body>
<div class="container">
	<H3>문의사항 등록</H3>
<br><br>
	<form method="post" action="QCreate.do" enctype="multipart/form-data">
		<table align='center' border='1px' cellspacing='0px' cellpadding='5px'>
			<tr align='left'>
				<th>문의분류</th>
				<td><select name="head">
				<option value="Qna-A">상품문의</option>
				<option value="Qna-B">사이트 이용문의</option>
				<option value="Qna-C">수령 및 반납문의</option>	
				<option value="Qna-D">기타문의</option>							
				</select></td>
			<tr>			
			<tr>
				<th>제목</th>
				<td><input type='text' name='title' size='50' required></td>
			</tr>
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
        <a href="Qna.do" class="btn btn-success">등록취소</a>
	</form>
</div>	
</body>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>