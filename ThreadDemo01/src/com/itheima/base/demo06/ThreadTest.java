package com.itheima.base.demo06;

import org.junit.Test;

/**
 * 自定义线程测试类
 *
 * @author TJR
 * @version 1.0, 2017-12-23 21:23
 */
public class ThreadTest {

    /**
     * 使用for语句来判断线程的状态
     */
    @Test
    public void test01() {

        try {

            MyThread myThread = new MyThread();
            // 开启线程
            myThread.start();
            Thread.sleep(1000);
            myThread.interrupt();

        } catch (Exception e) {
            System.out.println("main match");
            e.printStackTrace();
        }

    }

    @Test
    public void test02() {
        try {

            MySecondThread mySecondThread = new MySecondThread();
            // 开启线程
            mySecondThread.start();
            Thread.sleep(1000);
            mySecondThread.interrupt();

        } catch (Exception e) {
            System.out.println("main catch...");
            e.printStackTrace();
        }
        System.out.println("end...");
    }

}
