package com.leon.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局拦截器示例
 * <p>
 * 参考：https://blog.51cto.com/u_15127684/3457866
 */
public class GlobalInterceptor implements HandlerInterceptor {

    // 构造日志对象
    private static final Logger LOGGER = LoggerFactory.getLogger(HandlerInterceptor.class);

    /**
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，
     * SpringMVC中的Interceptor拦截器是链式的，可以同时存在多个Interceptor，
     * 然后SpringMVC会根据声明的前后顺序一个接一个的执行，
     * 而且所有的Interceptor中的preHandle方法都会在Controller方法调用之前调用。
     * SpringMVC的这种Interceptor链式结构也是可以进行中断的，
     * 这种中断方式是令preHandle的返回值为false，当preHandle的返回值为false的时候整个请求就结束了。
     * Object handler为当前的控制器对应方法
     * HttpServletRequest request, HttpServletResponse response为当前的请求和响应
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        LOGGER.info("preHandle of HandlerInterceptor called...");

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    /**
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。
     * postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之 后， 也就是在Controller的方法调用之后执行，
     * 但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操作。
     * 这个方法的链式结构跟正常访问的方向是相反的，也就是说先声明的Interceptor拦截器该方法反而会后调用，
     * ModelAndView modelAndView 为当前返回的视图和数据模型 视图也就是是Controller中返回值的字符串之后被底层组装 数据模型也就是比如
     * request.setAttribute设置的k-v
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        LOGGER.info("postHandle of HandlerInterceptor called...");

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。
     * 该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行， 这个方法的主要作用是用于清理资源的
     * 也用来执行异常对象
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        LOGGER.info("afterCompletion of HandlerInterceptor called...");

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
