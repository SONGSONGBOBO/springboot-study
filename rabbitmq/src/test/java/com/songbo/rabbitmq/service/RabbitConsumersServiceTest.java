package com.songbo.rabbitmq.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RabbitConsumersServiceTest {

    @Autowired
    private RabbitConsumersService rabbitConsumersService;
    @Test
    void consume() {

        //System.out.println(rabbitConsumersService.consume());
    }
}