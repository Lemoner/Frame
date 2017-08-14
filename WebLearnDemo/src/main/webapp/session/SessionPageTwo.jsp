<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SessionPageTwo</title>
</head>
<body>
<h2>SessionPageTwo</h2>
<hr>
Session的ID：<%=session.getId() %><br>
Session的属性：<%=session.getAttribute("username") %><br>

</body>
</html>