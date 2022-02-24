package com.leon.controller;

import com.leon.entity.SysUser;
import com.leon.exception.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {

    @ResponseBody
    @RequestMapping("/testPost")
    public Map<Object, Object> testPost(String userId) {
        System.out.println("userId ---> " + userId);

        Map map = new HashMap<Object, Object>();
        map.put("name", "leon");
        map.put("age", 20);
        map.put("address", "成都市高新区xxx镇xxx路");

        return map;
    }

    @ResponseBody
    @RequestMapping("/testPostUser")
    public SysUser testPostUser(String userId) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("OceanLeonAI");
        sysUser.setCreatedate(Calendar.getInstance().getTime());
        System.out.println(sysUser);
        return sysUser;
    }

    @RequestMapping("/testBusinessException")
    public SysUser testBusinessException(String userId) {
        throw new BusinessException();
    }

}