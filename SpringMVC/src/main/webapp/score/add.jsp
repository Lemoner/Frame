<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Score Add</title>
</head>
<body>
	<form action="<%= request.getContextPath()%>/score/save1" method="post">
		姓名：<input id="sname1" name="sname" type="text"> <br> <br>
		学号：<input id="sid1" name="sid" type="text"> <br> <br>
		班级：<input id="sgrade1" name="sgrade" type="text"> <br> <br>
		语文：<input id="chinese1" name="chinese" type="text"> <br> <br>
		数学：<input id="math1" name="math" type="text"> <br> <br>
		英语：<input id="english1" name="english" type="text"> <br> <br>
		<button type="submit">添加</button>
		<button type="reset">重置</button>
	</form>
</body>
</html>