<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<p class="welcome">Welcome Register!</p>
	<div class="register">
		<form action="#" method="post">
			用户名：<input type="text" name="name"><br>
			密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"><br>
			验证码：<input type="number" name="securityCode"><br>
			<input type="submit" value="点击提交">
		</form>
	</div>
</body>
</html>