package com.example.quartz.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.quartz.dao.UserRepository;
import com.example.quartz.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TsetService
 * @Description TODO
 * @Author songbo
 * @Date 19-8-13 下午9:18
 **/
@Service
@Slf4j
@CacheConfig(cacheNames = "users")
public class TestService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    //@Cacheable( key = "#name")
    public User getUser(String name){
        return userRepository.getUserByUserName(name);
    }

    //从redis取数据定期存储到mysql
    //返回的是JSONObject
    public void save(){
        Cursor<Map.Entry<Object, Object>> cursor = redisTemplate.opsForHash().scan("users::user", ScanOptions.NONE);
        List<User> list = new ArrayList<>();
        while (cursor.hasNext()) {
            /*Map.Entry<Object, Object> entry = cursor.next();
            String key = (String) entry.getKey();
            //分离出 likedUserId，likedPostId
            String[] split = key.split("::");
            String likedUserId = split[0];
            String likedPostId = split[1];
            Integer value = (Integer) entry.getValue();*/
            Map.Entry<Object, Object> entry = cursor.next();
            String key = (String) entry.getKey();

            /*JSONObject jsonObject = (JSONObject) entry.getValue();
            String name = jsonObject.getString("userName");
            String pwd = jsonObject.getString("userPwd");
            User user = new User(name, pwd);*/
            JSONObject jsonObject = (JSONObject) entry.getValue();
            User user = JSON.toJavaObject(jsonObject,User.class);
            //list.add(user);
            //User user = (User) entry.getValue();

            try {
                userRepository.save(user);
            } catch (Exception e){
                log.error("err",e);
            }

            //从 Redis 中删除
            redisTemplate.opsForHash().delete("users::user", key);
        }
    }

    public void saveInRedis(User user){
        //redisTemplate.opsForValue().set("users::"+user.getUserName(),user);

        //redisTemplate.opsForHash().put("users::user","users::"+user.getUserName(),user);
        //System.out.println(redisTemplate.opsForHash().size("users::user"));
        //redisTemplate.opsForHash().put("users::size","size::",redisTemplate.opsForHash().size("users::user"));

        /*测试scan模糊查询*/
       /* redisTemplate.opsForHash().put("users::user","users::"+user.getUserName()+"::"+user.getUserId(),user);
        ScanOptions.ScanOptionsBuilder scanOptions = new ScanOptions.ScanOptionsBuilder();
        int articleId = 111;
        scanOptions.match("*"+articleId+"*");
        Cursor<Map.Entry<Object, Object>> i = redisTemplate.opsForHash().scan("users::user",scanOptions.build());
        if (i.hasNext()){
            System.out.println(i.next().getKey());
        }*/
        //System.out.println(i.next());
        //redisTemplate.opsForValue().set("users::size",2);
        Integer i = (Integer) redisTemplate.opsForValue().get("users::size");
        //String j = (String) redisTemplate.opsForValue().get("users::size");
        /*if (j == null){
            System.out.println("null");
        }*/
        System.out.println(i);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
}
