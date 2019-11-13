package com.github.hellxz.security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hellxz.security.utils.CaptchaUtil;
import com.github.hellxz.security.utils.SecurityUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GeneralController {

    @RequestMapping("/index")
    public String goIndex(){
        //这里为了展示登录后的信息，用错误信息显示更明显些
        System.err.println(SecurityUtil.getCurrentUsername());
        return "index";
    }

    @RequestMapping("/captcha")
    public void getImageCode(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> codeAndPicMap = CaptchaUtil.generateCodeAndPic();
        // 将四位验证码保存到session中
        HttpSession session = request.getSession();
        String code = codeAndPicMap.get("code").toString();
        //转小写保存到session
        code = code.toLowerCase();
        session.setAttribute("code", code);

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        //不缓存图片
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", -1);
        ServletOutputStream os = null;
        try{
            os = response.getOutputStream();
            ImageIO.write((RenderedImage) codeAndPicMap.get("codePic"), "jpeg", os);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                os.close();
                os = null;
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }

    @RequestMapping("/checkCode")
    public void checkCaptchaCode(@RequestParam String code, HttpServletRequest request, HttpServletResponse response) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        Map result = new HashMap(1);

        HttpSession session = request.getSession();
        String codeInSession = (String) session.getAttribute("code");

        if(StringUtils.isAnyBlank(code, codeInSession)){
            result.put("success", false);
        }
        code = code.toLowerCase();
        if(codeInSession.equals(code)){
            result.put("success", true);
        }else{
            result.put("success", false);
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;application/json");
        PrintWriter writer = null;
        try{
            writer = response.getWriter();
            writer.write(objectMapper.writeValueAsString(result));
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            writer.close();
            writer = null;
        }
    }
}
