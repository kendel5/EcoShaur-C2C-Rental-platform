<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 Notice.jsp-->

	<div class="container">
<br><br><br><br><br><br><br><br><br>
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
								<th>부모코드</th>
								<th>자식코드</th>
							</tr>
						</thead>
						<c:forEach var="dto" items="${list}">
							<tr>
								<td width="7%">${dto.postno}</td>
								<td align="left"><b>
								<c:if test="${dto.head == 'Y' }">[필독]	</c:if></b>
								<a href="QRead.do?postno=${dto.postno}">${dto.title}</a>								
								</td>
								<c:set var="date" value="${dto.post_date}"/>
								<td>${fn:substring(date,0,10)}</td>
								<td>${dto.pcode}</td>
								<td>${dto.ccode}</td>
							</tr>								
						</c:forEach>
					</table>
					<a href="Qna.do" class="btn btn-success">돌아가기</a>
				</div>
			</div>
		</div>
	</div>


<br><br><br><br><br><br><br><br><br><br><br>
<!-- 본문 끝 -->
<%@ include file="../e_footer.jsp"%>