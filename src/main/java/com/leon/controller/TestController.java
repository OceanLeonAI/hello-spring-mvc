package com.leon.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @ResponseBody
    @RequestMapping("/testPost")
    public String testPost(String userId) {
        System.out.println("userId ---> " + userId);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "leon");

        return "hello world";
    }

}