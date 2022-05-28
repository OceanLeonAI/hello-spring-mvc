package com.leon.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @PROJECT_NAME: hello-spring-mvc
 * @CLASS_NAME: JobComponent
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2022/5/27 14:06
 * @Version 1.0
 * @DESCRIPTION: TODO
 **/
@Component
@EnableAsync
public class CustomisedThreadPoolScheduledTask {


    /**
     * 注入自定义线程池
     */
    @Resource(name = "customisedTaskExecutor")
    private TaskExecutor taskExecutor;

    private static final Logger logger = LoggerFactory.getLogger(CustomisedThreadPoolScheduledTask.class);

    public static String getNow() {
        //获取当前时间戳 (毫秒)
        long currentTime = System.currentTimeMillis();
//        System.out.println("当前时间戳为： " + currentTime);

        Date date = new Date(currentTime);
//        System.out.println("当前时间戳转换成时间为： " + date);

        // 定义格式化时间输出格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentSimpleDateFormat = simpleDateFormat.format(date);
//        System.out.println("当前时间戳转换成时间格式化后为： " + currentSimpleDateFormat);

        return currentSimpleDateFormat;
    }


    /**
     * 参考
     * https://cron.qqe2.com/
     */
    @Async("customisedTaskExecutor") // 指定线程池
    @Scheduled(cron = "0/2 * * * * ?")
    public void testCustomisedThreadPoolScheduled1() {
        // System.out.println("testScheduled1 --- " + Thread.currentThread().getId() + " --- " + Thread.currentThread().getName() + " --- " + getNow());
        logger.info("{} threadId---{} threadName---{} time---{}", "testCustomisedThreadPoolScheduled1",
                Thread.currentThread().getId(), Thread.currentThread().getName(), getNow());
    }

    @Async("customisedTaskExecutor")
    @Scheduled(cron = "0/2 * * * * ?")
    public void testCustomisedThreadPoolScheduled2() {
        logger.info("{} threadId---{} threadName---{} time---{}", "testCustomisedThreadPoolScheduled2",
                Thread.currentThread().getId(), Thread.currentThread().getName(), getNow());

    }

    /**
     * from xml bean
     */
    @Async("customisedTaskExecutor")
    @Scheduled(cron = "0/2 * * * * ?")
    public void testCustomisedThreadPoolScheduled3() {
        logger.info("{} threadId---{} threadName---{} time---{}", "testCustomisedThreadPoolScheduled3",
                Thread.currentThread().getId(), Thread.currentThread().getName(), getNow());
    }

    /**
     * from configuration bean
     * {@link com.leon.config.ExecutorConfig}
     */
    @Async("asyncServiceExecutor")
    @Scheduled(cron = "0/2 * * * * ?")
    public void testCustomisedThreadPoolScheduled4() {
        logger.info("from configuration bean");
        logger.info("{} threadId---{} threadName---{} time---{}", "testCustomisedThreadPoolScheduled4",
                Thread.currentThread().getId(), Thread.currentThread().getName(), getNow());
    }

}
