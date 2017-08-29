package com.my.test;

import com.my.test.mybatis.GoodsInfoDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by sunchengfei on 2017/8/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class GoodsInfoTest {
    @Resource
    private GoodsInfoDAO goodsInfoDAO;

    @Test
    public void reduceTest() throws InterruptedException {
        //减少库存，线程模拟并发
        int threadCount = 400;
        CyclicBarrier barrier = new CyclicBarrier(threadCount);

        for (int i = 0; i < threadCount; i++) {
            new Thread(new ThreadGoodsInfo(goodsInfoDAO, barrier)).start();
        }

        Thread.sleep(10000);
    }

    private class ThreadGoodsInfo implements Runnable {
        private GoodsInfoDAO goodsInfoDAO;
        private CyclicBarrier barrier;

        public ThreadGoodsInfo(GoodsInfoDAO goodsInfoDAO, CyclicBarrier barrier) {
            this.goodsInfoDAO = goodsInfoDAO;
            this.barrier = barrier;
        }

        public void run() {
            try {
                this.barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            int count = this.goodsInfoDAO.reduceStock(1, 1);
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + "购买了商品，购买数量：" + 1);
            }
        }
    }

}
