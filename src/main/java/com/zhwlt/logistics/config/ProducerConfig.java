package com.zhwlt.logistics.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {
	public static final String EXCHANGE = "com.zhwlt.exchange"; // 交换空间名称
	public static final String ROUTINGKEY = "com.zhwlt.routingkey"; // 设置路由key
	public static final String QUEUE_NAME = "com.zhwlt.queue"; // 队列名称
	@Bean
	public Binding bindingExchangeQueue(DirectExchange exchange,Queue queue) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY) ;
	}

	/**parameter1：交换空间名字
	 * parameter2：持久化保存
	 * parameter3：自动删除，如果该队列没有任何订阅的消费者的话，该队列会被自动删除。这种队列适用于临时队列
	 * @return
	 */
	@Bean
	public DirectExchange getDirectExchange() { // 使用直连的模式

		return new DirectExchange(EXCHANGE, true, true);
	}
	@Bean
	public Queue queue() { // 要创建的队列信息
		return new Queue(QUEUE_NAME);
	}
}