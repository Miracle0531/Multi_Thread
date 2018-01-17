package com.itheima.thread.test01;

import java.util.concurrent.CountDownLatch;

/**
 * <p>Titel:CountDownLatchDemo</p>
 * <p>Description:倒计时器案例</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-10 14:37
 */
@SuppressWarnings("all")
public class CountDownLatchDemo {

    static final CountDownLatch countDownLatch = new CountDownLatch(5);

    public static class countDownLock extends Thread {

        @Override
        public void run() {

            System.out.println("线程" + Thread.currentThread().getId() + "准备运行...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getId() + "运行结束...");
            countDownLatch.countDown();

        }

    }

    public static void main(String[] args) throws InterruptedException {

        for (int num = 0; num < 5; num++) {
            Thread thread = new Thread(new countDownLock());
            thread.start();
        }
        countDownLatch.await();
        System.out.println("主线程继续运行....");

    }

}
