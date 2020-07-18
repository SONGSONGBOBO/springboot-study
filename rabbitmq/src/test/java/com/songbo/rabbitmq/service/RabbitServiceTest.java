package com.songbo.rabbitmq.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RabbitServiceTest {
    @Autowired
    private RabbitProducersService rabbitService;
    @Test
    void send() {
        rabbitService.send(123456789L, 123456789L);
    }
}