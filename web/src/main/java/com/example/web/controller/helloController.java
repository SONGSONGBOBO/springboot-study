package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName helloController
 * @Description TODO
 * @Author songbo
 * @Date 19-3-9 下午4:26
 **/
@RestController
public class helloController {
    @RequestMapping("/hello")
    public String hello(){
        return "index";
    }
}
