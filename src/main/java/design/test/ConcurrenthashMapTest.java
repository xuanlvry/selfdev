package design.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Chengfei.Sun on 17/02/17.
 */
public class ConcurrenthashMapTest implements Runnable {
    private ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();

    private CyclicBarrier barrier;

    public ConcurrenthashMapTest(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        try {
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("线程开始执行" + System.currentTimeMillis());
        String result = concurrentHashMap.put("cardNo454", "123");
        if (result != null) {
            System.out.println("result:" + result + "不为空，返回");
            return;
        }
        System.out.println("开始执行逻辑" + result);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        concurrentHashMap.remove("cardNo454");
    }

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(20);
        ConcurrenthashMapTest test = new ConcurrenthashMapTest(barrier);

        for (int i = 0; i < 20; i++) {
            new Thread(test).start();
        }
    }
}
