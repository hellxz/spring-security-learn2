package com.github.hellxz.security.test;

import com.github.hellxz.security.domain.Permission;
import com.github.hellxz.security.domain.User;
import com.github.hellxz.security.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void findByUsernameTest() {
        User jack = userMapper.findUserByUsername("jack");
        System.out.println(jack);
    }

    @Test
    public void findPermissionsByUsernameTest() {
        List<Permission> permissions = userMapper.findPermissionsByUsername("jack");
        for (Permission permission : permissions) {
            System.out.println(permission.getPermDesc() + "--" + permission.getPermTag());
        }
    }
}
