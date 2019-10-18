<!-- jsp文件本身编码，如果这里不写，页面中文是ISO-8859-1 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
		<head>
			<!-- 服务器响应内容输出到html，所用的编码 -->
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>模板</title>
		   	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
		   	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		   	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	   	</head>
	   	<body class="container" style="width: 60%">
	   		<div class="form-group">
			    <h3>登录</h3>
			    <form method="post" id="loginForm">
			        <div class="form-group">
			            <label for="username">用户姓名&nbsp;</label>
			            <input id="username" name="username" class="form-control" type="text" placeholder="任意中文名">
			        </div>
			        <div class="form-group">
			            <label for="password">用户密码&nbsp;</label>
			            <input id="password" name="password" class="form-control" type="password" placeholder="任意密码">
			        </div>
			        <div class="form-group">
			        	<button id="loginBtn" class="btn btn-success">登录</button>
			        </div>
			    </form>
			</div>
			<script type="text/javascript">
				$(function(){
					$("#loginBtn").on("click",function(){
						$("#loginForm").attr({"action":"${ctx}/login"});
						$("#loginForm").submit();
					});
				});
			</script>
	   	</body>
</html>