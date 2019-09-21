package com.example.quartz.utils;

import com.example.quartz.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName UserQuartz
 * @Description TODO
 * @Author songbo
 * @Date 19-8-26 下午6:32
 **/
@Slf4j
public class UserQuartz implements Job {

    @Autowired
    private TestService testService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.warn("userService", new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date()));
        testService.save();
    }
}
