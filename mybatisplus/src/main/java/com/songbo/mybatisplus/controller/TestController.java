package com.songbo.mybatisplus.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.songbo.mybatisplus.Service.UserService;
import com.songbo.mybatisplus.dao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author songbo
 * @Date 19-9-21 下午8:21
 **/
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public List<User> get(){
        return userService.getUserList();
    }
}
