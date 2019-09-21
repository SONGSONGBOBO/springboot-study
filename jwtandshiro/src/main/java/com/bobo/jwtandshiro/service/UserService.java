package com.bobo.jwtandshiro.service;


import com.bobo.jwtandshiro.dao.UserRepository;
import com.bobo.jwtandshiro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author songbo
 * @Date 19-6-4 下午8:34
 **/
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String name){
        return userRepository.findByUserName(name);
    }
    public User findUserById(int userId) {
        return userRepository.findByUserId(userId);
    }
}
