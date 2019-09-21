package com.example.quartz.utils;



import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @ClassName Quartz
 * @Description TODO
 * @Author songbo
 * @Date 19-8-26 下午5:36
 **/
public class QuartzTest implements Job {

    /**
     * Quartz requires a public empty constructor so that the
     * scheduler can instantiate the class whenever it needs.
     */
    public QuartzTest() {
    }

    /**
     * 该方法实现需要执行的任务
     */
    @SuppressWarnings("unchecked")
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 从 context 中获取 instName, groupName 以及 dataMap
        String instName = context.getJobDetail().getKey().getName();
        String groupName = context.getJobDetail().getKey().getGroup();
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        // 从 dataMap 中获取 myDescription, myValue 以及 myArray
        String myDescription = dataMap.getString("myDescription");
        int myValue = dataMap.getInt("myValue");
        List<String> myArray = (List<String>) dataMap.get("myArray");
        System.out.println("---> Instance = " + instName + ", group = " + groupName
                + ", description = " + myDescription + ", value =" + myValue
                + ", array item[0] = " + myArray.get(0));
        System.out.println("Runtime: " + new Date().toString() + " <---");
    }

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        // 通过 schedulerFactory 获取一个调度器
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        // 创建 jobDetail 实例，绑定 Job 实现类
        // 指明 job 的名称，所在组的名称，以及绑定 job 类
        JobDetail job = JobBuilder.newJob(QuartzTest.class).withIdentity("job1", "group1").build();

        // 定义调度触发规则

        // SimpleTrigger，从当前时间的下 1 秒开始，每隔 1 秒执行 1 次，重复执行 2 次
        /*Trigger trigger = TriggerBuilder.newTrigger()
                // 指明 trigger 的 name 和 group
                .withIdentity("trigger1", "group1")
                // 从当前时间的下 1 秒开始执行，默认为立即开始执行（.startNow()）
                .startAt(DateBuilder.evenSecondDate(new Date()))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1) // 每隔 1 秒执行 1 次
                        .withRepeatCount(2)) // 重复执行 2 次，一共执行 3 次
                .build();*/


        // corn 表达式，先立即执行一次，然后每隔 5 秒执行 1 次
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                .build();

        // 初始化参数传递到 job
        job.getJobDataMap().put("myDescription", "Hello Quartz");
        job.getJobDataMap().put("myValue", 1990);
        List<String> list = new ArrayList<>();
        list.add("firstItem");
        job.getJobDataMap().put("myArray", list);

        // 把作业和触发器注册到任务调度中
        sched.scheduleJob(job, trigger);

        // 启动计划程序（实际上直到调度器已经启动才会开始运行）
        sched.start();

        // 等待 10 秒，使我们的 job 有机会执行
        Thread.sleep(10000);

        // 等待作业执行完成时才关闭调度器
        sched.shutdown(true);
    }


}