package com.leon.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @PROJECT_NAME: hello-spring-mvc
 * @CLASS_NAME: JobComponent
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2022/5/27 14:06
 * @Version 1.0
 * @DESCRIPTION: 在线 cron：https://www.bejson.com/othertools/cron/
 **/
@Component
public class DefaultThreadPoolScheduledTask {

    /**
     * 构建日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(DefaultThreadPoolScheduledTask.class);

    /**
     * 获取当前时间字符串
     *
     * @return
     */
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

    @Scheduled(cron = "0/5 * * * * ?")
    public void testDefaultThreadPoolScheduled1() {
        // System.out.println("testScheduled1 --- " + Thread.currentThread().getId() + " --- " + Thread.currentThread().getName() + " --- " + getNow());
        logger.info("{} threadId---{} threadName---{} time---{}", "testDefaultThreadPoolScheduled1",
                Thread.currentThread().getId(), Thread.currentThread().getName(), getNow());
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void testDefaultThreadPoolScheduled2() {
        logger.info("{} threadId---{} threadName---{} time---{}", "testDefaultThreadPoolScheduled2",
                Thread.currentThread().getId(), Thread.currentThread().getName(), getNow());

    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void testDefaultThreadPoolScheduled3() {
        logger.info("{} threadId---{} threadName---{} time---{}", "testDefaultThreadPoolScheduled3",
                Thread.currentThread().getId(), Thread.currentThread().getName(), getNow());
    }

}
