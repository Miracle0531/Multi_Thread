package com.itheima.demo09;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * <p>Titel:LockSupportDemo2</p>
 * <p>Description:线程阻塞工具测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-03 20:46
 */
@SuppressWarnings("all")
public class LockSupportDemo2 {

    public static Object object = new Object();
    LockSupportThread lockSupportThread1 = new LockSupportThread("FirstThread...");
    LockSupportThread lockSupportThread2 = new LockSupportThread("SecondThread...");

    public static class LockSupportThread extends Thread {

        public LockSupportThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {

            synchronized (object) {
                System.out.println("Runnning:" + getName());
                LockSupport.park();
                if (Thread.interrupted()) {
                    System.out.println(getName() + "线程被中断了...");
                }
            }
            System.out.println(getName() + "执行结束...");

        }

    }

    @Test
    public void test() throws InterruptedException {

        lockSupportThread1.start();
        Thread.sleep(2000);
        lockSupportThread2.start();
        lockSupportThread1.interrupt();
        LockSupport.unpark(lockSupportThread2);

    }

}
