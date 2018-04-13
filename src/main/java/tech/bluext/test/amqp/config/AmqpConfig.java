package tech.bluext.test.amqp.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Description：RabbitMQ配置类
 *
 * @author : blue
 *         Created_Date : 2017-01-26 9:56
 */
@Configuration
public class AmqpConfig {

    // 延迟消息缓存exchange
    public static final String DELAY_EXCHANGE = "delay-exchange";
    // 延迟消息缓存routingKey
    public static final String DELAY_ROUTING_KEY = "delay-routing-key";
    // 延迟消息缓存queue
    public static final String DELAY_QUEUE = "delay-queue";
    // 延迟消息处理exchange
    public static final String DELAY_HANDLER_EXCHANGE = "delay-handler-exchange";
    // 延迟消息处理routingKey
    public static final String DELAY_HANDLER_ROUTING_KEY = "delay-handler-routing-key";
    // 延迟消息处理queue
    public static final String DELAY_HANDLER_QUEUE = "delay-handler-queue";

    // 定义延迟消息交换机
    @Bean
    TopicExchange delayExchange() {
        return new TopicExchange(DELAY_EXCHANGE, true, false);
    }

    // 定义延迟消息队列
    @Bean
    public Queue delayQueue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", DELAY_HANDLER_EXCHANGE);
        args.put("x-dead-letter-routing-key", DELAY_HANDLER_ROUTING_KEY);
        return new Queue(DELAY_QUEUE, true, false, false, args);
    }

    // 绑定延迟消息队列和延迟消息交换机
    @Bean
    public Binding delayBinding(Queue delayQueue, TopicExchange delayExchange) {
        return BindingBuilder.bind(delayQueue).to(delayExchange).with(DELAY_ROUTING_KEY);
    }

    // 定义延迟消息处理交换机
    @Bean
    public TopicExchange delayHandlerExchange() {
        return new TopicExchange(DELAY_HANDLER_EXCHANGE, true, false);
    }

    // 定义延迟消息处理队列
    @Bean
    public Queue delayHandlerQueue() {
        return new Queue(DELAY_HANDLER_QUEUE, true, false, false);
    }

    // 绑定延迟消息处理队列和延迟消息处理交换机
    @Bean
    public Binding delayHandlerBinding(Queue delayHandlerQueue, TopicExchange delayHandlerExchange) {
        return BindingBuilder.bind(delayHandlerQueue).to(delayHandlerExchange).with(DELAY_HANDLER_ROUTING_KEY);
    }

}