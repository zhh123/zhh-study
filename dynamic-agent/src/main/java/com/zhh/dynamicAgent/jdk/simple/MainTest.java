package com.zhh.dynamicAgent.jdk.simple;

import java.lang.reflect.Proxy;

/**
 * @Author:zhh
 * @Date:Created in 13:48 2019/6/11 0011
 */
public class MainTest {
    public static void main(String[] args){
        Man man = new Man();
        DynamicHandler dynamicHandler = new DynamicHandler(man);
        IPerson iPerson = (IPerson) Proxy.newProxyInstance(man.getClass().getClassLoader(),man.getClass().getInterfaces(),dynamicHandler);
        //打印代理类的名字
        System.out.println("代理类: "+iPerson.getClass().getSimpleName());
        iPerson.say();
    }
}