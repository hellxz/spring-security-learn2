package com.github.hellxz.security.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 代替security:authenticationManger
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("hellxz").password("1234").authorities("ROLE_PRODUCT_ADD", "ROLE_PRODUCT_GET");
    }

    /**
     * 代替之前security:http配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/product/add").hasAuthority("ROLE_PRODUCT_ADD")
                .antMatchers("/product/del").hasAuthority("ROLE_PRODUCT_DEL")
                .antMatchers("/product/mod").hasAuthority("ROLE_PRODUCT_MOD")
                .antMatchers("/product/get").hasAuthority("ROLE_PRODUCT_GET")
                .antMatchers("/login").permitAll()
                .antMatchers("/**").fullyAuthenticated()
                .and().formLogin().loginPage("/login")
                .and().csrf().disable();
    }
}
