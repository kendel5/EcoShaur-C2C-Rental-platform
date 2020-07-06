<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 Board.jsp-->

	<div class="container">
<br><br><br><br><br><br><br><br>

		<div class="row">
			<div class="col-lg-12">
				<div class="panel-body">
					<table class="table table-striped table-bordered table-hover"
						   style="text-align: center;">
						<thead>
							<tr>
								<th>NO</th>
								<th>제목</th>
								<th>작성일</th>
								<th>작성자</th>
								<th>조회수</th>
								<th>좋아요</th>
								<th>싫어요</th>
							</tr>
						</thead>
						<c:forEach var="dto" items="${list}">
							<tr>
								<td width="7%">${dto.postno}</td>
								<td align="left"><a href="BRead.do?postno=${dto.postno}">${dto.title}</a></td>
								<c:set var="date" value="${dto.post_date}"/>
								<td>${fn:substring(date,0,10)}</td>
								<td>${dto.id}</td>
								<td>${dto.view}</td>
								<td>${dto.good}</td>
								<td>${dto.bad}</td>
							</tr>								
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
  <div class='bottom'>
    <input type='button' value='글작성 하기' onclick="location.href='BCreate.do'">
  </div>

<br><br><br><br><br><br><br><br>
<!-- 본문 끝 -->		
<%@ include file="../e_footer.jsp" %>