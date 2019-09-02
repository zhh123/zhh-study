package com.zhh.dynamicAgent.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.springframework.stereotype.Component;

/**
 * @Author:zhh
 * @Date:Created in 15:21 2019/6/11 0011
 * 写法2: 直接传入MethodInterceptor
 */
public class BookFacadeCglib2 {
    public  static <TProxyClass> TProxyClass create(Class<TProxyClass> classz, MethodInterceptor methodInterceptor){
        Enhancer enhancer = new Enhancer(); //创建加强器，用来创建动态代理类
        enhancer.setSuperclass(classz);  //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
        enhancer.setCallback(methodInterceptor);
        return (TProxyClass) enhancer.create();
    }

    public static  <TProxyClass> TProxyClass createProxy(Class<TProxyClass> classz){
        return create(classz,(obj,method,args,proxyMethod) -> {
            System.out.println("预处理—————— method:  "+method.getName());
            proxyMethod.invokeSuper(obj, args); //调用业务类（父类中）的方法
            System.out.println("调用后操作——————");
            return null;
        });

    }

}