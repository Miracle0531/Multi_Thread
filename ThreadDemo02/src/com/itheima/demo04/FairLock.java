package com.itheima.demo04;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Titel:FairLock</p>
 * <p>Description:公平锁测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-29 18:59
 */
public class FairLock implements Runnable {

    /**
     * 创建公用重入锁(公平锁);并非绝对公平
     */
    public static ReentrantLock reentrantLock = new ReentrantLock(true);

    @Override
    public void run() {
        for (int num = 0; num < 1000; num++) {

            try {

                // 当前线程获取锁
                reentrantLock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁...");

            } finally {
                // 当前线程释放锁
                reentrantLock.unlock();
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {

        FairLock fairLock = new FairLock();

        Thread thread1 = new Thread(fairLock, "FirstThread...");
        Thread thread2 = new Thread(fairLock, "--------------");

        thread1.start();
        thread2.start();

    }
}
