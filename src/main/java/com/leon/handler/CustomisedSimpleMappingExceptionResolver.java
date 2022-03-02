package com.leon.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * FIXME: 这个异常处理类不起作用
 * 全局异常处理
 * <p>
 * 参考：https://blog.csdn.net/chuncui2576/article/details/100759925?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1.pc_relevant_antiscan&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1.pc_relevant_antiscan&utm_relevant_index=1
 */
//@Component // 注入容器才能生效
public class CustomisedSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {

    // 获取日志记录器
    public static final Logger logger = LoggerFactory.getLogger(CustomisedSimpleMappingExceptionResolver.class);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

//        if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
//            // 处理逻辑...
//        } else {
//
//        }

        // 打印异常
        logger.error("{}", ex);

        // Expose ModelAndView for chosen error view.
        String viewName = determineViewName(ex, request);
        if (viewName != null) {
            // 如果不是AJAX请求,JSP格式返回
            if (!(request.getHeader("accept").contains("application/json")
                    || (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").contains("XMLHttpRequest")))) {
                logger.info("返回JSP");
                // Apply HTTP status code for error views, if specified.
                // Only apply it if we're processing a top-level request.
                Integer statusCode = determineStatusCode(request, viewName);
                if (statusCode != null) {
                    applyStatusCodeIfPossible(request, response, statusCode);
                }
                return getModelAndView(viewName, ex, request);
            } else { // 返回JSON数据
                try {
                    logger.info("返回JSON");
                    response.setContentType("text/json; charset=UTF-8"); //解决从服务器返回中文乱码问题
                    PrintWriter writer = response.getWriter();
                    // TODO: 判断异常类型返回不同信息，考虑统一返回数据格式
                    writer.write(ex.getMessage());
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        } else {
            return null;
        }
    }
}
