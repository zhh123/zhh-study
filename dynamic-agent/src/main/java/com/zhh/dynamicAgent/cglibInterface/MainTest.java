package com.zhh.dynamicAgent.cglibInterface;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @Author:zhh
 * @Date:Created in 16:30 2019/6/11 0011
 */
public class MainTest {
    public static void main(String[] args) {
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\gitCode\\mySpring\\DcumentReader\\src\\main\\java\\com\\tqy\\document\\reader\\extention\\demo2");

        TestCGLIb testCGLib = new TestCGLIb();
        TestInterface o = (TestInterface) testCGLib.getInstance(TestInterfaceImpl.class);
        System.out.println(o.getHalloWorld());
    }
}