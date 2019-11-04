<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>登录页面</title>
</head>
<body>
<h3>登录页面</h3>
<form action="${request.requestContext.requestPath}/login" method="post">
用户名：<input type="text" name="username"/><br/>
密码：<input type="password" name="password"/><br/>
<input type="submit" value="提交">
</form>
</body>
</html>
