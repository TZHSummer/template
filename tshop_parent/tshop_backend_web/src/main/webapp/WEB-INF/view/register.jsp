<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
            $("input[type=submit]").on('click', function () {
                $.ajax({
                    url: '${pageContext.request.contextPath}/backend/manager/register',
                    type: 'POST',
                    dataType: 'json',
                    data: JSON.stringify($('#manager').serializeObject()),
                    contentType: 'application/json',  //缺失会出现URL编码，无法转成json对象
                    success: function (returnedData) {
                        /* JS对象转换为JSON字符串：JSON.stringify(JS)*/
                        /* JSON字符串转换为JS对象：JSON.parse(JSON)*/
                        if (returnedData.result == true) {
                            $("#result").text(returnedData.errorMessage);
                            window.location.href = "${pageContext.request.contextPath}/login";
                        }
                        var username = returnedData.manager.username;
                        var password = returnedData.manager.password;
                        var repassword = returnedData.manager.repassword;
                        var usernameError = "";
                        var passwordError = "";
                        var repasswordError = "";
                        if (returnedData.errorMap != null) {

                            if (returnedData.errorMap.username != null){
                                username = "";
                                usernameError = returnedData.errorMap.username;
                            }
                            if (returnedData.errorMap.password != null) {
                                password = "";
                                passwordError = returnedData.errorMap.password;
                            }

                            if (returnedData.errorMap.repassword != null) {
                                repassword = "";
                                repasswordError = returnedData.errorMap.repassword;
                            }
                            $("#result").text("");
                        }else {
                            $("#result").text(returnedData.errorMessage);
                        }

                        $("input[name=username]").val(username);
                        $("input[name=password]").val(password);
                        $("input[name=repassword]").val(repassword);
                        $("span:first").text(usernameError).css("color", "red");
                        $("span:eq(1)").text(passwordError).css("color", "red");
                        $("span:last").text(repasswordError).css("color", "red");
                    }
                });
            });
        });

    </script>


</head>
<body>
<p class="welcome">Welcome Register!</p>
<div class="base">
    <div class="register">

        <p id="result"></p>
        <form id="manager" method="post" onsubmit="return false">

            <table style="margin: 0 auto;">
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="username" placeholder="请输入6-20位用户名"></td>
                    <td><span></span></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="password" placeholder="请输入6-16位密码"></td>
                    <td><span></span></td>
                </tr>
                <tr>
                    <td>重复密码：</td>
                    <td><input type="password" name="repassword" placeholder="请输入6-16位密码"></td>
                    <td><span></span></td>
                </tr>
                <tr>
                    <td><input type="submit" value="注册"></td>
                    <td>
                        <button><a href="${pageContext.request.contextPath}/login">去登录</a></button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

</body>
</html>