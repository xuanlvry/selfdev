package com.my.test.dbLock;

import com.my.test.thread.MyThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Chengfei.Sun on 17/05/03.
 */
public class DBLockServiceRunnable implements Runnable {
    Logger logger = LoggerFactory.getLogger(MyThread.class);

    private String threadName;

    private IAmountService amountServiceImpl;

    public DBLockServiceRunnable(String threadName, IAmountService amountService) {
        this.threadName = threadName;
        this.amountServiceImpl = amountService;
    }

    public void run() {
        this.amountServiceImpl.transfer(threadName);
    }
}
