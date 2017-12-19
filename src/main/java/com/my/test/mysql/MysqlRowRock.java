package com.my.test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 利用行锁实现分布式锁
 * Created by sunchengfei on 2017/11/20.
 */
public class MysqlRowRock {
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://10.0.0.212:3308/dbwww_lock?user=lock_admin&password=lock123";
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 超时获取锁
     * @param lockID
     * @param timeOuts
     * @return
     * @throws InterruptedException
     */
    public boolean acquireByUpdate(String lockID, long timeOuts) throws InterruptedException, SQLException {

        String sql = "SELECT id from test_lock where id = ? for UPDATE ";
        long futureTime = System.currentTimeMillis() + timeOuts;
        long ranmain = timeOuts;
        long timerange = 500;
        connection.setAutoCommit(false);
        while (true) {
            CountDownLatch latch = new CountDownLatch(1);
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, lockID);
//                statement.setInt(2,1);
                statement.setLong(1, System.currentTimeMillis());
                boolean ifsucess = statement.execute();//如果成功，那么就是获取到了锁
                if (ifsucess)
                    return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            latch.await(timerange, TimeUnit.MILLISECONDS);
            ranmain = futureTime - System.currentTimeMillis();
            if (ranmain <= 0)
                break;
            if (ranmain < timerange) {
                timerange = ranmain;
            }
            continue;
        }
        return false;

    }

    /**
     * 释放锁
     * @param lockID
     * @return
     * @throws SQLException
     */
    public void unlockforUpdtate(String lockID) throws SQLException {
        connection.commit();
    }
}
