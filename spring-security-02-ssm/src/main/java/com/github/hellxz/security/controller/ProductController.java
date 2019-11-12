package com.github.hellxz.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 写一个最简单的crud作测试,暂不考虑页面的请求类型
 */
@Controller
public class ProductController {

    @RequestMapping("product/add")
    public String addProduct(){
        return "product/productAdd";
    }

    @RequestMapping("product/del")
    public String delProduct(){
        return "product/productDel";
    }

    @RequestMapping("product/mod")
    public String modProduct(){
        return "product/productMod";
    }

    @RequestMapping("product/get")
    public String getProduct(){
        return "product/productGet";
    }

}
