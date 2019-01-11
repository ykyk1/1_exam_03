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
<base href="<%=basePath%>/">
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" href="style/css/pintuer.css">
<link rel="stylesheet" href="style/css/admin.css">
<script src="style/js/jquery.js"></script>
<script src="style/js/pintuer.js"></script>
</head>
<body>
	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height: 150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<div class="panel loginbox">
					<div class="text-center margin-big padding-big-top">
						<h1>后台管理中心</h1>
					</div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
						style="color: red">${message}</span>
					<div class="panel-body"
						style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
						<div class="form-group">
							<div class="field field-icon-right">
								<input id="username" type="text" class="input input-big"
									name="username" placeholder="登录账号"
									data-validate="required:请填写账号" /> <span
									class="icon icon-user margin-small"></span>
							</div>
						</div>
						<div class="form-group">
							<div class="field field-icon-right">
								<input id="password" type="password" class="input input-big"
									name="password" placeholder="登录密码"
									data-validate="required:请填写密码" /> <span
									class="icon icon-key margin-small"></span>
							</div>
						</div>
						<div class="form-group">
							<div class="field">
								<input id="piccode" type="text" class="input input-big"
									name="code" placeholder="填写右侧的验证码"
									data-validate="required:请填写右侧的验证码" /> <img id="img"
									src="SysUserAction/getCode" alt="" width="100" height="32"
									class="passcode" style="height: 43px; cursor: pointer;"
									onclick="this.src=this.src+'?'">
							</div>
						</div>
					</div>
					<div style="padding: 30px;">
						<input type="button" onclick="login()"
							class="button button-block bg-main text-big input-big" value="登录">
					</div>
					<a href="<%=request.getContextPath() %>/webLogin.jsp">用户登录</a>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	function login() {
		var username=$("#username").val();
		var password=$("#password").val();
		var piccode=$("#piccode").val();
		$.ajax({
			url:"SysUserAction/dologin",
			data:{"username":username,"password":password,"piccode":piccode},
			type:"post",
			success:function(message){
				if(message=="success"){
					window.location.href="<%=request.getContextPath() %>/SysUserAction/domain";
				}else if(message=="error"){
					alert("验证码输入错误，请重新输入");
				    var s = $("#img").attr("src");
					$("#img").attr("src",s+"?");
				}else if(message=="fail"){
					alert("用户名或密码错误，请重新输入");
					var s = $("#img").attr("src");
					$("#img").attr("src",s+"?");
				}
			},
			error:function(){
				alert("对不起，服务器异常");
			}
		})
	}
</script>
</html>