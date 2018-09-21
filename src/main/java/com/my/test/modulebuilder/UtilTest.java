package com.my.test.modulebuilder;

import com.my.test.modulebuilder.vo.OrderBaseInfo;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by sunchengfei on 2018/4/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class UtilTest {
    @Resource
    private OrderBaseService orderBaseService;

    @Resource
    private OrderStockService orderStockService;
}
