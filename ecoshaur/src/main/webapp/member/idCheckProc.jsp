<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="ssi.jsp"%>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">

<style>
 p {
    font-family: "Nanum Gothic", sans-serif;
    font-size: 30px;
    font-weight: 800;
   }
</style>

<!-- 본문 시작 template.jsp-->
<div style="text-align: center">
<h3>* 아이디 중복확인  결과 *</h3>
<%
String id=request.getParameter("id").trim();
int cnt=dao.duplecateID(id);
out.println("입력ID : <strong>"+id+"</strong>");
if(cnt==1){
	out.println("<p>사용 가능한 아이디입니다</p>"); 
	out.println("<a href='javascript:apply(\"" + id + "\")'>[적용]</a>"); 
%>
	<script>
	function apply(id){
		//alert(id);
		//중복이 확인된 id를 부모창(opener)에 적용
		opener.memberForm.id.value=id;
		window.close();
	}//apply end
	</script>
<%
}else{
	 out.println("<p style='color:red'>해당 아이디는 사용할 수 없습니다!</p>");
}
%>
  <hr>
  <a href="javascript:history.back()">[다시검색]</a>
  &nbsp;&nbsp;
  <a href="javascript:window.close()">[창닫기]</a>
</div>




<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- 본문 끝 -->		
