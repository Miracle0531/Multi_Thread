package com.itheima.base.demo07;

import org.junit.Test;

/**
 * <p>Title:ThreadTest</p>
 * <p>Description:线程休眠中中止线程</p>
 *
 * @author TJR
 * @version 1.0
 * @date 2017-12-24 15:22
 */
public class ThreadTest {

    @Test
    public void test01() {
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            Thread.sleep(500);
            myThread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch...");
            e.printStackTrace();
        }

        System.out.println("Thread End...");
    }

}
