package com.example.cache.dao;

import com.example.cache.domain.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName UserRespository
 * @Description TODO
 * @Author songbo
 * @Date 19-8-13 下午9:35
 **/

public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByUserId(int id);

    User getUserByUserName(String name);
}
