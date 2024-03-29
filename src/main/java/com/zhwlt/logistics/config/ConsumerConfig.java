package com.zhwlt.logistics.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {
	public static final String EXCHANGE = "com.zhwlt.exchange"; // 交换空间名称
	public static final String ROUTINGKEY = "com.zhwlt.routingkey"; // 设置路由key
	public static final String QUEUE_NAME = "mldcomn.zhwlt.queue"; // 队列名称
//	@Bean
//	public Binding bindingExchangeQueue(DirectExchange exchange,Queue queue) {
//		return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY) ;
//	}
//	@Bean
//	public DirectExchange getDirectExchange() { // 使用直连的模式
//		return new DirectExchange(EXCHANGE, true, true);
//	}
//	@Bean
//	public Queue queue() { // 要创建的队列信息
//		return new Queue(QUEUE_NAME);
//	}
}