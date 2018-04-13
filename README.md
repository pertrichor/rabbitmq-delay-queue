# rabbitmq-delay-queue

简介: 	这是一个SpringBoot集成rabbitMq , 并试图模拟延迟消息队列的示例.

		通过Message的expiration属性及Queue的x-dead-letter-exchange/x-dead-letter-routing-key参数 ,

		当Message过期成为dead-letter时 , 通过x-dead-letter-exchange指定的exchange值 , 以及x-dead-letter-routing-key指定的routing-key值 , 将dead-letter导入到正确的队列 ,

		最终被正确的Consumer消费.