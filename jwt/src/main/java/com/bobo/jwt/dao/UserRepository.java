package com.bobo.jwt.dao;

import com.bobo.jwt.entity.User;
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
