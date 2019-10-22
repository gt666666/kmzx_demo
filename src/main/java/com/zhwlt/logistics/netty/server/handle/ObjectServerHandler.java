package com.zhwlt.logistics.netty.server.handle;

import com.zhwlt.logistics.pojo.Member;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
public class ObjectServerHandler extends ChannelHandlerAdapter {
	/**
	 * 当接收到消息之后会自动调用此方法对消息内容进行处理；
	 * @param msg 接收到的消息，这个消息可能是各种类型的数据，本程序中使用的是ByteBuf
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		Member member = (Member) msg ; 	// 直接接收到Member对象
		System.err.println("｛服务器｝" + member); // 服务器端接收到内容
		Member echoMember = new Member() ; // 回应数据内容
		echoMember.setName("【ECHO】" + member.getName());
		echoMember.setAge(member.getAge() * 2);
		echoMember.setSalary(member.getSalary() * 10); 
		ctx.writeAndFlush(echoMember) ;
	} 
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.err.println("〖服务器端-生命周期〗服务器出现异常。");
		// ctx.close() ;
	}
}