<%-- <%@ page language="java" pageEncoding="UTF-8"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>Login No Encoding</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/login/result4" method="post">
		账号<input id="id" name="id" type="text"> <br> <br>
		密码<input id="pw" name="pw" type="text"> <br> <br>
		<button type="submit">登录</button>
		<button type="reset">重置</button>
	</form>
</body>
</html>