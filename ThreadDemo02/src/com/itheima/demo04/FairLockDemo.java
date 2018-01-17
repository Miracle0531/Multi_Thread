package com.itheima.demo04;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Titel:FairLockDemo</p>
 * <p>Description:公平锁测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-29 19:31
 */
public class FairLockDemo {

    final static Object OBJECT = new Object();

    /**
     * 创建公用重入锁(公平锁);并非绝对公平
     */
    public static ReentrantLock reentrantLock = new ReentrantLock();

    public class ThreadDemo1 implements Runnable {

        @Override
        public void run() {

            for (int num = 0; num < 1000; num++) {

                synchronized (OBJECT) {

                    try {

                        // 当前线程获取锁
                        reentrantLock.lock();

                        System.out.println(java.lang.Thread.currentThread().getName() + "获得锁...");

                    } finally {
                        // 当前线程释放锁
                        reentrantLock.unlock();
                    }

                }

                try {
                    reentrantLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    public class ThreadDemo2 implements Runnable {

        @Override
        public void run() {

            for (int num = 0; num < 1000; num++) {

                reentrantLock.notify();

                synchronized (OBJECT) {

                    try {

                        // 当前线程获取锁
                        reentrantLock.lock();

                        System.out.println(java.lang.Thread.currentThread().getName() + "获得锁...");

                    } finally {
                        // 当前线程释放锁
                        reentrantLock.unlock();
                    }

                }

            }

        }
    }

    @Test
    public void test() {

        ThreadDemo1 thread1 = new ThreadDemo1();
        ThreadDemo2 thread2 = new ThreadDemo2();

        Thread thread3 = new Thread(thread1, "FirstThread...");
        Thread thread4 = new Thread(thread2, "--------------");

        thread3.start();
        thread4.start();

    }
}
