package com.itheima.base.demo01;

/**
 * 单线程案例
 *
 * @author TJR
 * @version 1.0, 2017-12-22 15:52
 */
public class MyThread extends Thread {

    @Override
    public void run() {

        super.run();
        System.out.println("MyThread...");

    }

}
