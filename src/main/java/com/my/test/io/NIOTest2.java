package com.my.test.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

/**
 * Created by sunchengfei on 2019/3/6.
 */
public class NIOTest2 {
    public static void main(String[] args) throws IOException {
        /** 创建通道channel1 */
        ServerSocketChannel channel1 = ServerSocketChannel.open();
        channel1.configureBlocking(false);
        channel1.bind(new InetSocketAddress(6777));

        /** 打开一个Selector */
        Selector selector = Selector.open();

        /** 通道channel1注册事件到Selector上 */
        channel1.register(selector, SelectionKey.OP_ACCEPT);
        /** 调用select()方法，阻塞获取到就绪通道 */
        while (selector.select() > 0) {
            /** 获取就绪SelectionKey */
            Set<SelectionKey> keys = selector.selectedKeys();

            //TODO：迭代处理selectedKeys
        }

    }
}
