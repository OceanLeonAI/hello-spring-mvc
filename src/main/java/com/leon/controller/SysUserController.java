package com.leon.controller;

import com.leon.entity.SysUser;
import com.leon.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/getInfo")
    public String getUserInfo(HttpServletRequest request) {
        SysUser user = sysUserService.getOneById(1);
        request.setAttribute("user", user);
        return "userinfo";
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map<Object, Object> insert(@RequestBody SysUser sysUser) {
        boolean insert = sysUserService.insert(sysUser);
        Map map = new HashMap();
        map.put("code", 200);
        map.put("success", insert);
        map.put("data", null);
        map.put("message", insert ? "新增成功" : "新增失败");

        return map;
    }

    /**
     * 查询所有用户信息
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectAll")
    public List<SysUser> selectAll(HttpServletRequest request) {
        List<SysUser> sysUserList = sysUserService.selectAll(null);
        request.setAttribute("sysUserList", sysUserList);
        return sysUserList;
    }

}