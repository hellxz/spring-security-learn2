package com.github.hellxz.security.filters;

import com.github.hellxz.security.CaptchaException;
import com.github.hellxz.security.security.LoginFailureHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckCaptchaCodeFilter extends OncePerRequestFilter {

    private LoginFailureHandler loginFailureHandler;

    public LoginFailureHandler getLoginFailureHandler() {
        return loginFailureHandler;
    }

    public void setLoginFailureHandler(LoginFailureHandler loginFailureHandler) {
        this.loginFailureHandler = loginFailureHandler;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //只有登录请求才拦截
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/user/login") && !requestURI.contains("/user/loginPage")) {
            //获取用户输入的验证码 与 系统生成的验证码
            String captchaCode = request.getParameter("captchaCode");
            String code = (String) request.getSession().getAttribute("code");

            try{
                //验证不为空
                if(StringUtils.isAnyBlank(captchaCode)){
                    throw new CaptchaException("验证码不能为空");
                }
                //去空格转小写 不校验大小写
                captchaCode = captchaCode.trim().toLowerCase();
                //验证正确性
                if(!captchaCode.equals(code)){
                    throw new CaptchaException("验证码不正确");
                }
            }catch(AuthenticationException e){
                //校验失败的处理逻辑
                loginFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
