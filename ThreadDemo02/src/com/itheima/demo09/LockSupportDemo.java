package com.itheima.demo09;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * <p>Titel:LockSupportDemo</p>
 * <p>Description:线程阻塞工具类测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-03 20:37
 */
public class LockSupportDemo {

    public static Object object = new Object();
    static LockSupportThread lockSupportThread1 = new LockSupportThread("FirstThread...");
    static LockSupportThread lockSupportThread2 = new LockSupportThread("SecondThread...");

    public static class LockSupportThread extends Thread {

        public LockSupportThread(String name) {

            super.setName(name);

        }

        @Override
        public void run() {

            synchronized (object) {
                System.out.println("Running:" + getName());
                LockSupport.park();
            }

        }

    }

    @Test
    public void test() throws InterruptedException {

        lockSupportThread1.start();
        Thread.sleep(2000);
        lockSupportThread2.start();
        Thread.sleep(3000);
        LockSupport.unpark(lockSupportThread1);
        LockSupport.unpark(lockSupportThread2);
        lockSupportThread1.join();
        lockSupportThread2.join();

    }

}
