package com.zhh.curator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author:zhh
 * @Date:Created in 16:38 2019/7/31 0031
 */
@SpringBootApplication
@ComponentScan({"com"})
public class CuratorApplication {
    public static void main(String args[]){
        SpringApplication.run(CuratorApplication.class,args);
    }
}