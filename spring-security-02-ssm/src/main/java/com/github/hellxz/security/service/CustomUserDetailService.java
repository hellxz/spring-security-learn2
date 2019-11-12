package com.github.hellxz.security.service;

import com.github.hellxz.security.domain.Permission;
import com.github.hellxz.security.domain.User;
import com.github.hellxz.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //按用户名查出用户
        User user = userMapper.findUserByUsername(username);
        //查出用户权限
        List<Permission> permissions = userMapper.findPermissionsByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        permissions.stream().forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getPermTag())));
        user.setAuthorities(authorities);
        return user;
    }
}
