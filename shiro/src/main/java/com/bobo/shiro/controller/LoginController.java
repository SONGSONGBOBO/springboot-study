package com.bobo.shiro.controller;

import com.bobo.shiro.bean.Result;
import com.bobo.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author songbo
 * @Date 19-5-2 下午9:36
 **/
@Controller
public class LoginController {


    @Autowired
    private UserService userService;

    @RequestMapping({"/","/login"})
    public String login(){
        return "login";
    }

    @RequestMapping("/dologin")
    @ResponseBody
    public Result dologin(String username, String userpwd){
        UsernamePasswordToken token = new UsernamePasswordToken(username,userpwd);
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
            return Result.ok();
        } catch (UnknownAccountException e) {
            return Result.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return Result.error(e.getMessage());
        } catch (LockedAccountException e) {
            return Result.error(e.getMessage());
        } catch (AuthenticationException e) {
            return Result.error("认证失败！");
        }

    }

    //@RequestMapping("/dologin")
    public void test(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

}
