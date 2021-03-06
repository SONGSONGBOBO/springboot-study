package com.songbo.mybatisplus.Service;

import com.alibaba.fastjson.JSONObject;
import com.songbo.mybatisplus.dao.domain.Son;
import com.songbo.mybatisplus.dao.domain.User;
import com.songbo.mybatisplus.dao.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author songbo
 * @Date 19-9-21 下午8:04
 **/
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public List<User> getUserList(){

        List<User> users = userMapper.selectAll();
        return users;
    }
    public <T> T RPCRequest(String params, Class<T> tClass){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName",params);
        jsonObject.put("userPwd",params);
        T t = jsonObject.toJavaObject(tClass);
        return t;
    }

    public List<Son> getUserById(int id) throws InterruptedException {
        //Thread.sleep(1000);
        try {
            List<Son> sonById = userMapper.getSonById(id);
            return sonById;
        } catch (Exception e){
            return null;
        }

    }
}
