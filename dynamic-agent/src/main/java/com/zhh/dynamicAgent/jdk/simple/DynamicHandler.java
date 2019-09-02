package com.zhh.dynamicAgent.jdk.simple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Timestamp;

/**
 * @Author:zhh
 * @Date:Created in 11:44 2019/6/11 0011
 */
public class DynamicHandler implements InvocationHandler {

    private Object target;

    public DynamicHandler(Object vTarget){
        this.target = vTarget;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke start...");
        System.out.println("man say invoke at : "+new Timestamp(System.currentTimeMillis()));
        System.out.println("method name: "+method.getName());
        method.invoke(target,args);
        System.out.println("invoke end");
        return null;
    }
}