package com.github.hellxz.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@SpringBootApplication
public class SpringBootSecurityApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityApp.class, args);
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
