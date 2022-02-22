package com.leon.controller;

import com.leon.entity.SysUser;
import com.leon.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class SysUserController {

    @Resource
    public SysUserService sysUserService;

    @RequestMapping("/getInfo")
    public String getUserInfo(HttpServletRequest request) {
        SysUser user = sysUserService.getOneById(1);
        request.setAttribute("user", user);
        return "userinfo";
    }

}