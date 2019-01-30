package com.my.test.dao;

import com.my.test.GoodsInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by sunchengfei on 2019/1/30.
 */
@Repository
public class GoodsInfoService {
    public GoodsInfo queryById(int id) {
        System.out.println("GoodsInfoService query..");
        return null;
    }
}
