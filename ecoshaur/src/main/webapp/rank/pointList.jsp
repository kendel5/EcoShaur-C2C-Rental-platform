<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>


<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=https://fonts.googleapis.com/css?family=Inconsolata:400,500,600,700|Raleway:400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
<link rel="stylesheet" href="assets/libs/css/ranklist.css">

<!-- 본문 시작 pointList.jsp--> 
                                           
<div class="ranking-highest">
<ul id="select_summoner_highest" class="ranking-highest__list">

<br><br><br>
<div>
	<input type="button" value="포인트 순위" onClick="location.href='./Point.do'" class="btn btn-warning">
	<input type="button" value="좋아요 순위" onClick="location.href='./Rating.do'" class="btn btn-info">
</div>
<br><br><br><br>

	<c:forEach var="dto" items="${first}" varStatus="status">
		<li class="ranking-highest__item ranking-highest__item--big" id="summoner-41913808">
			<div class="ranking-highest__rank">1</div>
			<div class="ranking-highest__icon">
			<a href="">
				<img src="member/storage/${dto.pro_name}" class="ranking-highest__image">
			</a>
			</div>
			<div class="ranking-highest-champions">
				<span>${dto.id}</span><br>
				<span>${dto.point}점</span>
			</div>
			<a href="" class="ranking-highest__name">${dto.mem_name}</a>
			<div class="ranking-highest__tierrank first">
				<img src="assets/images/firstgrade.png">
				<span>${dto.grade}</span>
			</div>
		</li>
	</c:forEach>
	<c:forEach var="dto" items="${second}" varStatus="status">	
		<li class="ranking-highest__item " id="summoner-85224235">
			<div class="ranking-highest__rank">${status.count+1}</div>
			<div class="ranking-highest__icon">
				<a href=""><img src="member/storage/${dto.pro_name}" class="ranking-highest__image"></a>
			</div>
			<a href="" class="ranking-highest__name">${dto.mem_name}</a>
			<div class="ranking-highest__tierrank ">
				<img src="assets/images/firstgrade.png">
				<span>${dto.grade}</span>
				<span>${dto.id}</span>
			</div>
			<div class="ranking-highest-winratio">
				<div class="winratio">
					<div class="winratio-graph">
					<div class="winratio-graph__fill winratio-graph__fill--left"></div>
					<div class="winratio-graph__text winratio-graph__text--left">&nbsp;&nbsp;&nbsp;&nbsp;포인트 : ${dto.point}점</div>
				</div>
			</div>
			</div>
		</li>
	</c:forEach>
</ul>
</div>

<br><br><br>

<c:forEach var="dto" items="${others}" varStatus="status">
<div class=”table-responsive“>
<table class="table table-hover">
	<thead>
		<tr>
			<th scope="col" class="table-primary">순위</th>
			<th scope="col" class="table-primary">프로필</th>
			<th scope="col" class="table-primary">아이디</th>
			<th scope="col" class="table-primary">닉네임</th>
			<th scope="col" class="table-primary">등급</th>
			<th scope="col" class="table-primary">포인트</th>		
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${status.count+5}</td>
			<td>
				<a href="#">
					<img src="member/storage/${dto.pro_name}" width="50" height="50">
				</a>
			</td>
			<td>
				<a href="#"><span>${dto.id}</span></a>
			</td>
			<td>
				<a href="#"><span>${dto.mem_name}</span></a>
			</td>
			<td>${dto.grade}</td>
			<td>${dto.point}</td>
		</tr>
	</tbody>
</table>
</div>
</c:forEach>


<div class="ranking-pagination__desc">
	<span>1 ~ 20</span> 위
</div>



<!-- 본문 끝 -->			
<%@ include file="../footer.jsp" %>