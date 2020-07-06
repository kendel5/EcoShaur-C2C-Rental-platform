<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 Notice.jsp-->

	<div class="container">
<br><br><br><br><br><br><br><br><br>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel-body">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>NO</th>
								<td>${dto.postno}</td>
							</tr>	
							<tr>
								<th>제목</th>
								<td>${dto.title}</td>
							</tr>	
							<tr>
								<th>내용</th>
								<td>${dto.contents}<br><br><br>
								<img src="./community/storage/${dto.image_name}"
								onError="this.style.visibility='hidden'"></td>
							</tr>
							<tr>	
								<th>작성일</th>
								<c:set var="date" value="${dto.post_date}" />
								<td>${fn:substring(date,0,10)}</td>
							</tr>
							<tr>	
								<th>부모코드</th>
								<td>${dto.pcode}</td>
							</tr>
							<tr>	
								<th>자식코드</th>
								<td>${dto.ccode}</td>
							</tr>							
							<input type='hidden' name=dto.head value='${dto.head}'>
						</thead>						
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class='bottom'>
		<input type='button' value='문의사항 목록' onclick="location.href='QList.do'">
		<input type='button' value='답변하기' 
			onclick="location.href='QRes.do?pcode=${dto.pcode}&ccode=${dto.ccode+1}'">		
		<input type="button" value="삭제"
			onclick="location.href='NDelete.do?postno=${dto.postno}'">
	</div>	
<br><br><br><br><br><br><br><br><br>
<!-- 본문 끝 -->
<%@ include file="../e_footer.jsp"%>