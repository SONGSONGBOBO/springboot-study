package com.example.cache.service;

import com.example.cache.CacheApplication;
import com.example.cache.dao.UserRepository;
import com.example.cache.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CacheApplication.class)
public class TestServiceTest {

    @Autowired
    private TestService testService;

    /*@Before
    public void before() {
        testService.save(new User("aa", "11"));
    }*/

    @Test
    public void test() throws Exception{
        User user = testService.getUserByname("aa");
        System.out.println(user.getUserName());
    }

    @Test
    public void testExecute() throws Exception{

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                testService.getUserByname("aa");
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(runnable);
        }
    }

}