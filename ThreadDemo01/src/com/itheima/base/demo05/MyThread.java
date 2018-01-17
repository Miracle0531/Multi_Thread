package com.itheima.base.demo05;

/**
 * 自定义线程
 *
 * @author TJR
 * @version 1.0, 2017-12-23 20:27
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int num = 0; num < 100000; num++) {
            System.out.println("num:" + num);
        }
    }

}
