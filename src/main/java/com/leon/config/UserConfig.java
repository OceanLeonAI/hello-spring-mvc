package com.leon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @PROJECT_NAME: hello-spring-mvc
 * @CLASS_NAME: UserConfig
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2022/5/28 10:30
 * @Version 1.0
 * @DESCRIPTION: 测试property文件读取
 **/
@Component
// @PropertySource(value = "classpath:user.properties") // FIXME: 直接映射不得行？？？
public class UserConfig {

    @Value("${user.username}")
    private String username;

    @Value("${user.age}")
    private int age;


    /**
     * 可以输出 bean 初始化以后的内容
     */
    @PostConstruct
    public void init() {
        System.out.println("username = " + username);
        System.out.println("age = " + age);
    }

}
