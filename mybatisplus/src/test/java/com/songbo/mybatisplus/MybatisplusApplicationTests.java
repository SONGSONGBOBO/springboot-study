package com.songbo.mybatisplus;

import com.songbo.mybatisplus.dao.domain.Son;
import com.songbo.mybatisplus.dao.domain.User;
import com.songbo.mybatisplus.dao.mapper.SonMapper;
import com.songbo.mybatisplus.dao.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisplusApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Resource
    private SonMapper sonMapper;
    @Test
    public void contextLoads() {

        User user = userMapper.getSonsByUserId(7);
        System.out.println(user.toString());

        List<Son> sons = userMapper.getSonById(7);
        for (Son son : sons){
            System.out.println(son.toString());
        }

        List<User> users = userMapper.getUserList();
        System.out.println(users.toString());

        User user1 = new User();
        user1.setUserName("12345");
        user1.setUserPwd("222222");
        Son son = new Son();
        son.setSonName("444444");
        son.setSonUserId(7);
        System.out.println(sonMapper.insert(son));
    }


}
