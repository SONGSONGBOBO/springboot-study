package com.bobo.jwt.service;

import com.bobo.jwt.dao.UserRepository;
import com.bobo.jwt.entity.User;
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

    public User findByUsername(User user){
        return userRepository.findByUserName(user.getUserName());
    }
    public User findUserById(int userId) {
        return userRepository.findByUserId(userId);
    }
}
