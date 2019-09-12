package com.sun.dev.io.reactor;

import java.io.IOException;
import java.nio.channels.SocketChannel;

/**
 * Reactor 将I/O事件发派给对应的Handler
 * Acceptor 处理客户端连接请求
 * Handlers 执行非阻塞读/写
 *
 * Created by sunchengfei on 2018/12/29.
 */
public class Acceptor implements Runnable {
    private Reactor reactor;

    public Acceptor(Reactor reactor) {
        this.reactor = reactor;
    }

    @Override
    public void run() {
        try {
            SocketChannel socketChannel = reactor.serverSocketChannel.accept();
            if (socketChannel != null) {
                //调用Handler来处理channel
                new SocketReadHandler(reactor.selector, socketChannel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
