package com.zhh.dynamicAgent.cglib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author:zhh
 * @Date:Created in 15:35 2019/6/11 0011
 */
@SpringBootApplication
@ComponentScan({"com.zhh.dynamicAgent"})
public class CglibApplication {

    public static void main(String[] args){
        SpringApplication.run(CglibApplication.class,args);
    }

    @Bean
    public IBookFacade createIBookFacadeProxy(){
        System.out.println("初始化代理交给spring管理");
        return BookFacadeCglib2.createProxy(BookFacadeImpl.class);
    }
}