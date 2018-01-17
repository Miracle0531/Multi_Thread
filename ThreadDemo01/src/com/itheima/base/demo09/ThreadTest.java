package com.itheima.base.demo09;

/**
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-27 19:49
 */
@SuppressWarnings("all")
public class ThreadTest {

    public static void main(String[] args) {
        Thread firstThread = new ThirdThread.thread1();
        Thread secondThread = new ThirdThread.thread2();
        firstThread.start();
        secondThread.start();
    }

}
