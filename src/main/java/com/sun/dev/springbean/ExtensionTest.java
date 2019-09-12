package com.sun.dev.springbean;

import com.sun.dev.service.UserInfo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;

/**
 * Created by sunchengfei on 2019-05-06.
 */
public class ExtensionTest implements InitializingBean, DisposableBean, BeanPostProcessor, BeanFactoryPostProcessor, BeanDefinitionRegistryPostProcessor, BeanNameAware, BeanFactoryAware, ApplicationContextAware {
    private String attri = "hello";

    private UserInfo userInfo = new UserInfo();

    public ExtensionTest() {
        System.out.println("ExtensionTest构造");
    }

    static {
        System.out.println("ExtensionTest静态初始化方法");
    }

    public void init() {
        System.out.println("ExtensionTest指定init方法");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("ExtensionTest postConstruct");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("postProcessBeanDefinitionRegistry");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("postProcessAfterInitialization");
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware：setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware：setBeanName");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware：setApplicationContext");
    }
}
