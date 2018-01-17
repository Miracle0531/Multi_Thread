package com.itheima.base.demo05;

import org.junit.Test;

/**
 * 自定义线程测试类
 *
 * @author TJR
 * @version 1.0, 2017-12-23 20:36
 */
public class ThreadTest {

    /**
     * interrupted()测试
     * interrupted()执行后会将线程中断状态标志为false
     */
    @Test
    public void test01() {
        try {
            MyThread myThread = new MyThread();
            // 开启线程
            myThread.start();
            // 线程休眠
            Thread.sleep(1000);
            // 线程中断
            myThread.interrupt();

            System.out.println("线程中断?" + MyThread.interrupted());
            System.out.println("线程中断?" + MyThread.interrupted());

        } catch (Exception e) {
            System.out.println("main catch");
            e.printStackTrace();

        }

    }

    /**
     * isInterrupted()测试
     * isInterrupted()只能判断线程是否处于中断状态,没有更改状态的功能
     */
    @Test
    public void test02() {
        try {

            MyThread myThread = new MyThread();
            // 开启线程
            myThread.start();
            // 线程休眠
            Thread.sleep(1000);
            // 线程中断
            myThread.interrupt();

            System.out.println("线程中断?" + myThread.isInterrupted());
            System.out.println("线程中断?" + myThread.isInterrupted());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
