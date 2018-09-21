package com.my.test.databuild;

import com.my.test.GoodsInfo;
import com.my.test.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by sunchengfei on 2018/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class Client {
    @Test
    public void test() throws ExecutionException, InterruptedException {
        List<String> moduleNames = new ArrayList<String>();
        moduleNames.add("goodsModule");
        moduleNames.add("userModule");

        DataBuilderManager dataBuilderManager = new DataBuilderManager();
        dataBuilderManager.execute(moduleNames);

        System.out.println(dataBuilderManager.getResult().get("goodsModule").get());
        System.out.println(dataBuilderManager.getResult().get("userModule").get());
    }

}
