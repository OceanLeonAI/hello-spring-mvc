/**
 *
 */
package com.leon.handler;

import com.alibaba.fastjson.JSONObject;
import com.leon.exception.BaseException;
import com.leon.exception.BusinessException;
import com.leon.exception.RequestParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // 构造日志对象
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ServletException.class)
        // @ResponseStatus(HttpStatus.NOT_FOUND) // 这个可以控制返回的HTTP状态码
/*    @ResponseBody
    Map handleException(Exception ex) {
        LOGGER.info(ex.getMessage(), ex);
        Map<Object, Object> result = new HashMap<>();
        result.put("code", 9999);
        result.put("message", "未知");
        result.put("success", false);
        result.put("data", null);
        return result;
    }*/
    ModelAndView handleServletException(Exception e) {
        LOGGER.info(e.getMessage(), e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/common/errors/generic-error.jsp");
        modelAndView.addObject("message", "这个是通用业务异常");
        return modelAndView;
    }


    // @ResponseStatus(HttpStatus.NOT_FOUND) // 这个可以控制返回的HTTP状态码
/*    @ResponseBody
    Map handleException(Exception ex) {
        LOGGER.info(ex.getMessage(), ex);
        Map<Object, Object> result = new HashMap<>();
        result.put("code", 9999);
        result.put("message", "未知");
        result.put("success", false);
        result.put("data", null);
        return result;
    }*/
/*    ModelAndView handleException(Exception ex) {
        LOGGER.info(ex.getMessage(), ex);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/common/errors/generic-error.jsp");
        modelAndView.addObject("message","这个是通用业务异常");
        return modelAndView;
    }*/

    /**
     * 处理所有不可知的异常
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    ModelAndView handleException(HttpServletRequest request, HttpServletResponse response, Exception ex) {

        // 打印异常
        LOGGER.info(ex.getMessage(), ex);

        // 如果不是AJAX请求,JSP格式返回
        if (!(request.getHeader("accept").contains("application/json")
                || (request.getHeader("X-Requested-With") != null
                && request.getHeader("X-Requested-With").contains("XMLHttpRequest")))) {

            LOGGER.info("返回JSP");

            // 构造吧 ModelAndView 对象
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("message", "这个是通用业务异常");

            // 判断异常类型
            if (ex instanceof BaseException) {
                LOGGER.info("系统业务异常");
                modelAndView.setViewName("redirect:/common/errors/generic-error.jsp");
            } else {
                LOGGER.info("系统其他异常");
                modelAndView.setViewName("redirect:/common/errors/500.jsp");
            }
            return modelAndView;
        } else { // 返回JSON数据
            LOGGER.info("返回JSON");
            try {
                response.setContentType("text/json; charset=UTF-8"); //解决从服务器返回中文乱码问题
                PrintWriter writer = response.getWriter();
                // TODO: 判断异常类型返回不同信息，考虑统一返回数据格式
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("message", ex.getMessage());
                jsonObject.put("data", null);
                jsonObject.put("code", 500);
                writer.write(jsonObject.toJSONString());
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /**
     * 处理所有业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    Map handleBusinessException(BusinessException e) {
        LOGGER.info(e.getMessage(), e);
        Map<Object, Object> result = new HashMap<>();
        result.put("code", 1001);
        result.put("message", "业务异常");
        result.put("success", false);
        result.put("data", null);
        return result;
    }

    /**
     * 处理所有业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(RequestParameterException.class)
    @ResponseBody
    Map handleRequestParameterException(RequestParameterException e) {
        LOGGER.info(e.getMessage(), e);
        Map<Object, Object> result = new HashMap<>();
        result.put("code", 1001);
        result.put("message", "业务异常");
        result.put("success", false);
        result.put("data", null);
        return result;
    }

    /**
     * https://cheatsheetseries.owasp.org/cheatsheets/Error_Handling_Cheat_Sheet.html#java-springmvcspringboot-web-application
     * @param exception
     * @param request
     * @return
     */
    /*
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleGlobalError(RuntimeException exception, WebRequest request) {
        //Log the exception via the content of the parameter named "exception"
        //...
        //We build a generic response with a JSON format because we are in a REST API app context
        //We also add an HTTP response header to indicate to the client app that the response is an error
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        responseHeaders.set("X-ERROR", "true");
        JSONObject responseBody = new JSONObject();
        responseBody.put("message", "An error occur, please retry");
        //Note that we're using an internal server error response
        //In some cases it may be prudent to return 4xx error codes, if we have misbehaving clients
        ResponseEntity<JSONObject> response = new ResponseEntity<>(responseBody, responseHeaders,
                HttpStatus.INTERNAL_SERVER_ERROR);
        return (ResponseEntity) response;
    }*/
}

