package com.example.cache.service;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.example.cache.dao.UserRepository;
import com.example.cache.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

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
    private RedisTemplate<String,Object> redisTemplate;



    public User getUserByname(String name){
        /*RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setValueSerializer(new FastJsonRedisSerializer<>(Object.class));*/

        User user = (User) redisTemplate.opsForValue().get("users::"+name);

        //双重检测锁
        if (user == null){
            synchronized (this){
                user = (User) redisTemplate.opsForValue().get("users::"+name);
                if (user == null){
                    System.out.println("查询数据库---");
                    user = userRepository.getUserByUserName(name);
                    redisTemplate.opsForValue().set("users::"+name,user, Duration.ofHours(1));
                }else {
                    System.out.println("查询redis");
                }
            }
        } else {
            System.out.println("查询redis");
        }

        return user;
    }

    @Cacheable( key = "#name")
    public User getUser(String name){
        return userRepository.getUserByUserName(name);
    }


    @CachePut
    public User save(User user){
        return userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
}
