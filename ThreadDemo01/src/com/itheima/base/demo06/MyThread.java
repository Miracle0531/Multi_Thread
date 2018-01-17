package com.itheima.base.demo06;

/**
 * 自定义线程
 *
 * @author TJR
 * @version 1.0, 2017-12-23 21:20
 */
public class MyThread extends Thread {

    @Override
    public void run() {

        for (int num = 0; num < 100000; num++) {

            if (this.interrupted()) {
                System.out.println("线程被中断了...");
                break;
            }

            System.out.println("num:" + num);

        }

        System.out.println("线程中断,线程终止...");

    }

}
