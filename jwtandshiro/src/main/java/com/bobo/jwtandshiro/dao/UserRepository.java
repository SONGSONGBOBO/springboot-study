package com.bobo.jwtandshiro.dao;

import com.bobo.jwtandshiro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author songbo
 * @Date 19-6-2 下午10:09
 **/
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String name);
    User findByUserId(int id);
}
