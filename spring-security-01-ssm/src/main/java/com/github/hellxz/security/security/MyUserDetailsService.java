package com.github.hellxz.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 实现权限框架获取用户信息
 */
@Component("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    /**
     * 通过用户名查得用户信息
     * @param s 用户名
     * @return 用户信息包装类
     * @throws UsernameNotFoundException 当用户名没有对应用户报错
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //权限包装工具,授权字符串可以使用多个角色用,分隔
        List<GrantedAuthority> authorities =AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        //这个用户可以从数据库中取，这里没有连接数据库
        User user = new User("hellxz", "123", authorities); //相当于在配置文件硬编码写的
        return user;
    }
}
