package com.my.test.dao.mybatis;

import org.apache.ibatis.annotations.Param;

/**
 * 商品表DAO
 * Created by sunchengfei on 2017/8/21.
 */
public interface GoodsInfoDAO {
    /**
     * 减少库存
     * @param id
     * @param num
     * @return
     */
    int reduceStock(@Param("id") Integer id, @Param("num") Integer num);
}
