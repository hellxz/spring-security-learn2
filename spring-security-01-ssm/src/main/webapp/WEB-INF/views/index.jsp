<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>首页</title>
</head>
<body>
<h2>以下是本网站的功能</h2>
<a href="${pageContext.request.contextPath}/product/add">添加商品</a><br/>
<a href="${pageContext.request.contextPath}/product/del">删除商品</a><br/>
<a href="${pageContext.request.contextPath}/product/mod">修改商品</a><br/>
<a href="${pageContext.request.contextPath}/product/get">查找商品</a>
</body>
</html>
