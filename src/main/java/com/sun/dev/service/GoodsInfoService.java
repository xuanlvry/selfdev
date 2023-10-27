package com.sun.dev.service;

import com.sun.dev.dao.mybatis.GoodsInfoDAO;
import com.sun.dev.entity.GoodsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sunchengfei on 2019/1/30.
 */
@Service
public class GoodsInfoService {
    @Autowired
    private GoodsInfoDAO goodsInfoDAO;

    public GoodsInfo queryById(int id) {
        return goodsInfoDAO.selectById(id);
    }

    public void reduceStock(int id, int num) {
        goodsInfoDAO.reduceStock(id, num);
    }
}
