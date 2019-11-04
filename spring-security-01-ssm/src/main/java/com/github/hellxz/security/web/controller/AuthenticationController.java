package com.github.hellxz.security.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("user")
public class AuthenticationController {

    @RequestMapping("/loginPage")
    public String loginPage(){
        return "loginPage";
    }
}
