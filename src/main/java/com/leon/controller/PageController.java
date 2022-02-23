package com.leon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SpringMVC 页面跳转参考 https://blog.csdn.net/figo0423/article/details/79759151
 */
@Controller
@RequestMapping("/page")
public class PageController {

    /**
     * 直接返回首页
     *
     * @param req
     * @param resp
     * @return
     * @throws Exception
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return "index";
    }

    /**
     * 直接返回首页
     *
     * @param req
     * @param resp
     * @return
     * @throws Exception
     */
    @RequestMapping("/userinfo")
    public String userinfo(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setAttribute("message", "直接返回页面");
        return "userinfo";
    }


    /**
     * 转发
     *
     * @param req
     * @param resp
     * @throws Exception
     */
    @RequestMapping("/forward")
    public String forward(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setAttribute("message", "it's forword,forward:userinfo ");
        return "forward:userinfo";
    }

    /**
     * 通过函数转发
     *
     * @param req
     * @param resp
     * @throws Exception
     */
    @RequestMapping("/forwardByRequestDispatcherForward")
    public void forwardByRequestDispatcherForward(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setAttribute("message", "it's forword,forwardByRequestDispatcherForward ");
        req.getRequestDispatcher("userinfo").forward(req, resp);
    }

    /**
     * 重定向
     *
     * @param req
     * @param resp
     * @throws Exception
     */
    @RequestMapping("/redirect")
    public String redirect(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setAttribute("message", "it's redirect,redirect:userinfo ");
        return "redirect:userinfo";

    }


    /**
     * 通过函数重定向
     *
     * @return
     */
    @RequestMapping("/redirectByResponseRedirect")
    public void redirectByResponseRedirect(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setAttribute("message", "it's redirect,redirectByResponseRedirect ");
        resp.sendRedirect("userinfo");
    }
}