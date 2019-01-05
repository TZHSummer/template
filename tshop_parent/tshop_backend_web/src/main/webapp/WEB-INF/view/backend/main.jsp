<%--
  Created by IntelliJ IDEA.
  User: mlj
  Date: 18-12-10
  Time: 下午8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎使用TShop在线商城后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/script/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/script/tojson.js"></script>

    <script>
        $(function () {

            $("#showProduct").on('click', function (e) {
                e.preventDefault()
                $.ajax({
                    url: '${pageContext.request.contextPath}/backend/product/showProduct',
                    type: 'POST',
                    dataType: 'html',
                    success: function (returnedData) {
                        $("#maincontent").html(returnedData);
                    }
                });
            });


            $("#showManager").on('click', function (e) {
                e.preventDefault();
                $.ajax({
                    url: '${pageContext.request.contextPath}/backend/manager/showManager',
                    type: 'POST',
                    dataType: 'html',
                    success: function (returnedData) {
                        $("#maincontent").html(returnedData);
                    }
                });
            });

        });
    </script>
</head>
<body>
<div id="header">
    <a class="header_item" href="${pageContext.request.contextPath}/backend/main">首页</a>
    <a class="header_item" href="">|</a>
    <a class="header_item" href="">商品</a>
    <a class="header_item" href="">|</a>
    <a class="header_item" href="${pageContext.request.contextPath}/backend/manager/logout">更多</a>
    <a class="header_item" href="">|</a>
    <a class="header_item" href="${pageContext.request.contextPath}/backend/manager/logout">退出</a>
</div>
<div id="wrapper">
    <div id="navtop">
        <input type="text" id="searchText">
        <input type="button" value="搜索一下" id="searchButton">
    </div>
    <div id="center">
        <div id="navleft">
            <ul>
                <li id="showProduct"><a href="">商品管理</a></li>
                <li id="showManager"><a href="">管理员管理</a></li>
                <li><a href="">其它</a></li>
            </ul>
        </div>
        <div id="maincontent"></div>
        <div id="navright"></div>
    </div>
</div>
<div id="footer">
    <p class="copyright">Copyright © 2006-2018 mlj. All rights reserved.</p>
    <p class="copyright">Web site developed by @mlj</p>
</div>
</body>
</html>
