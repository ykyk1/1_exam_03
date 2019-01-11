<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>/" />
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style/css/index.css" />
<script src="style/js/jquery.js"></script>
<title>在线考试系统</title>
</head>
<body>
	<div class="bg">
		<div>
			<div class="wel">在线考试系统</div>
			<div class="user">
				<div style="">用户名</div>
				<input id="username" type="text" name="username" value="" />
			</div>
			<div class="password">
				<div >密&nbsp;&nbsp;&nbsp;码</div>
				<input id="password" class="" type="password" name="密码" value="" />
			</div>
			<div class="rem">
				<input type="checkbox" name="" id="" value="" />
				<div id="reb">记住密码</div>
			</div>
			<div class="fg">
				<div style="font-size: 11px; margin-top: 11px;">
					<a style="font-size: 11px;" href="#">忘记密码？</a>
				</div>
			</div>
			<input id="login" class="btn" type="button" onclick="login()"  value="登录" />
		</div>
	</div>

</body>
<script type="text/javascript">
	function login() {
		var username = $("#username").val();
		var password = $("#password").val();
		$.ajax({
			url : "WebUserAction/dologin",
			data : {
				"username" : username,
				"password" : password
			},
			type : "post",
			success : function(message) {
				if (message == "success") {
					window.location.href="<%=request.getContextPath() %>/WebUserAction/domain"
				}
				if (message == "fail") {
					alert("用户名或密码错误，请重新输入");
				}
			},
			error : function() {
				alert("对不起, 服务器异常");
			}

		})

	}
</script>
</html>