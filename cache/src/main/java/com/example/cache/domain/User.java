package com.example.cache.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author songbo
 * @Date 19-8-13 下午9:34
 **/
@Entity(name = "user")
@Data
public class User implements Serializable {

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
