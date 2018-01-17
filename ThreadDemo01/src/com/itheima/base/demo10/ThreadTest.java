package com.itheima.base.demo10;

/**
 * <p>Titel:ThreadTest</p>
 * <p>Description:线程测试类</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-27 21:44
 */
public class ThreadTest {

    public static void main(String[] args) {

        try {

            Thread thread1 = new FirstThread.thread("FirstThread...");
            Thread thread2 = new FirstThread.thread("SecondThread...");
            thread1.start();
            // Thread.sleep(2000);
            thread2.start();
            // Thread.sleep(2000);
            thread1.resume();
            thread2.resume();
            thread1.join();
            thread2.join();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
