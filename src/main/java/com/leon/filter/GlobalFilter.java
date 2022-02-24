package com.leon.filter;

import com.leon.handler.GlobalExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * 全局Filter案例
 * <p>
 * https://python.iitter.com/other/70893.html
 * 原因是，过滤器中没有重写public void init（）和 public void destroy() 方法，jdk 1.9 之后，可以不写这两个方法，如果用jdk1.8必须要写。
 * 不能直接使用快速生成代码的重写方法，要把init和destroy() 里面的super都删掉，当然不删destroy中的依旧可以启动
 */
public class GlobalFilter implements Filter {

    // 构造日志对象
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("init of GlobalFilter called... 只会在容器启动时执行一次");
        // Filter.super.init(filterConfig);
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("doFilter of GlobalFilter called...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        LOGGER.info("destroy of GlobalFilter called... 只会在容器关闭时执行一次");
        // Filter.super.destroy();
    }
}
