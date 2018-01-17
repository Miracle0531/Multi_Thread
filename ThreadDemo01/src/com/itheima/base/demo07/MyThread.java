package com.itheima.base.demo07;

/**
 * <p>title:MyThread</p>
 * <p>description:自定义线程</p>
 *
 * @author TJR
 * @version 1.0
 * @date 2017-12-24 15:18
 */
@SuppressWarnings("all")
public class MyThread extends Thread {

    @Override
    public void run() {

        System.out.println("开启线程");

        for (int num = 0; num < 10000; num++) {
            System.out.println("num:" + num);
            try {

                Thread.sleep(500000);

            } catch (InterruptedException e) {
                System.out.println("线程睡眠中中断...线程状态:" + this.isInterrupted());
                e.printStackTrace();
            }

        }

    }

}
