package com.leon.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ExecutorConfig {

    /**
     * @Value https://blog.csdn.net/star_pluss/article/details/121921810
     */

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.usernameNotExist:notExist}")
    private String usernameNotExist;

    @Value("${async.executor.thread.core_pool_size:5}")
    private int corePoolSize;

    @Value("${async.executor.thread.max_pool_size:6}")
    private int maxPoolSize;

    @Value("${async.executor.thread.queue_capacity:99999}")
    private int queueCapacity;

    @Value("${async.executor.thread.name.prefix}")
    private String threadNamePrefix;

    private static final Logger logger = LoggerFactory.getLogger(ExecutorConfig.class);


    /**
     * 可以输出 bean 初始化以后的内容
     */
    @PostConstruct
    public void init() {
        System.out.println("init username = " + username);
        System.out.println("corePoolSize = " + corePoolSize);
        System.out.println("maxPoolSize = " + maxPoolSize);
        System.out.println("queueCapacity = " + queueCapacity);
        System.out.println("threadNamePrefix = " + threadNamePrefix);
        System.out.println("usernameNotExist = " + usernameNotExist);
    }

    /**
     * hardcode
     *
     * @return
     */
    @Bean(name = "asyncServiceExecutor")
    public Executor asyncServiceExecutor() {
        logger.info("start asyncServiceExecutor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(corePoolSize);
        //配置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        //配置队列大小
        executor.setQueueCapacity(queueCapacity);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("leon-task-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }

    /**
     * hardcode
     *
     * @return
     */
    @Bean(name = "asyncServiceExecutorHardCode")
    public Executor asyncServiceExecutorHardCode() {
        logger.info("start asyncServiceExecutorHardCode");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(5);
        //配置最大线程数
        executor.setMaxPoolSize(6);
        //配置队列大小
        executor.setQueueCapacity(99999);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("leon-task-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }

}
