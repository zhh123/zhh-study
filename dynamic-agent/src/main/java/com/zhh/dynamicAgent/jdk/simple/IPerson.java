package com.zhh.dynamicAgent.jdk.simple;

/**
 * @Author:zhh
 * @Date:Created in 11:38 2019/6/11 0011
 * 现在需要在say方法被调用的时候，记录方法被调用的时间，最直接的就是修改Man的say方法，但是这样做的弊端就是如果有很多实现了IPerson接口的类，那就需要修改多处代码，而且这样的修改可能会导致其他的代码出问题(可能并不是所有的say都需要记录调用时间)。怎么办呢，这时候代理就要登场了！
 *
 * 作者：三好码农
 * 链接：https://www.jianshu.com/p/6e962d1e7ddd
 * 来源：简书
 * 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
 */
public interface IPerson {
    void say();
}