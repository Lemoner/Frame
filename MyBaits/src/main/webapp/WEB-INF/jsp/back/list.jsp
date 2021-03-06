﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>内容列表页面</title>
		<link href="<%= path %>/resources/css/all.css" rel="stylesheet" type="text/css" />
		<script src="<%= path %>/resources/js/jquery-1.8.0.min.js" type="text/javascript"></script>
		<script src="<%= path %>/resources/js/list.js" type="text/javascript"></script>
	</head>
	<body style="background: #e1e9eb;">
		<form action="<%= request.getContextPath() %>/listMessageByPage.action" id="mainForm" method="post">
			<div class="right">
				<div class="current">
					当前位置：<a href="javascript:void(0)" style="color: #6E6E6E;">内容管理</a>
					&gt; 内容列表
				</div>
				<div class="rightCont">
					<p class="g_title fix">内容列表 
						<a class="btn03" href="javascript:initInsertMessage('<%= request.getContextPath() %>');">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="btn03" href="javascript:deleteMessageList('<%= request.getContextPath() %>');">删 除</a>
					</p>
					<table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">指令：</td>
								<td><input type="text" class="allInput" value="" name="command" /></td>
								<td width="90" align="right">简要描述：</td>
								<td><input type="text" class="allInput" value="" name="description" /></td>
								<td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
								<td><input type="hidden" value="${page.currentPage}" id="currentPage" name="currentPage"/></td>
							</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
									<th><input type="checkbox" id="all"/></th>
									<th>序号</th>
									<th>指令</th>
									<th>简要描述</th>
									<th>操作</th>
								</tr>
								<c:forEach items="${messageList}" var="message" varStatus="status">
									<tr <c:if test="${status.index %2!=0}">style='background-color:#ECF6EE;'</c:if>>
										<td><input type="checkbox" name="checkbox" value="${message.id}"/></td>
										<td>${status.index+1}</td>
										<td>${message.command}</td>
										<td>${message.description}</td>
										<td>
											<a href="#">修改</a>&nbsp;&nbsp;&nbsp;
											<a href="javascript:deleteMessage('<%= request.getContextPath() %>', '${message.id}');">删除</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class='page fix'>
							共 <b>${page.totalNumber}</b> 条 
							<c:if test="${page.currentPage!=1}">
								<a href="javascript:changeCurrentPage('<%= request.getContextPath() %>', '1');" class='first'>首页</a> 
								<a href="javascript:changeCurrentPage('<%= request.getContextPath() %>', '${page.currentPage-1}');" class='pre'>上一页</a>
							</c:if>
							当前第<span>${page.currentPage}/${page.totalPage}</span>页
							<c:if test="${page.currentPage!=page.totalPage}">
								<a href="javascript:changeCurrentPage('<%= request.getContextPath() %>', '${page.currentPage+1}');" class='next'>下一页</a> 
								<a href="javascript:changeCurrentPage('<%= request.getContextPath() %>', '${page.totalPage}');" class='last'>末页</a>
							</c:if> 
							 跳至&nbsp;
							<input type='text' value='1' class='allInput w28' />
							&nbsp;页&nbsp; 
							<a href='###' class='go'>GO</a>
						</div>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>