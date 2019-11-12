package com.github.hellxz.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController {

    @RequestMapping(value = "/user/loginPage", method = RequestMethod.GET)
    public String loginPage(){
        return "loginPage";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String login(){
        return "index";
    }

    @RequestMapping(value = "/user/access-denied", method = RequestMethod.POST)
    public String accessDeniedPage(){
        return "access-denied";
    }
}
