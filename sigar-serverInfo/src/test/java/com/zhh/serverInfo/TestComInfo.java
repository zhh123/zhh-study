package com.zhh.serverInfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:zhh
 * @Date:Created in 10:30 2019/6/3 0003
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestComInfo.class)
@ComponentScan({"com.zhh"})
public class TestComInfo {
    @Autowired
    GetComInfoUtil getComInfoUtil;

    @Test
    public void testCpu(){
        getComInfoUtil.memory();
        getComInfoUtil.getCpu();
    }
}