package com.sun.dev.entity;

import lombok.Data;

/**
 * 商品
 * Created by sunchengfei on 2017/8/21.
 */
@Data
public class GoodsInfo {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 剩余库存
     */
    private Integer remainNum;

    /**
     * 商品名称
     */
    private String goodsName;
}
