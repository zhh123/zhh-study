package com.zhh.dynamicAgent.cglibInterface;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author:zhh
 * @Date:Created in 16:29 2019/6/11 0011
 */
public class TestCGLIb implements MethodInterceptor {
    public Object getInstance(Class claxx) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(claxx);
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        methodProxy.invokeSuper(o,objects);
        return method.getName();
    }

}