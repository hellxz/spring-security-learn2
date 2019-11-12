package com.github.hellxz.security.controller;

import com.github.hellxz.security.captcha.Captcha;
import com.github.hellxz.security.captcha.SpecCaptcha;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class GeneralController {

    @RequestMapping("/index")
    public String goIndex(){
        return "index";
    }

    @RequestMapping("/imageCode")
    public void getImageCode(HttpServletResponse response){
        Captcha captcha = new SpecCaptcha();
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        ServletOutputStream outputStream = null;
        try{
            outputStream = response.getOutputStream();
            captcha.out(outputStream);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                outputStream.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }

    @RequestMapping("/imageText")
    public void getImageText(HttpServletResponse response){
        Captcha captcha = new SpecCaptcha();
        String text = captcha.text();
        response.setContentType(MediaType.TEXT_HTML_VALUE);
        PrintWriter writer = null;
        try{
            writer = response.getWriter();
            writer.write(text);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            writer.close();
        }
    }
}
