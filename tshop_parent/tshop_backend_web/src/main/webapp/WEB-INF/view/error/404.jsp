<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		body {
			margin: 0;
			padding: 0;
			background: white;
		}
		
		.image {
			width: 80%;
			margin: 0 auto;
		}
		
		.image img {
			margin: 0 auto;
		}
	</style>

</head>
<body>

	<div class="image">
		<img alt="" src="<%=basePath %>/images/404.png">
	</div>
</body>
</html>