<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/script/jquery-3.3.1.js"></script>

    <link rel="stylesheet" type="text/css" href="style.css">

    <script type="text/javascript">

        $(function () {

        });

    </script>

	
</head>
<body>
	<p class="welcome">Welcome Register!</p>
	<div class="register">
	
		<form action="<%=basePath %>/data/auto-register.shtml" method="post">
			<table style="margin: 0 auto;">
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="username" pattern="[\u4e00-\u9fa5]{4,10}" required="required" placeholder="请输入4-10位中文" value="${errorMessage.username == null ? qq.username : '' }"><span style="color: red;">${errorMessage.username}</span></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password" pattern="\w{6,16}" required="required" placeholder="请输入6-16位字母数字或下划线" value="${errorMessage.password == null ? qq.password : '' }"><span style="color: red">${errorMessage.password}</span></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><input type="text" name="gender" pattern="[\u4e00-\u9fa5]" required="required" placeholder="请输入1位中文" value="${errorMessage.gender == null ? qq.gender : '' }"><span style="color: red">${errorMessage.gender}</span></td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td><input type="number" name="age" pattern="[1-9][0-9]{0,3}" required="required" min="0" max="149" placeholder="请输入年龄0-150岁之间" value="${errorMessage.age == null ? qq.age : '' }"><span style="color: red">${errorMessage.age}</span></td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><input type="email" name="email" pattern="\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}" required="required" placeholder="请输入您的邮箱地址" value="${errorMessage.email == null ? qq.email : '' }"><span style="color: red">${errorMessage.email}</span></td>
				</tr>
				<tr>
					<td>手机号：</td>
					<td><input type="tel" name="phone" pattern="0?(13|14|15|18)[0-9]{9}" required="required" placeholder="请输入国内手机号" value="${errorMessage.phone == null ? qq.phone : '' }"><span style="color: red">${errorMessage.phone}</span></td>
				</tr>
				<tr>
					<td><input type="submit" value="点击提交"></td>
					<td><input type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>