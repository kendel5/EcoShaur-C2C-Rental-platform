<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 BRead.jsp-->
<body>
<div class="container">
	<H3>게시물</H3>
<br><br>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel-body">
					<table class="table table-striped table-bordered table-hover" 
					 style="vertical-align:middle">
						<thead>
							<tr>
								<th width="20%">NO</th>
								<td>${dto.postno}</td>
							</tr>
							<tr>
								<th>제목</th>
								<td>${dto.title}</td>
							</tr>
							<tr>
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
								<th>작성자</th>
								<td>${dto.id}</td>
							</tr>
							<tr>
								<th>조회수</th>
								<td>${dto.view}</td>
							</tr>
							<tr>
								<th>좋아요</th>
								<td>${dto.good}</td>
							</tr>
							<tr>
								<th>싫어요</th>
								<td>${dto.bad}</td>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>	
	<a href="Good.do?postno=${dto.postno}" class="btn btn-success">좋아요</a>
	<a href="Bad.do?postno=${dto.postno}" class="btn btn-success">싫어요</a>
	<br><br>
	<a href="Board.do?nowpage=1" class="btn btn-success">돌아가기</a>
	<a href="BUpdate.do?postno=${dto.postno}" class="btn btn-success">수정</a>
	<a href="BDelete.do?postno=${dto.postno}" class="btn btn-success">삭제</a>
</body>

<!-- 본문 끝 -->		
<%@ include file="../footer.jsp" %>