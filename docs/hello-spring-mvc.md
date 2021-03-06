# Spring SpringMVC 配置

> 注意web加载Spring和SpringMVC配置的顺序
>
> https://blog.csdn.net/py_xin/article/details/52052627

# 事务

> https://www.cnblogs.com/jing99/p/11495252.html
>
> 事务失效的原因，可能是：
>
> 1. Spring配置加载，扫描 @Controller @Service...
> 2. SpringMVC配置加载，覆盖掉已经加载的Bean导致事务失效
>
>

# Forward（转发） VS Redirectf（重定向）

## Forward

> 定义：
>
> xxx

## Redirect

> 定义：
>
> xxx

# Filter VS HandlerInterceptor VS Listener

> https://www.baeldung.com/spring-mvc-handlerinterceptor-vs-filter
>
> https://juejin.cn/post/7021684725018263583
>
> https://www.i4k.xyz/article/robinjwong/39611115
>
> https://www.jianshu.com/p/2fcdc9a5f9bd

# Web.xml

1. 执行顺序：context-param ---> filter ---> listener ---> servlet

> https://www.cnblogs.com/hellojava/archive/2012/12/28/2835730.html

# HTTP header相关

> https://www.cnblogs.com/111testing/p/6037579.html

# Ajax和SpringMVC参数传递

> https://blog.csdn.net/xie_xiansheng/article/details/54377311?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0.queryctrv4&spm=1001.2101.3001.4242.1&utm_relevant_index=3

| GET/POST | 传参       | AJAX参数                                                     | 后端接受参数 | 备注 |      |
| -------- | ---------- | ------------------------------------------------------------ | ------------ | ---- | ---- |
| GET      |            |                                                              |              |      |      |
| POST     | JSON字符串 | $.ajax({ url: '<%=path%>/user/insert', type: 'POST', //POST/GET    async: true, //或false,是否异步 contentType: "application/json; charset=utf-8", data: JSON.stringify(obj), // 后台用 @RequestBody形式接收参数，前台需要传递JSON字符串 // timeout: 5000, //超时时间 dataType: 'json', //返回的数据格式：json/xml/html/script/jsonp/text    beforeSend: function (xhr) { console.log('发送前')        console.log(xhr)    }, success: function (data, textStatus, jqXHR) { // debugger; console.log('成功')        console.log(data)        console.log(textStatus)        console.log(jqXHR)    }, error: function (xhr, textStatus) { // debugger; console.log('错误')        console.log(xhr)        console.log(textStatus)    }, complete: function () { console.log('结束')    }}); | @RequestBody |      |      |
|          |            |                                                              |              |      |      |
|          |            |                                                              |              |      |      |
|          |            |                                                              |              |      |      |
|          |            |                                                              |              |      |      |
|          |            |                                                              |              |      |      |
|          |            |                                                              |              |      |      |
|          |            |                                                              |              |      |      |

# Exception处理

## 注意事项

1. 自定义异常的自定义
2. 注意区分请求应返回的是页面（JSP/HTML）还是数据（JSON DATA）
    1. 返回页面
       ```java
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
               }
       ```
    2. 返回JSON数据 出去上述1中的情况都是返回JSON数据

3. 注意实现方式
    1. 通过 `extends SimpleMappingExceptionResolver`
       并且覆盖`org.springframework.web.servlet.handler.SimpleMappingExceptionResolver.doResolveException`
    2. 通过注解实现
        1. `org.springframework.web.bind.annotation.ControllerAdvice`
           或者 `org.springframework.web.bind.annotation.RestControllerAdvice`
        2. `org.springframework.web.bind.annotation.ExceptionHandler`

> 全局异常返回页面(jsp/html)或者数据（json data）https://www.cnblogs.com/zsg88/p/11543654.html

# DAILY REVIEW

## 20220228 星期一

1. web.xml 异常处理

    1. http 400 不属于Exception范畴，需要单独配置

    2. 异常会按照最佳匹配

    3. 在web.xml中配置兜底

       ```xml
           <error-page>
               <!-- 捕获运行时异常 -->
               <exception-type>java.lang.RuntimeException</exception-type>
               <!-- 捕获一切异常 -->
               <!--<exception-type>java.lang.Throwable</exception-type>-->
               <location>/common/errors/runtimeexception.jsp</location>
           </error-page>
       ```

    4.

2. 验证 全局异常捕 `CustomisedSimpleMappingExceptionResolver`获合理性

    1. **关闭**`web.xml`中配置，**开启**`CustomisedSimpleMappingExceptionResolver`，异常被Tomcat处理，返回默认500页面
    2. **关闭**`web.xml`中配置，**关闭**`CustomisedSimpleMappingExceptionResolver`，异常被Tomcat处理，返回默认500页面
    3. **打开**`web.xml`中配置，**关闭**`CustomisedSimpleMappingExceptionResolver`，异常被Tomcat处理，返回自定义页面

## 20220302 星期三异常处理

> Invalid character found in the request target. The valid characters are defined in RFC 7230 and RFC 3986

**解决方案**

tomcat 策略修改

```tex
   server.xml
   <Connector port="8081" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8444" URIEncoding="UTF-8"
			   relaxedPathChars="[]|" 
			   relaxedQueryChars="[]|{}^&#x5c;&#x60;&quot;&lt;&gt;" 
			   />
	catalina.properties
	tomcat.util.http.parser.HttpParser.requestTargetAllow=|{}
    org.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH=true
```



| 解决方法        | 结果      | 说明                                              | 参考                                                         |
| --------------- | --------- | ------------------------------------------------- | ------------------------------------------------------------ |
| Filter 捕获异常 | 失败      | 无法捕获 http 400 异常                            |                                                              |
| 全局异常捕获    | 失败      | 无法捕获 http 400 异常                            |                                                              |
| 项目 web.xml    | 失败      | 无法捕获 pen testing 400，可以捕捉内部400         |                                                              |
| Tomcat安全策略  | 失败/成功 | URL中不能包含的特殊字符，详情见上方tomcat策略修改 | https://cloud.tencent.com/developer/article/1142521<br/>https://blog.csdn.net/ljheee/article/details/82051755 |
| Tomcat统一异常  |           |                                                   | https://blog.51cto.com/u_15127648/2776631                    |
|                 |           |                                                   |                                                              |

1. web.xml 处理异常流程

   > https://leokongwq.github.io/2017/03/25/java-web-exception.html

2. xxx