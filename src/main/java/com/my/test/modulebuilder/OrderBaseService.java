package com.my.test.modulebuilder;

import com.my.test.modulebuilder.vo.OrderBaseInfo;
import org.springframework.stereotype.Component;

/**
 * Created by sunchengfei on 2018/4/3.
 */
@Component
public class OrderBaseService {
    public OrderBaseInfo execute(String title, String picUrl) {
        OrderBaseInfo orderBaseInfo = new OrderBaseInfo();
        orderBaseInfo.setTitle(title);
        orderBaseInfo.setPicUrl(picUrl);
        return orderBaseInfo;
    }
}
