package com.itheima.base.demo04;

/**
 * 自定义线程
 *
 * @author TJR
 * @version 1.0, 2017-12-22 18:28
 */
@SuppressWarnings("all")
public class MyThread extends Thread {

    private int num = 100;

    public MyThread(String name){
        this.setName(name);
    }

    @Override
    public void run() {
        while (num > 0){
            num -- ;
            System.out.println("running:" + Thread.currentThread().getName() + num);
        }

    }
}
