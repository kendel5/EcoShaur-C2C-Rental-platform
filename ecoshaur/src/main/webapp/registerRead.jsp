<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="header.jsp"%>
<!-- 사용자 정의 파일(CSS, JS) import -->
<!-- 본문 시작 -->
<style>
.table{
	width:auto;
	background-color:white;
	margin:auto;
	font-size:12pt;
}
</style>
<input type="hidden" name="rg_no" value="${dto.rg_no }">
<table class="table" style="font-family:'Noto Sans KR'; text-align:center;">
  <tr>
  	<th colspan='2' style="text-align:center; font-size:18pt;">제품 상세 보기</th>
  </tr>
  <tr>
  <th>제품번호</th>
  <td>${dto.rg_no}</td>
  </tr>
  <tr>
  <th>카테고리</th>
  <td>${dto.rg_code}</td>
  </tr>
  <tr>
  <th>제품명</th>
  <td>${dto.rg_name}</td>
  </tr>
  <tr>
  <tr>
  <th>등록일</th>
  <td>${fn:substring(dto.rg_date, 0, 10) }</td>
  </tr>
  <tr>
  <th>대표 이미지</th>
  <td><img src="./storage/${dto.rg_filename1 }" width="400"><br>
  </tr>
  <tr>
  <th>측면 이미지</th>
  <td>
  <c:if test="${dto.rg_filename2 !=null }">
  			<img src="./storage/${dto.rg_filename2 }" width="400">
  </c:if>
   <br>
  </tr>
  <tr>
  <th>제품 정보</th>
  <td>${dto.rg_info }</td>
  </tr>
  <tr>
  <th>사이즈</th>
  <td>${dto.rg_size}</td>
  </tr>
  <tr>
  <th>이니셜</th>
  <td>${dto.rg_init}</td>
  </tr>
</table>

<div class="bottom" style="font-family:'Noto Sans KR'; font-weight:700; font-size:14pt; text-align:center;">
	<input type="button" class="btn btn-secondary" value="제품 목록" onclick="location.href='list.do'">
	<input type='button' class="btn btn-success" value='제품 수정' onclick="location.href='update.do?rg_no=${dto.rg_no}'" >
  	<input type='button' class="btn btn-danger" value='제품 삭제' onclick="location.href='delete.do?rg_no=${dto.rg_no}'" >
  	
  	<br><br>
</div>
  
<!-- 본문 끝 -->
<%@ include file="e_footer.jsp"%>


