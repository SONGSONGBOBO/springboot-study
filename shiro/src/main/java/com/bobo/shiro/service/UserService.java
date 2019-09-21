package com.bobo.shiro.service;

import com.bobo.shiro.dao.UserRepository;
import com.bobo.shiro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author songbo
 * @Date 19-5-2 下午9:58
 **/
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User queryUserById(int id){

        return userRepository.findByUserId(id);
    }


}
