package com.itheima.demo07;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Titel:CountDownLatchDemo</p>
 * <p>Description:倒计时器</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-31 23:00
 */
@SuppressWarnings("all")
public class CountDownLatchDemo implements Runnable {

    /**
     * 创建一个倒计时器实例
     *  参数为10：表示有需要有10个线程完成任务
     */
    final static CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(10);

    /**
     * 创建倒计时对象，用于多线程测试
     */
    final static CountDownLatchDemo COUNT_DOWN_LATCH_DEMO = new CountDownLatchDemo();

    @Override
    public void run() {

        try {

            // 进行线程等待
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("CheackComplete...");
            // 一个线程已经完成任务,通知计时器减一
            COUNT_DOWN_LATCH.countDown();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 进行线程测试
     * @param args
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 进行循环调用，模拟多线程
        for (int num = 0; num < 10; num++) {
            // 调用倒计时对象进行多线程测试
            executorService.submit(COUNT_DOWN_LATCH_DEMO);
        }

        // 主线程进行等待,等待所有线程完成任务后主线程继续执行
        COUNT_DOWN_LATCH.await();

        // 倒计时完成
        System.out.println("Fire...");

        // 终止
        executorService.shutdown();

    }

}
