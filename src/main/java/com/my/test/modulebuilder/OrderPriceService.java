package com.my.test.modulebuilder;

import com.my.test.modulebuilder.vo.OrderPriceInfo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by sunchengfei on 2018/4/3.
 */
@Component
public class OrderPriceService {
    public OrderPriceInfo execute(BigDecimal price, BigDecimal originPrice) {
        OrderPriceInfo priceInfo = new OrderPriceInfo();
        priceInfo.setPrice(price);
        priceInfo.setOriginPrice(originPrice);

        return priceInfo;
    }
}
