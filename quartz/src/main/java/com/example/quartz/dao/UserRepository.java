package com.example.quartz.dao;


import com.example.quartz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @ClassName UserRespository
 * @Description TODO
 * @Author songbo
 * @Date 19-8-13 下午9:35
 **/

public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByUserId(int id);

    User getUserByUserName(String name);


    int countAllByUserName(String name);
}
