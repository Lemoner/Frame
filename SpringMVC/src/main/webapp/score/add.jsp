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
		姓名：<input id="sname" name="sname" type="text"> <br> <br>
		学号：<input id="sid" name="sid" type="text"> <br> <br>
		班级：<input id="sgrade" name="sgrade" type="text"> <br> <br>
		语文：<input id="chinese" name="chinese" type="text"> <br> <br>
		数学：<input id="math" name="math" type="text"> <br> <br>
		英语：<input id="english" name="english" type="text"> <br> <br>
		<button type="submit">添加</button>
		<button type="reset">重置</button>
	</form>
</body>
</html>