package com.songbo.rabbitmq.service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @ClassName RabbitConsumersService
 * @Description TODO
 * @Author songbo
 * @Date 2020/3/2 下午9:20
 **/
@Service
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
public class RabbitConsumersService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    private static String QUEUE = "sb.order.queue";

    @RabbitHandler
    public void consume(Message  message, Channel channel, @Headers Map<String,Object> headers) throws IOException {
        byte[] body = message.getBody();

        System.out.println("consume: " + message.toString());
        Long tag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
  /* @RabbitHandler
   public void consume(@Payload Map<String,Object> dataMap, Channel channel, @Headers Map<String,Object> headers) throws IOException {


       System.out.println("consume: " + dataMap);
       Long tag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
       channel.basicAck(tag, false);
   }*/
}
