package com.github.hellxz.security.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这里为了演示访问资源，默认只给返回个名称就行了，懒得写页面：）
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @GetMapping("add")
    public String add(){
        return "添加商品";
    }
    @GetMapping("mod")
    public String mod(){
        return "修改商品";
    }
    @GetMapping("del")
    public String del(){
        return "删除商品";
    }
    @GetMapping("get")
    public String get(){
        return "查询商品";
    }
}
