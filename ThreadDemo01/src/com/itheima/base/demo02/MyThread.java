package com.itheima.base.demo02;

/**
 * 自定义线程
 *
 * @author TJR
 * @version 1.0, 2017-12-22 16:01
 */
public class MyThread extends Thread {

    @Override
    public void run() {

        try {

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
