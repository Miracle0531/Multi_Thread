package com.itheima.demo01;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Titel:ReentrantLockDemo</p>
 * <p>Description:重入锁的基础测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-28 20:58
 */
public class ReentrantLockDemo implements Runnable {

    public static int num = 0;
    public static ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        for (int count = 0; count < 5000; count++) {
            reentrantLock.lock();
            reentrantLock.lock();
            try {

                num++;

            } finally {
                reentrantLock.unlock();
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ReentrantLockDemo reentrantLock = new ReentrantLockDemo();
        Thread thread1 = new Thread(reentrantLock);
        Thread thread2 = new Thread(reentrantLock);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(num);

    }

}
