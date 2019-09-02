package com.zhh.dynamicAgent.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author:zhh
 * @Date:Created in 15:01 2019/6/11 0011
 * 写法1： 实现MethodInterceptor
 */
public class BookFacadeCglib implements MethodInterceptor {

    // 根据一个类型产生代理类，此方法不要求一定放在MethodInterceptor中
    public  Object createProxy(Class classz){
        Enhancer enhancer = new Enhancer(); //创建加强器，用来创建动态代理类
        enhancer.setSuperclass(classz);  //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
        enhancer.setCallback(this);
        return  enhancer.create();
    }

    //实现回调拦截
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("预处理——————");
        methodProxy.invokeSuper(o, args); //调用业务类（父类中）的方法
        System.out.println("调用后操作——————");
        return null;
    }
}