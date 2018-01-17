package com.itheima.base.demo09;

/**
 * <p>Titel:ThirdThread</p>
 * <p>Description:自定义线程三</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-27 20:52
 */
public class ThirdThread {

    final static Object OBJECT = new Object();

    public static class thread1 extends Thread {
        @Override
        public void run() {
            synchronized (OBJECT) {
                try {

                    for (int num = 0; num < 1000; num++) {
                        if (num == 100){
                            OBJECT.wait();
                        }else {
                            // TODO 为什么线程二终止后线程一不继续执行了?
                            System.out.println("FirstThread:" + num);
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class thread2 extends Thread {
        @Override
        public void run() {

            synchronized (OBJECT) {
                try {
                    OBJECT.notify();
                    Thread.sleep(2000);
                    System.out.println("SecondThread END...");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
