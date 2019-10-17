<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><!-- jsp文件本身编码，如果这里不写，页面中文是ISO-8859-1 -->
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><!-- 服务器响应内容输出到html，所用的编码 -->
		<title>charting room</title>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	   	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	   	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	   	<script type="text/javascript">
	   		$(function(){
	   			var chart_url = "ws://localhost:8084/demo/chart/";
	   			var ws = null;
	   			//加入聊天
	   			$("#user_join").on("click",function(){
	   				var username = $("#in_user_name").val();
	   				ws = new WebSocket(chart_url+username);
	   				ws.onopen = function(){
	   					console.log("connect to websocket...");
	   				};
	   				ws.onmessage = function(e){
	   					//服务器发来的信息，通过e.data接收
	   					$("#message_content").append(e.data+"\n");
	   				};
	   				ws.onclose = function(){
	   					$("#message_content").append("用户["+username+"]退出了聊天室...");
	   					console.log("websocket closed...");
	   				};
	   				ws.onerror = function(){
	   					console.log("connection error...");
	   				};
	   			});
	   			//发送消息
	   			$("#user_send_all").on("click",function(){
	   				if(ws){
	   					ws.send($("#in_room_msg").val());
	   				}
	   			});
	   			//退出聊天室
	   			$("#user_exit").on("click",function(){
	   				if(ws){
	   					ws.close();
	   				}
	   			});
	   		});
	   	</script>
	</head>
	<body class="container" style="width: 60%">
		<div class="form-group">
			<br>
			<h5>聊天室</h5>
			<textarea id="message_content" class="form-control" readonly="readonly" rows="10" cols="50"></textarea>
		</div>
		<div class="form-group">
			<label for="in_user_name">用户姓名&nbsp;</label>
			<input id="in_user_name" class="form-control">
			<br>
			<button id="user_join" class="btn btn-success">加入聊天</button>
			<button id="user_exit" class="btn btn-warning">退出聊天</button>
		</div>
		<div class="form-group">
			<label for="in_room_msg">输入内容&nbsp;</label>
			<input id="in_room_msg" class="form-control">
			<br>
			<button id="user_send_all" class="btn btn-info">发送消息</button>
		</div>
	</body>
</html>
