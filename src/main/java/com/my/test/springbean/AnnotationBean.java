package com.my.test.springbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Created by sunchengfei on 2019/2/13.
 */
//@Component
//@Lazy(value = false)
public class AnnotationBean implements DisposableBean,
        BeanFactoryPostProcessor, BeanPostProcessor, ApplicationContextAware, InitializingBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAA-destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAA-afterPropertiesSet");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAA-postProcessBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAA-setApplicationContext");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAA-postProcessBeforeInitialization：" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAA-postProcessAfterInitialization：" + beanName);
        return bean;
    }
}
