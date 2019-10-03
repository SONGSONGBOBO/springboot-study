package com.songbo.mybatisplus.Service;

import com.songbo.mybatisplus.dao.domain.User;
import com.songbo.mybatisplus.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author songbo
 * @Date 19-9-21 下午8:04
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserList(){
        List<User> users = userMapper.selectAll();
        return users;
    }

}
