package com.zhh.dynamicAgent.cglibInterface;

/**
 * @Author:zhh
 * @Date:Created in 16:28 2019/6/11 0011
 */
public class TestInterfaceImpl implements TestInterface {
    @Override
    public String getHalloWorld() {
        System.out.println("hello world");
        return "hello";
    }
}