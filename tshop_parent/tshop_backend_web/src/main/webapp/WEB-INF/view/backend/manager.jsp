<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mlj
  Date: 18-12-15
  Time: 下午4:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员管理</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/js/script/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/script/bootstrap-paginator.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manager.css">
    <script src="${pageContext.request.contextPath}/js/script/jquery-3.1.1.js"></script>
    <script type="application/javascript">
        $(function(){
            var options = {
                bootstrapMajorVersion:3,    //bootstrap版本
                currentPage:${pageInfo.pageNum},    //当前页
                totalPages:${pageInfo.pages},   //总页数
                itemTexts:function (type,page) {    //设置显示样式，默认是箭头
                    switch (type) {
                        case 'first':
                            return '首页';
                        case 'prev':
                            return '上一页';
                        case 'next':
                            return '下一页';
                        case 'last':
                            return '末页';
                        case 'page':
                            return page;
                    }
                }
            };
            $('#pagination').bootstrapPaginator(options);
        });
    </script>
</head>
<body>
<table class="managers">
    <thead>
    <th colspan="5" rowspan="3" style="font-size: 36px">管理员表</th>
    </thead>
    <thead>
    <th>用户ID</th>
    <th>用户名</th>
    <th>用户状态</th>
    <th>用户等级</th>
    <th>操作</th>
    </thead>
    <tbody>
    <c:forEach items="${pageInfo.list}" var="manager">
        <tr>
            <td>${manager.id}</td>
            <td>${manager.name}</td>
            <td>
                <c:if test="${manager.enable==1}">启用</c:if>
                <c:if test="${manager.enable==0}">禁用</c:if>
            </td>
            <td>
                <c:if test="${manager.level==1}">系统管理员</c:if>
                <c:if test="${manager.level==2}">普通管理员</c:if>
            </td>
            <td>
                <button>修改</button>
                <button>删除</button>
                <button>
                    <c:if test="${manager.enable==1}">禁用</c:if>
                    <c:if test="${manager.enable==0}">启用</c:if>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
<%-- 使用bootstrap-paginator实现分页显示 --%>
<ul id="pagination"></ul>
</body>
</html>
