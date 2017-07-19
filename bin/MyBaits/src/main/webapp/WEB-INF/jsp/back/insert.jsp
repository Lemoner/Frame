<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>新增内容页面</title>
		<link href="<%= path %>/resources/css/all.css" rel="stylesheet" type="text/css" />
		<script src="<%= path %>/resources/js/jquery-1.8.0.min.js" type="text/javascript"></script>
		<script src="<%= path %>/resources/js/list.js" type="text/javascript"></script>
	</head>
	<body style="background: #e1e9eb;">
		<form action="<%= request.getContextPath() %>/insertMessage.action" id="mainForm" method="post">
			<div class="right">
				<div class="current">
					当前位置：<a href="javascript:void(0)" style="color: #6E6E6E;">内容管理</a>
					&gt; 新增内容
				</div>
				<div class="rightCont">
					<p class="g_title fix">内容列表 
						<a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="btn03" href="javascript:deleteMessageList('<%= request.getContextPath() %>');">删 除</a>
					</p>
					<table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">指令：</td>
								<td><input type="text" class="allInput" value="" name="command" /></td>
							</tr>
							<tr>
								<td width="90" align="right">简要描述：</td>
								<td><input type="text" class="allInput" value="" name="description" /></td>
							</tr>
							<tr>
								<td width="90" align="right">回复内容：</td>
								<td><input type="text" class="allInput" value="" name="content" /></td>
							</tr>
							<tr>
								<td><input type="submit" id="submit" class="tabSub" value="添 加" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</form>
	</body>
</html>