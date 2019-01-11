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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="style/css/pintuer.css">
<link rel="stylesheet" href="style/css/admin.css">
<script src="style/js/jquery.js"></script>
<script src="style/js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>增加题库</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x"
				action="SysQuesAction/addQuestionSuccess">
				<div class="form-group">
					<div class="label">
						<label>分数：</label>
					</div>
					<div class="field">
						<input id="score" type="number" class="input w50" value="1"
							name="score" onchange="scoreback" data-validate="required:请选择分数" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>题目：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="title"
							data-validate="required:请输入标题" />
						<div class="tips"></div>
					</div>
				</div>


				<div class="form-group">
					<div class="label">
						<label>题型：</label>
					</div>
					<div class="field">
						<select name="type" class="input w50">
							<option value="">请选择题型</option>
							<option value="0">单选题</option>
							<option value="1">多选题</option>
						</select>
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o"
							onclick="addOption()" type="button">新增选项</button>
					</div>
				</div>
				<div id="optBox">
					<div class="form-group">
						<div class="label">选项A：</div>
						<div class="field">
							<input type="text" class="input" name="options" value="" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">选项B：</div>
						<div class="field">
							<input type="text" class="input" name="options" value="" />
						</div>
					</div>
				</div>
				<!-- 				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o"
							onclick="addAnswer()" type="button">新增答案</button>
					</div>
				</div> -->
				<div class="form-group" id="rightAnswer">
					<div class="label">
						<label>正确答案：</label>
					</div>
					<div class="field" id ="answerBox">
						<input type="checkbox" name="answerIndexs" value="0" />A
						 <input type="checkbox" name="answerIndexs" value="1" />B
						<div class="tips"></div>
					</div>
				</div>


				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
<script type="text/javascript">
	function scoreback() {
		if ($("#score").val() < 1) {
			$("#score").val("1");
		}
	}

	var optIndex = 2;

	function addOption() {

		var opt = String.fromCharCode(65 + optIndex);
		$("#optBox")
				.append(
						"<div class='form-group'>"
								+ "<div class='label'>选项"
								+ opt
								+ "：</div>"
								+ "<div class='field'>"
								+ "<input type='text' class='input' name='options' value='' />"
								+ "</div>" + "</div>")
		$("#answerBox").append(
				" <input type='checkbox' name='answerIndexs' value='" + optIndex +"'/>" + opt);

		optIndex++;
	}

	function addAnswer() {
		$("#rightAnswer")
				.append(
						"<div class='label'><label>正确答案：</label></div>''<div class='field'>"
								+ "<select id='answerBox' name='answerIndex' class='input w50'>"
								+ "<option value='0'>A</option>"
								+ "<option value='1'>B</option>	</select><div class='tips'></div></div>")

	}
</script>

</html>