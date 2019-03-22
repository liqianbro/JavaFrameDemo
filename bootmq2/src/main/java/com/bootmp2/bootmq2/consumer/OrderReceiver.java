package com.bootmp2.bootmq2.consumer;

import com.alibaba.fastjson.JSONObject;
import com.bootmp2.bootmq2.pojo.Order;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderReceiver {


    /***
     * 接受消息
     * @param order
     * @param headers
     * @param channel
     */
    @RabbitListener(
            bindings =
            @QueueBinding(
                    value = @Queue(value = "order-queues", durable = "true"),
                    exchange = @Exchange(name = "oreder-exchange", durable = "true", type = "topic"),
                    key = "order.#"
            )
    )
    @RabbitHandler
    public void onOrderMessage(@Payload  String  s,
                               @Headers Map<String, Object> headers,
                               Channel channel) throws Exception {
        Order order=JSONObject.parseObject(s,Order.class);
        System.out.println("收到消息----------------------------------------");
        System.out.println("订单ID----------------------------------------+" + order.getMessageId());
        //Long ss = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        //ACK
        channel.basicAck(Long.parseLong(headers.get(AmqpHeaders.DELIVERY_TAG).toString()), false);
    }


}
