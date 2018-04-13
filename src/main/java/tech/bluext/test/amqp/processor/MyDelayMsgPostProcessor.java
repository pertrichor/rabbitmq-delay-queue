package tech.bluext.test.amqp.processor;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;

/**
 * Description：延迟消息处理器
 *
 * @author : blue
 *         Created_Date : 2018-04-13 16:50
 */
public class MyDelayMsgPostProcessor implements MessagePostProcessor {

    // 消息延迟时间 单位:毫秒
    private static final String DELAY_TIME = "5000";

    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        MessageProperties messageProperties = message.getMessageProperties();
        messageProperties.setExpiration(DELAY_TIME);
        messageProperties.setContentEncoding("UTF-8");
        messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
        return message;
    }
}
