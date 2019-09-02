package com.zhh.dynamicAgent.jdk.simple;

import java.sql.Timestamp;

/**
 * @Author:zhh
 * @Date:Created in 11:40 2019/6/11 0011
 * 静态代理
 * 缺点： 接口与代理类是1对1的，有多个接口需要代理，就需要新建多个代理类，繁琐，类爆炸
 * 解决方案：动态代理
 */
public class ManProxy implements IPerson {
    private IPerson target;

    public ManProxy setTarget(IPerson target){
        this.target = target;
        return this;
    }
    public IPerson getTarget(){
        return target;
    }

    @Override
    public void say() {
        if(target != null){
            System.out.println("man say invoke at : "+new Timestamp(System.currentTimeMillis()));
            target.say();
        }
    }
}