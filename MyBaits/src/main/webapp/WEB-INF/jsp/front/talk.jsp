<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>微信公众号</title>
	<!--讨论区滚动条begin-->
	<link rel="stylesheet" type="text/css" href="<%= path %>/resources/css/jscrollpane1.css" />
	<script src="<%= path %>/resources/js/jquery-1.8.0.min.js" type="text/javascript"></script>
	<!-- the mousewheel plugin -->
	<script type="text/javascript" src="<%= path %>/resources/js/jquery.mousewheel.js"></script>
	<!-- the jScrollPane script -->
	<script type="text/javascript" src="<%= path %>/resources/js/jquery.jscrollpane.min.js"></script>
	<script type="text/javascript" src="<%= path %>/resources/js/scroll-startstop.events.jquery.js"></script>
	<!--讨论区滚动条end-->
	<script type="text/javascript" src="<%= path %>/resources/js/talk.js"></script>
	</head>
	<body>
		<input type="hidden" value="<%= path %>" id="path"/>
		<br/>
		<div class="talk">
			<div class="talk_title"><span>正在与公众号对话</span></div>
			<div class="talk_record">
				<div id="jp-container" class="jp-container">
					
				</div>
			</div>
			
			<div class="talk_word">
				&nbsp;
				<input class="add_face" id="facial" type="button" title="添加表情" value="" />
				<input id="content" class="messages emotion"   />
				<input class="talk_send" onclick="send();" type="button" title="发送" value="发送" />
			</div>
		</div>
		<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';"></div>
	</body>
</html>