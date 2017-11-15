<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<!--设置浏览器的布局视口，只在移动端浏览器起作用-->
		<meta name="viewport" content="width=width-device,initial-scale=1,user-scalable=no" />
		<title></title>
		<!--引入bootstrap的核心css-->
		<link rel="stylesheet" href="js/Bootstrap/css/bootstrap.css" />
		<!--引入日历css-->
		<link rel="stylesheet" href="js/datetimepicker/jquery.datetimepicker.css" />
		<!--判断如果是IE9以下，引入兼容h5标签的js文件，注意空格的位置-->
		<!--[if lt IE 9]>
		<script src="js/bootstrap/js/html5shiv.min.js"></script>
		<script src="js/bootstrap/js/respond.min.js"></script>		
		<![end if] -->
	</head>

	<body>
		<div class="container">

			<h2 class="page-header">修改密码</h2>

			<form id="form1" class="form-horizontal">
				<div class="form-group">
					<label for="" class="col-md-2">登录名</label>
					<div class="col-md-10">
						<!--value="${sessionScope.empLoginName}"-->
						<input readonly id="empLoginName" name="empLoginName" value="${sessionScope.empLoginName}"  type="text" class="form-control" /> 
					</div>
				</div>
				<div class="form-group">
					<label for="" class="col-md-2">旧密码</label>
					<div class="col-md-10">
						<input id="preEmpPwd" name="preEmpPwd" type="password" placeholder="请输入旧密码" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label for="" class="col-md-2">登录密码</label>
					<div class="col-md-10">
						<input id="empPwd" name="empPwd" type="password" placeholder="请输入新密码" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label for="" class="col-md-2">确认密码</label>
					<div class="col-md-10">
						<input id="empPwd2" name="empPwd2" type="password" placeholder="请再次输入新密码" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-10 col-md-offset-2">
						<input type="button" value="修改" class="btn btn-success" id="updateBtn" />
						<input type="button" value="取消" class="btn btn-danger" onclick="history.back();" />
					</div>
				</div>
			</form>
		</div>

		<!--引入jquery-->
		<script src="js/jquery.js"></script>
		<!--引入参数工具js-->
		<script src="js/param.js"></script>
		<!-- 引入全局js -->
		<script src="js/global.js"></script>
		<!--引入bootstrap的js功能-->
		<script src="js/Bootstrap/js/bootstrap.js"></script>
		<!--引入layer插件-->
		<script src="js/layer/layer.js"></script>
		<!--引入日历js-->
		<script src="js/datetimepicker/jquery.datetimepicker.js"></script>
	</body>

</html>