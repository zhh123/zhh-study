package com.zhh.serverInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author:zhh
 * @Date:Created in 11:34 2019/6/3 0003
 */
@Component
public class ServerStart implements ApplicationRunner {

    @Autowired
    GetComInfoUtil getComInfoUtil;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("java.library.path: "+System.getProperty("java.library.path"));
        getComInfoUtil.memory();
        getComInfoUtil.getCpu();
        getComInfoUtil.getPerCpuInfo();
    }
}