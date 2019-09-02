package com.zhh.dynamicAgent.cglib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @Author:zhh
 * @Date:Created in 15:45 2019/6/11 0011
 */
@Component
public class ServerStart implements ApplicationRunner {

    @Autowired
    IBookFacade iBookFacade;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("server start");
        //双冒号提取函数方法
        Consumer<String> consumer = iBookFacade::addBook;
        consumer.accept("BookFacadeCglib2");
        //iBookFacade.addBook("BookFacadeCglib2");
    }
}