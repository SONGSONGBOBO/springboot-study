package com.example.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

    /*
    * 在SpringBoot中一般使用RedisTemplate提供的方法来操作Redis。那么使用SpringBoot整合Redis
需要那些步骤呢。

1.JedisPoolConfig(这个是配置连接池)

2.RedisConnectionFactory（这个是配置连接信息，这里的RedisConnectionFactory是一个接口，
我们需要使用它的实现类，在SpringD Data Redis方案中提供了一下四种工厂模型）

JredisConnectionFactory
JedisConnectionFactory
LettuceConnectionFactory
SrpConnectionFactory
3.RedisTemplate
*/
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void set(){
        redisTemplate.opsForValue().set("test","hello word!");
        System.out.println(redisTemplate.opsForValue().get("test"));
    }


    @Test
    public void contextLoads() {
    }

}
