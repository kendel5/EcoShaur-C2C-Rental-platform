<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="ssi.jsp"%>
<%@ include file="../header.jsp"%>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">

<style>
 p {
    font-family: "Nanum Gothic", sans-serif;
    font-size: 30px;
    font-weight: 800;
   }
</style>

<!-- 본문 시작 template.jsp-->
<br><br><br><br>

<%
	String pro_name = request.getParameter("pro_name");
	String id 		= request.getParameter("id").trim();
	String pw 	 	= request.getParameter("pw").trim();
	String mem_name = request.getParameter("mem_name").trim();
	String contact_number  = request.getParameter("contact_number").trim();
	String email	= request.getParameter("email").trim();
	String zip 	= request.getParameter("zip").trim();
	String address	= request.getParameter("address").trim();
	String address_r = request.getParameter("address_r").trim();
	
	dto.setPro_name(pro_name);
	dto.setId(id);
	dto.setPw(pw);
	dto.setMem_name(mem_name);
	dto.setContact_number(contact_number);
	dto.setEmail(email);
	dto.setZip(zip);
	dto.setAddress(address);
	dto.setAddress_r(address_r);

	
	int cnt = dao.insertmember(dto);
	if(cnt == 0){
		out.print("<p>회원가입에 실패했습니다</p>");
		out.print("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
	}else{
		out.println("<script>");
		out.println("  alert('회원가입에 성공했습니다');");
		out.println("  location.href='loginForm.do'");
		out.println("</script>");
	}// if end
%>	




<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- 본문 끝 -->		
<%@ include file="../e_footer.jsp" %>