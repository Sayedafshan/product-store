<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String s = (String)session.getAttribute("abc");
	if(s!=null){
	%>
<h1>WELOCME TO FRIENDS PAGE</h1>
<h3><a href="logout">LOGOUT</a></h3>
<%
	}else{
		response.sendRedirect("demoLogin.jsp");
	}
%>
</body>
</html>