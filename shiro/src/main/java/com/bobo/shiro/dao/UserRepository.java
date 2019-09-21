package com.bobo.shiro.dao;

import com.bobo.shiro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author songbo
 * @Date 19-5-2 下午9:56
 **/
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(int id);
    User findByUserName(String name);
}
