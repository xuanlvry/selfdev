package com.my.test.databuild;

import com.my.test.GoodsInfo;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by sunchengfei on 2018/4/17.
 */
@Component
public class GoodsModule implements DataHandler {
    @Override
    public Object buiness(Map<String, Object> params) {
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setGoodsName("iphone");
        goodsInfo.setRemainNum(100);
        return goodsInfo;
    }
}
