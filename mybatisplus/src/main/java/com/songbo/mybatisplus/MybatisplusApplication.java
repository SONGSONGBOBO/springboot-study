package com.songbo.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.songbo.mybatisplus.dao.mapper")
public class MybatisplusApplication {

    /*
    * 1.配置application.yml
    * 2.使用genneratorconfig逆向工程，生成dao和mapper，要修改xml中的mysql-connect的jar包位置
    * 3.右侧maven->plugins中的使用genneratorconfig生成dao和mapper
    * 4.程序入口设置扫描mapper
    *
    * */
    public static void main(String[] args) {
        SpringApplication.run(MybatisplusApplication.class, args);
    }

}
