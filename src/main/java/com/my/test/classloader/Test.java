package com.my.test.classloader;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.UrlResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by sunchengfei on 2018/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class Test {
    @org.junit.Test
    public void printToString() {
        System.out.println(System.getProperty("java.class.path"));
        System.out.println("动态加载一个类");
    }

    @org.junit.Test
    public void loaderTest() {
        try {
            System.out.println("--------------------AAAAAAAAAAAAAAAAAAAA------------------");


            URL[] urls = {new URL("file:/Users/sunchengfei/project/classloadtest/target/classload-test-1.0-SNAPSHOT.jar"),
                    new URL("file:/Users/sunchengfei/project/classloadertest2/target/classloader-test2-1.0-SNAPSHOT.jar")};
            URLClassLoader myclassloader = new URLClassLoader(urls);

            Class xclass = myclassloader.loadClass("com.my.classload.ActionImpl");
            Object object = xclass.newInstance();

            //这里要指明method的结构，否则会报no such method
            Method xMethod = xclass.getMethod("work", String.class);
            Object result = xMethod.invoke(object, "haha");

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void loadSpringBeanTest() {
        try {

            ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                    "classpath*:/META-INF/application-classloader-context.xml");

            DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();

            String configurationFilePath = "jar:file:/Users/sunchengfei/project/classloadtest/target/classload-test-1.0-SNAPSHOT.jar!/META-INF/application-classloader-context.xml";

            URL url = new URL(configurationFilePath);

            UrlResource urlResource = new UrlResource(url);

            XmlBeanFactory xbf = new XmlBeanFactory(urlResource);

            String[] beanIds = xbf.getBeanDefinitionNames();

            for (String beanId : beanIds) {
                BeanDefinition bd = xbf.getMergedBeanDefinition(beanId);
                beanFactory.registerBeanDefinition(beanId, bd);
            }

            // 以下这行设置BeanFactory的ClassLoader，以加载外部类
            setBeanClassLoader(beanFactory);

            Object pluginBean = applicationContext.getBean("actionImpl");

            tryInvoke(pluginBean);

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    private static void setBeanClassLoader(DefaultListableBeanFactory beanFactory) throws MalformedURLException {
        URL[] urls = {new URL("file:/Users/sunchengfei/project/classloadtest/target/classload-test-1.0-SNAPSHOT.jar"),
                new URL("file:/Users/sunchengfei/project/classloadertest2/target/classloader-test2-1.0-SNAPSHOT.jar")};
        URLClassLoader myclassloader = new URLClassLoader(urls, Thread.currentThread().getContextClassLoader());
        //将当前的应用加载器设置为线程上下文加载器
        Thread.currentThread().setContextClassLoader(myclassloader);

        beanFactory.setBeanClassLoader(myclassloader);
    }

    private static void tryInvoke(Object bean) throws SecurityException,
            NoSuchMethodException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException {
        Class<?> paramTypes[] = new Class[0];
        Method method = bean.getClass().getDeclaredMethod("work", paramTypes);
        Object paramValues[] = new Object[0];
        method.invoke(bean, paramValues);

    }
}
