<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 Board.jsp-->
<body>
	<div class="container">
	<H3>게시물 목록</H3>
	<br><br>
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
	<nav class="nav justify-content-center"
		aria-label="Page navigation example">
		<ul class="pagination">
			<c:choose>
				  <c:when test="${(nowpage-1)==0}"> <a class="page-link disabled">  </c:when>
                  <c:otherwise> <a class="page-link" href="Board.do?nowpage=${nowpage-1 }"> </c:otherwise>
          </c:choose>
          Previous</a></li>
		    <c:forEach var="i" begin="1" 
		    end="${count%recordPerPage==0 ? (count/recordPerPage) : (count/recordPerPage)+1}">
		    	<li class="page-item ${nowpage==i ? 'active' : ''}">
		    	<a class="page-link" href="Board.do?nowpage=${i}"><c:out value="${i}"/></a></li>
		    </c:forEach>
		          <li class="page-item"><c:choose><c:when test="${nowpage == i}"> 
		          <a class="page-link disabled">  </c:when>
                  <c:otherwise> <a class="page-link" href="Board.do?nowpage=${nowpage+1 }"> </c:otherwise>
          </c:choose>Next</a></li>        
	</ul>
	</nav>
          

<a href="BCreate.do" class="btn btn-success">글쓰기</a>

</body>
<!-- 본문 끝 -->		
<%@ include file="../footer.jsp" %>