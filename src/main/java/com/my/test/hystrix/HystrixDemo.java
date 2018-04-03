package com.my.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by sunchengfei on 2018/3/30.
 */
public class HystrixDemo extends HystrixCommand {
    public HystrixDemo() {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
    }

    @Override
    protected Object run() throws Exception {
        System.out.println("开始睡眠");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {

        }
        System.out.println("结束睡眠");
        //真实业务逻辑
        return null;
    }

    @Override
    protected Object getFallback() {
        System.out.println("执行熔断逻辑");
        return null;
    }

    public static void main(String[] args) {
        HystrixDemo hystrixDemo = new HystrixDemo();
        hystrixDemo.execute();

        System.out.println("main线程调用完毕");
    }
}
