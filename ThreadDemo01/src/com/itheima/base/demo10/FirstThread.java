package com.itheima.base.demo10;

/**
 * <p>Titel:FirstThread</p>
 * <p>Description:自定义测试类</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-27 21:39
 */
public class FirstThread {
    final static Object OBJECT = new Object();

    public static class thread extends Thread {

        public thread(String threadName) {
            this.setName(threadName);
        }

        @Override
        public void run() {
            synchronized (OBJECT) {
                // 获取当前线程
                for (int num = 0; num < 1000; num++) {
                    System.out.println("Running:" + getName() + num);
                    while (num == 100){
                        // 挂起当前线程
                        Thread.currentThread().suspend();
                    }
                }
            }
        }

    }


}
