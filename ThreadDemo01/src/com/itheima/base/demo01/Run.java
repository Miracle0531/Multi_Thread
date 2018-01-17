package com.itheima.base.demo01;

import org.junit.Test;

/**
 * 运行的测试类
 *
 * @author TJR
 * @version 1.0, 2017-12-22 15:53
 */
public class Run {

    @Test
    public void test(){

        MyThread myThread = new MyThread();
        myThread.run();
        System.out.println("MyThread线程终止...");

    }

}
