package com.zhwlt.logistics.netty.server.handle;

import com.zhwlt.logistics.netty.commons.DefaultNettyInfo;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
public class EchoServerHandler extends ChannelHandlerAdapter {
    /**
     * 当客户端连接到服务器端之后，需要有一个连接激活的方法，此方法可以直接向客户端发送消息
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.err.println("〖服务器端-生命周期〗通道连接激活。");
        // 1、对于发送的消息可以发送中文或者是一些标记（ok标记）
        // byte data [] = "【服务器端】连接通道已经建立成功，可以开始进行服务器通信处理".getBytes() ;
        // 2、Nio的处理本质是需要进行缓冲区的处理
        // ByteBuf message = Unpooled.buffer(data.length) ; // 创建一个缓冲区
        // 3、将数据写入到缓冲区之中
        // message.writeBytes(data) ; // 写入字节数据
        // 4、进行信息的发送，发送完成后刷新缓冲区
        // ctx.writeAndFlush(message) ; // 消息发送
    }
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.err.println("〖服务器端-生命周期〗通道注册。");
    }
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.err.println("〖服务器端-生命周期〗通道注销。");
    }
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.err.println("〖服务器端-生命周期〗通道关闭。");
    }
    /**
     * 当接收到消息之后会自动调用此方法对消息内容进行处理；
     * @param msg 接收到的消息，这个消息可能是各种类型的数据，本程序中使用的是ByteBuf
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String inputStr = (String) msg ; // 得到用户发送的数据
        System.err.println("{服务器}"+inputStr);
        String   echoContent="【ECHO】"+inputStr+ DefaultNettyInfo.SEPARATOR;//回应的消息内容
        ctx.writeAndFlush(echoContent);
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.err.println("〖服务器端-生命周期〗信息读取完毕。");
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println("〖服务器端-生命周期〗服务器出现异常。");
        // ctx.close() ;
    }
}
