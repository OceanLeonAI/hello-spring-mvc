package com.leon.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring Bean 工具类
 */
public class ServiceLocator implements ApplicationContextAware {

    public static ApplicationContext applicationContext;

    public ServiceLocator() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static Object getService(String key) {
        return applicationContext.getBean(key);
    }

    public static boolean containsBean(String key) {
        return applicationContext.containsBean(key);
    }

    public static ApplicationContext getAppContext() {
        return applicationContext;
    }

    public static <T> T getService(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

}
