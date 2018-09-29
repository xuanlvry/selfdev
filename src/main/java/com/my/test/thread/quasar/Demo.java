package com.my.test.thread.quasar;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.fibers.Suspendable;
import co.paralleluniverse.strands.SuspendableRunnable;
import com.my.test.dao.mybatis.IUserMapper;
import com.my.test.springbean.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sunchengfei on 2018/9/21.
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class Demo {

    public void test(int cycleCount, int runType) throws Exception {
        log.error("模拟循环调用次数：{}，运行模式：{} ", cycleCount, (runType == 0 ? "串行" : runType == 1 ? "线程池" : runType == 2 ? "协程" : "--"));

        final AtomicInteger result = new AtomicInteger(0);
        long start = System.currentTimeMillis();
        if (runType == 0) {
            for (int i = 0; i < cycleCount; i++) {
                int invokeResult = mockInvoke();
                result.addAndGet(invokeResult);
            }

        } else if (runType == 1) {
            final CountDownLatch latch = new CountDownLatch(cycleCount);
            ExecutorService executorService = Executors.newFixedThreadPool(50);
            for (int i = 0; i < cycleCount; i++) {
                Thread t = new Thread() {
                    @Override
                    public void run() {
                        try {
                            int invokeResult = mockInvoke();
                            result.addAndGet(invokeResult);
                            latch.countDown();
                        } catch (Exception e) {
                            log.error(e.getMessage(), e);
                        }
                    }
                };
                executorService.execute(t);
            }
            executorService.shutdown();
            latch.await();

        } else if (runType == 2) {
            final CountDownLatch latch = new CountDownLatch(cycleCount);
            for (int i = 0; i < cycleCount; i++) {
                Fiber fiber = new Fiber<Void>("Caller", new SuspendableRunnable() {
                    @Override
                    public void run() throws SuspendExecution, InterruptedException {
                        int invokeResult = mockInvoke();
                        result.addAndGet(invokeResult);

                        latch.countDown();
                    }
                }).start();
            }
            latch.await();

        }
        long end = System.currentTimeMillis();
        log.error("耗时 = {}, 计算结果 = {}", (end - start), result.get());
    }

    // …………

    /**
     * 该方法在调用后，将会主动 sleep 一秒，然后返回数据；
     */
    @Suspendable
    private int mockInvoke() {
        IUserMapper userMapper = (IUserMapper) SpringContextUtil.getBean("IUserMapper");
        userMapper.selectUserByAccount("Xj74q31x97");
        return 1;
    }

    @Test
    public void test() throws Exception {
        Demo demo = new Demo();
        demo.test(10, 0);
        demo.test(10, 1);
        demo.test(20, 2);

        Thread.sleep(10000);
    }
}
