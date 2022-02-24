package com.leon.controller;

import com.leon.entity.SysUser;
import com.leon.exception.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 异常测试Controller
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping("/testBusinessException")
    public SysUser testBusinessException(String userId) {
        throw new BusinessException();
    }

}