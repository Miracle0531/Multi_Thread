package com.itheima.demo02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Titel:ReentrantLockDemo</p>
 * <p>Description:重入锁的中断测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-28 23:17
 */
public class ReentrantLockDemo implements Runnable {

    public static ReentrantLock reentrantLock1 = new ReentrantLock();
    public static ReentrantLock reentrantLock2 = new ReentrantLock();
    int lock = 0;

    public ReentrantLockDemo(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        try {

            if (lock == 1) {
                // 进入线程一
                // 第一个锁
                reentrantLock1.lockInterruptibly();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                // 第二个锁
                reentrantLock2.lockInterruptibly();
            } else {
                // 进入线程二
                // 第一个锁
                reentrantLock2.lockInterruptibly();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                // 第二个锁
                reentrantLock1.lockInterruptibly();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reentrantLock1.isHeldByCurrentThread()) {
                reentrantLock1.unlock();
            }
            if (reentrantLock2.isHeldByCurrentThread()) {
                reentrantLock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + "线程终止...");
        }

    }

    public static void main(String[] args) throws InterruptedException {

        ReentrantLockDemo reentrantLockDemo1 = new ReentrantLockDemo(1);
        ReentrantLockDemo reentrantLockDemo2 = new ReentrantLockDemo(2);

        Thread thread1 = new Thread(reentrantLockDemo1);
        Thread thread2 = new Thread(reentrantLockDemo2);

        thread1.start();
        thread2.start();

        Thread.sleep(3000);

        // 上述步骤形成死锁问题,中断一个线程以释放
        thread2.interrupt();

    }

}
