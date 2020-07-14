<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.jsp"%>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">

<style>
 p {
    font-family: "Nanum Gothic", sans-serif;
    font-size: 30px;
    font-weight: 800;
   }
</style>

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title>category/msgView.jsp</title> 
</head> 
<body>
  <div class="title">알림</div>
  <div class="content">  
  	<dl>
		<dd>${msg1 != null ? img : "" } ${msg1 }</dd>
		<dd>${msg2 != null ? img : "" } ${msg2 }</dd>
		<dd>${msg3 != null ? img : "" } ${msg3 }</dd>
	</dl>
	<p>
		${link1 } ${link2 } ${link3 }
	</p>
  </div>

</body> 
</html> 
