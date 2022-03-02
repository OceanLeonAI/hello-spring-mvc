package com.leon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView index(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("message","这是通过modelAndView.addObject()设置的数据");

        return modelAndView;
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
     * 直接返回首页
     *
     * @param req
     * @param resp
     * @return
     * @throws Exception
     */
/*    @RequestMapping("/helloWorld")
    public ModelAndView helloWorld(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "直接返回页面");
        request.setAttribute("message", "直接返回页面");
//        modelAndView.setViewName("/WEB-INF/page/helloWorld.jsp");
//        modelAndView.setViewName("helloWorld");
        //          src/main/webapp/common/errors/generic-error.jsp
        modelAndView.setViewName("common/errors/generic-error");
        return modelAndView;
    }*/
    @RequestMapping("/helloWorld")
    public String helloWorld(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "直接返回页面");
        req.setAttribute("message", "直接返回页面");
        return "common/errors/generic-error";

        // WEB-INF 以外的页面需要转发或者重定向才能访问
        // return "redirect:/common/errors/generic-error.jsp";
        // return "forward:/common/errors/generic-error.jsp";
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
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/forwardByRequestDispatcherForward")
    public void forwardByRequestDispatcherForward(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("message", "it's forword,forwardByRequestDispatcherForward ");
        request.getRequestDispatcher("userinfo").forward(request, response);
    }

    /**
     * 重定向
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/redirect")
    public String redirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("message", "it's redirect,redirect:userinfo ");
        return "redirect:userinfo";

    }


    /**
     * 通过函数重定向
     *
     * @return
     */
    @RequestMapping("/redirectByResponseRedirect")
    public void redirectByResponseRedirect(HttpServletRequest request, HttpServletResponse response) throws
            Exception {
        request.setAttribute("message", "it's redirect,redirectByResponseRedirect ");
        response.sendRedirect("userinfo");
    }
}