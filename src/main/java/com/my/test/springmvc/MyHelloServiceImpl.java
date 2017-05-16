package com.my.test.springmvc;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by Chengfei.Sun on 17/05/05.
 */
@Service
public class MyHelloServiceImpl implements IMyHelloService {
    public void sayHi() {
        //System.out.println(1 / 0);
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hi AAAAAAAAAAAAAAAAAAAAAAAAAAA!");
    }
}
