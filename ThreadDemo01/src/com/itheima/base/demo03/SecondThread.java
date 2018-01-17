package com.itheima.base.demo03;

/**
 * 第二个线程
 *
 * @author TJR
 * @version 1.0, 2017-12-22 18:17
 */
public class SecondThread implements Runnable {

    @Override
    public void run() {
        System.out.println("The Second Thread...");
    }
}
