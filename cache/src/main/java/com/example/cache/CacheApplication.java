package com.example.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class CacheApplication {
    /*
    * Redis 缓存设计及实现
    * redis和关系型数据库设计
    * 开启定时任务持久化存储到数据库
    * */
    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }

}
