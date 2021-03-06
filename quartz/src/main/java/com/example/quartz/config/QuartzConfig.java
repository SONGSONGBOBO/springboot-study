package com.example.quartz.config;


import com.example.quartz.utils.UserQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName QuartzConfig
 * @Description TODO
 * @Author songbo
 * @Date 19-8-26 下午5:21
 **/
@Configuration
public class QuartzConfig {

    private static final String LIKE_TASK_IDENTITY = "UserQuartz";

    @Bean
    public JobDetail quartzDetail(){
        return JobBuilder.newJob(UserQuartz.class).withIdentity(LIKE_TASK_IDENTITY).storeDurably().build();
    }

    @Bean
    public Trigger quartzTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(300)  //设置时间周期单位秒
                //.withIntervalInHours(2)  //两个小时执行一次
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(quartzDetail())
                .withIdentity(LIKE_TASK_IDENTITY)
                .withSchedule(scheduleBuilder)
                .build();
    }
}


