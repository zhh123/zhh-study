package com.zhh.assembly.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:zhh
 * @Date:Created in 11:39 2019/6/4 0004
 */
@RestController
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String hello(){
       System.out.println(" helloController hello");
       logger.info("helloController info");
       return "ok";
    }
}