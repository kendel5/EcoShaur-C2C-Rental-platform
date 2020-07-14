<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 QRes.jsp-->
<body>
<div class="container">

	<H3>문의사항 답변</H3>
<br><br>
	<form method="post" action="QRes.do" enctype="multipart/form-data">
		<table align='center' border='1px' cellspacing='0px' cellpadding='5px'>
			<input type='hidden' name='head' value='${dto.head}'>
			<input type='hidden' name='pcode' value='${dto.pcode}'>
			<input type='hidden' name='ccode' value='${ccode}'>
			<tr align='left'>
				<th>문의분류</th>
				<td><b>
				<c:if test="${dto.head == 'Qna-A' }">[상품문의]	</c:if>
				<c:if test="${dto.head == 'Qna-B' }">[사이트 이용문의] </c:if>
				<c:if test="${dto.head == 'Qna-C' }">[수령 및 반납문의] </c:if></b></td>
				<c:if test="${dto.head == 'Qna-D' }">[기타문의]	</c:if></b></td>			
			<tr>			
			<tr>
				<th>제목</th>
				<td><input type='text' name='title' size='50' required></td>
    		<tr>
    			<th>내용</th>
	  			<td><textarea style="resize: none; "name="contents" 
				cols="53" rows="7" wrap="hard" required></textarea></td>
    		</tr>
			<tr >
				<th>이미지</th>
				<td align='left'><input type='file' name='posterMF' size='50'></td>
			</tr>
			<tr>
                 <th>아이디</th>
                 <td><input type='text' name='id' size='50'></td>    
            </tr> 
		</table>
		<br>
		<br>
		<div class='bottom'>
			<input type='submit' value='등록'> <input type='button'
				value='문의취소하기' onclick="location.href='Qna.do'">
		</div>

	</form>
	</div>
</body>

<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>