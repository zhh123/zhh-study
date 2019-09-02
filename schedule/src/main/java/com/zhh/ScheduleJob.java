package com.zhh;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @Author:zhh
 * @Date:Created in 15:49 2019/8/7 0007
 */
@Component
@EnableScheduling
public class ScheduleJob {

    String NAME;
    StringBuffer  stringBuffer;
    StringBuilder stringBuilder;

    @Scheduled(cron = "0 0/1 * * * *")
    public void executeJob(){
        System.out.println("清除session任务执行，时间："+new Timestamp(System.currentTimeMillis()));
    }
}