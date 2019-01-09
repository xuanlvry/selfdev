package com.my.test.io;

import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

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

    /**
     * Creates new NBTest
     */
    public NIOTest() {
    }

    public void startServer() throws Exception {
        int channels = 0;
        int nKeys = 0;
        int currentSelector = 0;

        //使用Selector
        Selector selector = Selector.open();

        //建立Channel 并绑定到9000端口
        ServerSocketChannel ssc = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 9000);
        ssc.socket().bind(address);

        //使设定non-blocking的方式。
        ssc.configureBlocking(false);

        //向Selector注册Channel及我们有兴趣的事件
        SelectionKey s = ssc.register(selector, SelectionKey.OP_ACCEPT);

        printKeyInfo(s);

        while (true) {
            debug("NBTest: Starting select");

            //Selector通过select方法通知我们我们感兴趣的事件发生了。
            nKeys = selector.select();
            //如果有我们注册的事情发生了，它的传回值就会大于0
            if (nKeys > 0) {
                debug("NBTest: Number of keys after select operation: " + nKeys);

                //Selector传回一组SelectionKeys
                //我们从这些key中的channel()方法中取得我们刚刚注册的channel。
                Set selectedKeys = selector.selectedKeys();
                Iterator i = selectedKeys.iterator();
                while (i.hasNext()) {
                    s = (SelectionKey) i.next();
                    printKeyInfo(s);
                    debug("NBTest: Nr Keys in selector: " + selector.keys().size());

                    //一个key被处理完成后，就都被从就绪关键字（ready keys）列表中除去
                    i.remove();
                    if (s.isAcceptable()) {
                        // 从channel()中取得我们刚刚注册的channel。
                        Socket socket = ((ServerSocketChannel) s.channel()).accept().socket();
                        SocketChannel sc = socket.getChannel();

                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        System.out.println(++channels);
                    } else {
                        debug("NBTest: Channel not acceptable");
                    }
                }
            } else {
                debug("NBTest: Select finished without any keys.");
            }

        }

    }


    private static void debug(String s) {
        System.out.println(s);
    }


    private static void printKeyInfo(SelectionKey sk) {
        String s = new String();

        s = "Att: " + (sk.attachment() == null ? "no" : "yes");
        s += ", Read: " + sk.isReadable();
        s += ", Acpt: " + sk.isAcceptable();
        s += ", Cnct: " + sk.isConnectable();
        s += ", Wrt: " + sk.isWritable();
        s += ", Valid: " + sk.isValid();
        s += ", Ops: " + sk.interestOps();
        debug(s);
    }

    public static void main(String[] args) {
        NIOTest nbTest = new NIOTest();
        try {
            nbTest.startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
