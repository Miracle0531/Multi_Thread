package com.itheima.demo03;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Titel:TimeLock</p>
 * <p>Description:限时锁的测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-29 18:09
 */
public class TimeLock implements Runnable {

    // 创建一个共有重入锁
    public static ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {

        try {

            if (reentrantLock.tryLock(5, TimeUnit.SECONDS)) {
                //Thread.sleep(2000);
                Thread.sleep(6000);
            } else {
                System.out.println(Thread.currentThread().getName() + "TimeLock End...");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reentrantLock.isHeldByCurrentThread()) {
                // 释放锁
                reentrantLock.unlock();
            }
        }

    }

    public static void main(String[] args) {

        TimeLock timeLock = new TimeLock();
        Thread thread1 = new Thread(timeLock);
        Thread thread2 = new Thread(timeLock);

        thread1.start();
        thread2.start();

    }

}
