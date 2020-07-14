<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 NRead.jsp-->
<body>
<div class="container">
	<H3>공지사항</H3>
<br><br>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel-body">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th width="20%">NO</th>
								<td>${dto.postno}</td>
							</tr>	
							<tr>
								<th>제목</th>
								<td>${dto.title}</td>
							</tr>	
							<tr style="white-space: pre-line;">
								<th style="vertical-align:middle">내용</th>
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
								<th>조회수</th>
								<td>${dto.view}</td>
							</tr>
							<input type='hidden' name=dto.head value='${dto.head}'>
						</thead>						
					</table>
				</div>
			</div>
		</div>
	</div>
	<a href="Notice.do?nowpage=1" class="btn btn-success">돌아가기</a>
	<a href="NUpdate.do?postno=${dto.postno}" class="btn btn-success">수정</a>
	<a href="NDelete.do?postno=${dto.postno}" class="btn btn-success">삭제</a>
</body>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>