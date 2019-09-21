package com.bobo.jwt.controller;

import com.alibaba.fastjson.JSONObject;
import com.bobo.jwt.bean.ResultJson;
import com.bobo.jwt.service.TokenService;
import com.bobo.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName LoginControler
 * @Description TODO
 * @Author songbo
 * @Date 19-6-3 下午8:08
 **/
@Controller
public class LoginControler {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("/tologin")
    public String  tologin(@RequestParam String userName,
                        @RequestParam String userPwd){
        JSONObject jsonObject=new JSONObject();
        System.out.println(userName);
        String token = tokenService.getTokenForUser(userName,userPwd);
        jsonObject.put("token", token);
        //jsonObject.put("user", userForBase);
        System.out.println(jsonObject.size());
        System.out.println(token);
        return "login";
    }

    @RequestMapping("/auth")
    @ResponseBody
    public ResultJson auth(@RequestBody JSONObject jsonObject){
        String name = jsonObject.getString("userName");
        String userPwd = jsonObject.getString("userPwd");
        String remember = jsonObject.getString("remember");
        System.out.println(name+" "+userPwd+" "+remember);

        return ResultJson.resultJsonForLogin(name,jsonObject);
    }
}
