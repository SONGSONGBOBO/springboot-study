package com.songbo.rabbitmq.controller;

import com.songbo.rabbitmq.service.RabbitProducersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName Test
 * @Description TODO
 * @Author songbo
 * @Date 2020/5/5 下午9:34
 **/
@Controller
public class TestController {

    @Autowired
    private RabbitProducersService rabbitProducersService;
    @RequestMapping("/{id}/{sid}")
    public void test(@PathVariable long id, @PathVariable long sid) {
        rabbitProducersService.send(id, sid);
    }
}
