package com.itheima.base.demo08;

import org.junit.Test;

/**
 * <p>Title:ThreadTest</p>
 * <p>Description:使用Stop()强行终止线程</p>
 *
 * @author TJR
 * @version 1.0
 * @date 2017-12-24 16:23
 */
public class ThreadTest {

    @Test
    public void test() {
        try {

            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(8000);
            myThread.stop();

            System.out.println("自定义线程被终止...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
