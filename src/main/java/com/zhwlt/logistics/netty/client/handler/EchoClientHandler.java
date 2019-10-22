package com.zhwlt.logistics.netty.client.handler;

import com.zhwlt.logistics.netty.commons.DefaultNettyInfo;
import com.zhwlt.logistics.util.InputUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class EchoClientHandler extends ChannelHandlerAdapter {
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {// 客户端的连接激活
		String  inputStr=InputUtil.getString("请输入要发送的信息：");
		for (int x =0;x<500;x++){
		ctx.writeAndFlush(inputStr+"-"+x+ DefaultNettyInfo.SEPARATOR) ;
		}
	}
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String content = (String) msg ; // // 接收数据
		System.out.println("{客户端}"+content);   //服务器端的回应信息
	}
}