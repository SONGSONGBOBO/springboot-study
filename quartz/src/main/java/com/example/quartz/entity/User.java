package com.example.quartz.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author songbo
 * @Date 19-8-26 下午5:32
 **/
@Entity(name = "user")
@Setter
@Getter
@ToString
public class User implements Serializable {

    /*数据库保存语句
    * insert
    into
        user
        (user_name, user_pwd)
    values
        (?, ?)
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String userPwd;

    public User(){}

    public User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }
}

