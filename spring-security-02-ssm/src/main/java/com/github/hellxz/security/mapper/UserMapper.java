package com.github.hellxz.security.mapper;

import com.github.hellxz.security.domain.Permission;
import com.github.hellxz.security.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper {
    /**
     * 通过用户名查用户
     * @param username 用户名
     * @return 用户对象
     */
    User findUserByUsername(String username);

    /**
     * 通过用户名查用户权限
     * @param username 用户名
     * @return 权限列表
     */
    List<Permission> findPermissionsByUsername(String username);
}
