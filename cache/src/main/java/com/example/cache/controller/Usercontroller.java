package com.example.cache.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.cache.domain.User;
import com.example.cache.service.TestService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName controller
 * @Description TODO
 * @Author songbo
 * @Date 19-8-13 下午9:58
 **/
@RestController
@RequestMapping("/user")
public class Usercontroller{

    @Autowired
    private TestService testService;

    @PostMapping("/getUser")
    public JSONObject getUser(@RequestParam("name") String name){
        User user = testService.getUserByname(name);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user",user);
        return jsonObject;
    }

    @PostMapping("/getUser1")
    public JSONObject getUser1(@RequestParam("name") String name){
        User user = testService.getUser(name);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user",user);
        return jsonObject;
    }


    @PostMapping("/getByName")
    public JSONObject getUserById(@RequestParam("name") String name){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                testService.getUserByname("aa");
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(runnable);
        }
        JSONObject jsonpObject = new JSONObject();
        jsonpObject.put("user",testService.getUserByname(name));
        return jsonpObject;
    }

    @GetMapping("/getAll")
    public JSONObject getAll(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user",testService.getAll());
        return jsonObject;
    }

}
