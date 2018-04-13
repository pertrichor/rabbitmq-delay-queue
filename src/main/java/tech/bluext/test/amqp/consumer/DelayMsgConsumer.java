package tech.bluext.test.amqp.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import tech.bluext.test.amqp.config.AmqpConfig;

/**
 * Description：延迟队列消息消费者
 *
 * @author : blue
 *         Created_Date : 2018-04-13 16:21
 */
@Component
@RabbitListener(queues = AmqpConfig.DELAY_HANDLER_QUEUE)
public class DelayMsgConsumer {

    @RabbitHandler
    public void consume(String msg) {
        System.out.println("接收到延迟队列消息 , 消息体：" + msg);
    }
}
