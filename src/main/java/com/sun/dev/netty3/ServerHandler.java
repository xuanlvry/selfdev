package com.sun.dev.netty3;

import org.jboss.netty.channel.*;

/**
 * Created by sunchengfei on 2019/3/6.
 */
public class ServerHandler extends SimpleChannelHandler {
    // 接收消息
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
            throws Exception {

        // 接收消息
//        ChannelBuffer messageReceived = (ChannelBuffer) e.getMessage();
//        String messageRecStr = new String(messageReceived.array());
//        System.out.println(messageRecStr);
//
//        // 回写数据
//        if ("hello".equals(messageRecStr)) {
//            ChannelBuffer sendBack = ChannelBuffers.copiedBuffer("hi"
//                    .getBytes());
//            ctx.getChannel().write(sendBack);
//        } else {
//            ChannelBuffer sendBack = ChannelBuffers
//                    .copiedBuffer("I don't know what you said".getBytes());
//            ctx.getChannel().write(sendBack);
//        }
//        super.messageReceived(ctx, e);

        // 接收消息
        String messageReceived = (String) e.getMessage();
        System.out.println(messageReceived);

        System.out.println("server-AI正在解析...");
        Thread.sleep(5000);
        // 回写数据
        if ("hello".equals(messageReceived))
            ctx.getChannel().write("hi");
        else
            ctx.getChannel().write("I don't know what you said");
        super.messageReceived(ctx, e);
    }

    // 捕获异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
            throws Exception {
        System.out.println("exceptionCaught");
        super.exceptionCaught(ctx, e);
    }

    // 新连接
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
            throws Exception {
        System.out.println("channelConnected");
        super.channelConnected(ctx, e);
    }

    // 必须是链接已经建立，关闭通道时才会触发
    @Override
    public void channelDisconnected(ChannelHandlerContext ctx,
                                    ChannelStateEvent e) throws Exception {
        System.out.println("channelDisconnected");
        super.channelDisconnected(ctx, e);
    }

    // channel关闭的时候触发（见客户端模拟）
    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
            throws Exception {
        System.out.println("channelClosed");
        super.channelClosed(ctx, e);
    }
}
