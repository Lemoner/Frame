<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SessionPageOne</title>
</head>
<body>
<h2>SessionPageOne</h2>
<hr>
<%
	session.setAttribute("username", "administrator");
	application.getAttribute("");
	
%>
Session的ID：<%=session.getId() %><br>
Session的属性：<%=session.getAttribute("username") %><br>
<a href="SessionPageTwo.jsp" target="_blank">SessionPageTwo</a>
<%
	session.setMaxInactiveInterval(1000);
%>
</body>
</html>