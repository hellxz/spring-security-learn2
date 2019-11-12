<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>登录页面</title>
<style type="text/css">
.h5{
   color: red;
}
</style>
</head>
<body>
<h3>登录页面</h3>
<c:if test="${not empty param.error}">
<h5 style="color: red;">用户名或密码输入不正确，请检查后重试</h5>
</c:if>
<form action="/user/login" method="post">
用户名：<input type="text" name="username"/><br/>
密码：<input type="password" name="password"/><br/>
<input type="submit" value="提交">
</form>
</body>
</html>
