package com.songbo.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName RabbitService
 * @Description TODO
 * @Author songbo
 * @Date 2020/3/2 上午2:45
 **/
@Service
public class RabbitProducersService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String send(Long userId, Long seckillId) {
        String orderNo = UUID.randomUUID().toString();

        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("orderNo",orderNo);
        dataMap.put("userId",userId);
        dataMap.put("seckillId",seckillId);
        rabbitTemplate.convertAndSend("TestDirectExchange","TestDirectRouting",dataMap);
        return orderNo;
    }
}
