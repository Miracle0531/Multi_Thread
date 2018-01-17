package com.itheima.base.demo03;

import org.junit.Test;

/**
 * 线程调用测试
 *
 * @author TJR
 * @version 1.0, 2017-12-22 18:18
 */
public class ThreadTest {

    @Test
    public void test01() {

        Thread thread1 = new Thread(new FirstThread());
        Thread thread2 = new Thread(thread1);
        Thread thread3 = new Thread(new SecondThread());
        Thread thread4 = new Thread(thread3);
        Thread thread5 = new Thread(new ThirdThread());
        Thread thread6 = new Thread(thread5);

        thread2.run();
        thread4.run();
        thread6.run();

    }

}
