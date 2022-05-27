package com.leon.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
public class JobComponent {

    private static Logger logger = LoggerFactory.getLogger(JobComponent.class);

    /**
     * https://cron.qqe2.com/
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void testScheduled() {
        System.out.println("job 定时任务被调用，当前时间：" + new Date());
    }

}
