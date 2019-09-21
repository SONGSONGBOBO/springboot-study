package com.bobo.jwtandshiro.controller;

import com.alibaba.fastjson.JSONObject;
import com.bobo.jwtandshiro.bean.ResultJson;
import com.bobo.jwtandshiro.service.TokenService;
import com.bobo.jwtandshiro.service.UserService;
import com.bobo.jwtandshiro.utils.JWTUtil;
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

    @RequestMapping("/auth/login")
    @ResponseBody
    public ResultJson auth(@RequestBody JSONObject jsonObject){
        String name = jsonObject.getString("username");
        String userPwd = jsonObject.getString("password");
        String remember = jsonObject.getString("remember");
        System.out.println(name+" "+userPwd+" "+remember);
        return null;
        //return new ResultJson(200,name, JWTUtil.sign(name,userPwd));
    }
}
