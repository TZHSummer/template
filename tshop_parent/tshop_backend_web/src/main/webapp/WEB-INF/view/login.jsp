<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/script/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/script/tojson.js"></script>

    <script type="text/javascript">

        $(function () {

            //发送表单ajax(阿贾克斯)请求
            //Ajax：Asynchronous JavaScript And XML(异步JavaScript和XML)
            $("input[type=submit]").on('click',function(){
                $.ajax({
                    url:'${pageContext.request.contextPath}/backend/manager/login',
                    type:'POST',
                    dataType:'json',
                    data:JSON.stringify($('#manager').serializeObject()),
                    contentType:'application/json',  //缺失会出现URL编码，无法转成json对象
                    success:function(returnedData){
                        $("#result").text(returnedData.errorMessage);
                        if (returnedData.result == true){
                            window.location.href = "${pageContext.request.contextPath}/backend/main";
                        }
                    }
                });
            });

        });

    </script>
</head>
<body>
	<p class="welcome">Welcome Login</p>
	<div class="base">
		<div class="login">
			<p id="result"></p>
			<form id="manager" method="post" onsubmit="return false">
				用户名：<input type="text" name="username" placeholder="请输入6-20位用户名"><br>
				密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" placeholder="请输入6-16位密码"><br>
				<input type="hidden" name="repassword">
				<input type="submit" value="登录">
				<button><a href="${pageContext.request.contextPath}/register">去注册</a></button>
			</form>
		</div>
	</div>
</body>
</html>