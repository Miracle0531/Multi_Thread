package com.itheima.base.demo06;

/**
 * 更新后的自定义线程
 *
 * @author TJR
 * @version 1.0, 2017-12-23 21:30
 */
public class MySecondThread extends Thread {

    @Override
    public void run() {
        try {

            for (int num = 0; num < 100000; num++) {
                if (MySecondThread.interrupted()){
                    System.out.println("线程中断...");
                }
                System.out.println("num2:" + num);
            }

            System.out.println("for循环外的线程执行语句...");

        } catch (Exception e) {
            System.out.println("MySecondThread Catch...");
            e.printStackTrace();
        }
    }

}
