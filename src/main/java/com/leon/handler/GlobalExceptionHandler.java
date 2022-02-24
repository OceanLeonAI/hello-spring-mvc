/**
 *
 */
package com.leon.handler;

import com.leon.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理器
 */
//@ControllerAdvice
public class GlobalExceptionHandler {

    // 构造日志对象
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理所有不可知的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    Map handleException(Exception e) {
        LOGGER.info(e.getMessage(), e);
        Map<Object, Object> result = new HashMap<>();
        result.put("code", 9999);
        result.put("message", "未知");
        result.put("success", false);
        result.put("data", null);
        return result;
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

