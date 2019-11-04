package com.github.hellxz.security.web.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AuthenticationController {

    @RequestMapping(value = "/user/loginPage", method = RequestMethod.GET)
    public String loginPage(){
        return "loginPage";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String login(){
        return "login";
    }
}
