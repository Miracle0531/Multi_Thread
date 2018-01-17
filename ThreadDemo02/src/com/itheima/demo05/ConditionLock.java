package com.itheima.demo05;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Titel:ConditionLock</p>
 * <p>Description:Condition条件与ReenterLock</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-29 20:14
 */
public class ConditionLock implements Runnable {

    /**
     * 创建重入锁对象
     */
    public static ReentrantLock reentrantLock = new ReentrantLock();
    /**
     * 给重入锁关联Condition方法
     */
    public static Condition condition = reentrantLock.newCondition();

    @Override
    public void run() {

        try {

            // 线程加锁
            reentrantLock.lock();
            // 线程等待
            condition.await();
            System.out.println(Thread.currentThread().getName() + "ThreadIsGoing...");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        // 创建线程
        ConditionLock conditionLock = new ConditionLock();
        Thread thread1 = new Thread();

        // 开启线程
        thread1.start();

        Thread.sleep(2000);

        // 唤醒等待线程继续执行
        reentrantLock.lock();
        condition.signal();
        reentrantLock.unlock();
    }

}
