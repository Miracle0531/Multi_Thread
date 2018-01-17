package com.itheima.base.demo08;

/**
 * <p>Title:MyThread</p>
 * <p>Description:自定义线程</p>
 *
 * @author TJR
 * @version 1.0
 * @date 2017-12-24 16:21
 */
public class MyThread extends Thread {
    private int num = 0;

    @Override
    public void run() {

        try {

            while (true) {
                num++ ;
                System.out.println("num:" + num);
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
