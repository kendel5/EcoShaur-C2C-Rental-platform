<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">

<style>
 p {
    font-family: "Nanum Gothic", sans-serif;
    font-size: 30px;
    font-weight: 800;
   }
</style>

<!-- 본문 시작 loginProc.jsp-->
<br><br><br><br>

<h3>로그인 결과</h3>
<c:choose>
	<c:when  test="${(grade eq 'U') || (grade eq 'S') || (grade eq 'P') || (grade eq 'M')}">
    	아이디 :${id } <br>
    	등급 :${grade }
	</c:when>
	<c:otherwise>
		
	</c:otherwise>
</c:choose>
	
<br><br>
<tr>
    <td colspan="2" align="center">
    	<form method="post" action="logout.do">
      		<input type="submit" value="로그아웃" >
        </form>
        
        <a class="btn btn-primary" href="./">메인페이지</a>

    	<a class="btn btn-primary" href="mypage.do">마이페이지</a>

    </td>
</tr>
<br><br><br><br>
<%@ include file="../e_footer.jsp" %>