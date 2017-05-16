package com.my.test.io;

import java.io.FileInputStream;
import java.nio.channels.FileChannel;

/**
 * Created by Chengfei.Sun on 17/02/27.
 */
public class NIOTest {
    public void readFileByIO() {
        FileInputStream inputStream = null;
        try {
            //以字节为单位，一次读取一个字节
            inputStream = new FileInputStream("C:\\Users\\ThinkPad\\Desktop\\iotest.txt");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                System.out.write(buffer, 0, len);
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readFileByNIO() {
        try {
            FileChannel inChannel = new FileInputStream("C:\\Users\\ThinkPad\\Desktop\\iotest.txt").getChannel();

        } catch (Exception e) {

        }

    }

    public static void main(String[] args) {
        NIOTest test = new NIOTest();
        test.readFileByIO();
    }
}
