package com.leon.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * 先要保证 Spring先初始化好
 */
public class GlobalListener extends ContextLoaderListener {

    private static Log logger = LogFactory.getLog(GlobalListener.class);

    public void contextInitialized(ServletContextEvent event) {
        logger.info("开始启动系统...");
        super.contextInitialized(event);
        logger.info("启动系统完成...");
    }

    public void contextDestroyed(ServletContextEvent event) {
        logger.info("系统开始关闭...");
        super.contextDestroyed(event);
        logger.info("系统成功关闭...");
    }

}
