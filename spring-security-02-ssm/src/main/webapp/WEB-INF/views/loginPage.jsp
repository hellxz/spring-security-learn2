<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>登录页面</title>
<script src="http://libs.baidu.com/jquery/1.7.2/jquery.min.js"></script>
</head>
<body>
<h3>登录页面</h3>
<div id="tipsDiv" style="display:none;">
</div>
<form method="post" id="loginForm">
用户名：<input type="text" name="username"/><br/>
密码：<input type="password" name="password"/><br/>
验证码：<input type="text" name="captchaCode"/><img src="/captcha" alt="验证码"><br/>
记住我<input type="checkbox" name="remember-me" value="true"/><br/>
<input type="button" value="登录" id="loginBtn">
</form>
<script>
    $(function(){
        $("#loginBtn").click(function(){
            $.post("${pageContext.request.contextPath}/user/login",
                $("#loginForm").serialize(),
                function(data){
                    if(data.success){
                        window.location.href="${pageContext.request.contextPath}/index"
                    }
                    else{
                        //显示提示框
                        if(data.errorMsg.indexOf("Bad credentials") != -1){
                            $("#tipsDiv").html("<h5 style='color: red;'>用户名或密码不正确</h5>");
                        }else{
                            $("#tipsDiv").html("<h5 style='color: red;'>"+ data.errorMsg +"</h5>");
                        }
                        $("#tipsDiv").show();
                    }
                },"json"
            )
        });
    });
</script>
</body>
</html>
