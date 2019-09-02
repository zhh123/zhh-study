package com.zhh.serverInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Author:zhh
 * @Date:Created in 10:16 2019/6/3 0003
 */
@SpringBootApplication
@ComponentScan({"com.zhh"})
public class SigarApplication {

    public static void main(String[] args){
        SpringApplication.run(SigarApplication.class,args);
    }
}