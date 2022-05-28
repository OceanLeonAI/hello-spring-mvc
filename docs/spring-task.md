# spring-task

## 定时任务

### spring-task

> [Spring中使用SpringTask和Quartz实现多线程定时任务](https://blog.csdn.net/wanson2015/article/details/83994098)

### spring-quarts

> [ Spring Quartz 实现原理与示例 ](https://www.cnblogs.com/SpaceAnt/p/6354446.html)



## 线程池

> [SpringBoot 自定义线程池](https://blog.csdn.net/weixin_40816738/article/details/123974806)

## Property 文件映射

1. xml 配置 @value 获取

   * ```xml
     <!-- 映射properties文件 -->
         <bean id="propertyConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
             <!--<property name="locations">
                 <list>
                     &lt;!&ndash; 可以将配置文件放这个节点 &ndash;&gt;
                     <value>classpath:jdbc.properties</value>
                     <value>classpath:threadPool.properties</value>
                 </list>
             </property>-->
             <property name="locations" value="classpath*:*.properties"/>
             <!--<property name="locations" value="classpath*:*.properties"/>-->
         </bean>
     ```

   * ```properties
     # jdbc.properties
     jdbc.driver=com.mysql.cj.jdbc.Driver
     jdbc.url=jdbc:mysql://127.0.0.1:3306/leon?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC
     jdbc.username=root
     jdbc.password=root
     ```

   * ```java
     @Value("${jdbc.usernameNotExist:notExist}") // 冒号后边为默认值，防止NPE
         private String usernameNotExist;
     
         @Value("${async.executor.thread.core_pool_size:5}")
         private int corePoolSize;
     ```

   * 

2. 通过注解

   * ```java
     package com.leon.config;
     
     import org.springframework.beans.factory.annotation.Value;
     import org.springframework.context.annotation.Configuration;
     import org.springframework.context.annotation.PropertySource;
     
     import javax.annotation.PostConstruct;
     
     /**
      * @PROJECT_NAME: hello-spring-mvc
      * @CLASS_NAME: UserConfig
      * @AUTHOR: OceanLeonAI
      * @CREATED_DATE: 2022/5/28 10:30
      * @Version 1.0
      * @DESCRIPTION: 测试property文件读取
      **/
     @Configuration
     @PropertySource(value = "classpath:user.properties")
     public class UserConfig {
     
         @Value("${user.name}")
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
     
     ```

     