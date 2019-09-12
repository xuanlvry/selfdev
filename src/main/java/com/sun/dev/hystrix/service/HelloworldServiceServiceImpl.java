package com.sun.dev.hystrix.service;

import com.sun.dev.service.UserInfo;
import com.sun.dev.hystrix.IHelloworldService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * Created by sunchengfei on 2018/3/28.
 */
@Service
public class HelloworldServiceServiceImpl implements IHelloworldService {
    @HystrixCommand(groupKey = "helloworld",    //group标识，一个group使用一个线程池
            commandKey = "updateUser",          //command标志
            fallbackMethod = "fallBack",        //指定异常方法名。方法参数及返回类型，需要和业务方法保持一致
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),//10ms超时，超时执行fallback
                    @HystrixProperty(name = "metrics.rollingPercentile.timeInMilliseconds", value = "1000"),    //统计窗口时长，用于监控和熔断器。
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),              //判断熔断的最少请求数，默认是10；只有在一个统计窗口内处理的请求数量达到这个阈值，才会进行熔断与否的判断
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "5")             //判断熔断的阈值，默认值50，表示在一个统计窗口内有50%的请求处理失败，会触发熔断
            },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "10"),
//                    @HystrixProperty(name = "maxQueueSize", value = "100")
            }
    )
    @Override
    public UserInfo updateUser(UserInfo userInfo) {
        System.out.println(Thread.currentThread().getName() + "进入updateUser");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return userInfo;
    }

    @Override
    public UserInfo selectUser(UserInfo userInfo) {
        return this.updateUser(userInfo);
    }

    public UserInfo fallBack(UserInfo userInfo) {
        System.out.println(Thread.currentThread().getName() + "调用fallback");
        return null;
    }
}