package com.itheima.base.demo02;

import org.junit.Test;

/**
 * 线程测试类
 *
 * @author TJR
 * @version 1.0, 2017-12-22 16:01
 */
public class RunTest {

    @Test
    public void test() {

        try {

            MyThread myThread = new MyThread();
            myThread.setName("线程...");
            // myThread.run();
            myThread.start();

            for (int num = 0; num < 10; num ++) {
                int time = (int) (Math.random() * 1000);
                // 线程休眠
                Thread.sleep(time);
                // 输出
                System.out.println("Running:" + Thread.currentThread().getName() + time);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
