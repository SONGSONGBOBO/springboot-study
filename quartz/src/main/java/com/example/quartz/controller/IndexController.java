package com.example.quartz.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.quartz.dao.UserRepository;
import com.example.quartz.entity.User;
import com.example.quartz.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author songbo
 * @Date 19-8-26 下午7:03
 **/
@RestController
@RequestMapping("/user")
public class IndexController {

    @Autowired
    private TestService testService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/saveRedis")
    public JSONObject saveRedis(@RequestBody JSONObject jsonObject){
        User user = new User(jsonObject.getString("name"),jsonObject.getString("pwd"));
        testService.saveInRedis(user);
        return (JSONObject) new JSONObject().put("ok", "success");
    }

    @PostMapping("/test")
    public JSONObject test(@RequestBody JSONObject jsonObject){
        String user = jsonObject.getString("name");
        int i = userRepository.countAllByUserName(user);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("ok", i);
        return jsonObject1;
    }

}
