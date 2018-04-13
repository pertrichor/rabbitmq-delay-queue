package tech.bluext.test.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.bluext.test.amqp.config.AmqpConfig;
import tech.bluext.test.amqp.processor.MyDelayMsgPostProcessor;

/**
 * Description：测试延迟队列消息控制器
 *
 * @author : blue
 *         Created_Date : 2018-04-13 16:15
 */
@RestController
@RequestMapping("mq")
public class DelayMsgController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("send/{msg}")
    public String send(@PathVariable("msg") String msg) {
        try {
            System.out.println("发送延迟队列消息：" + msg);
            amqpTemplate.convertAndSend(AmqpConfig.DELAY_EXCHANGE, AmqpConfig.DELAY_ROUTING_KEY, msg, new MyDelayMsgPostProcessor());

            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "发送失败";
        }
    }
}
