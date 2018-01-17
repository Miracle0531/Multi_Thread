package com.itheima.demo08;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <p>Titel:CyclicBarrierDemo</p>
 * <p>Description:循环栅栏测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-03 19:01
 */
@SuppressWarnings("all")
public class CyclicBarrierDemo {

    /**
     * 模拟单线程执行
     */
    public static class Soldier implements Runnable {

        private String soldier;
        private final CyclicBarrier cyclicBarrier;

        public Soldier(CyclicBarrier cyclicBarrier, String soldierName) {
            this.cyclicBarrier = cyclicBarrier;
            this.soldier = soldierName;
        }

        @Override
        public void run() {

            try {

                // 等待所有线程到齐后再开始共同执行
                cyclicBarrier.await();
                doWork();
                cyclicBarrier.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }

        /**
         * 线程执行
         */
        private void doWork() {

            try {
                Thread.sleep(Math.abs(new Random().nextInt(10) % 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(soldier + "任务完成...");

        }

    }

    /**
     * 模拟线程控制
     */
    public static class Barrier implements Runnable {

        boolean flag;
        int N;

        public Barrier(boolean flag, int N) {
            this.flag = flag;
            this.N = N;
        }

        @Override
        public void run() {

            if (flag) {
                System.out.println(N + "个线程任务完成...");
            } else {
                System.out.println(N + "个线程准备就绪...");
                flag = true;
            }

        }
    }

    /**
     * 循环栅栏测试
     */
    @Test
    public void test() {

        // 创建线程数
        final int N = 10;
        // 存入线程数组
        Thread[] allSoldier = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new Barrier(flag, N));

        System.out.println("开始执行...");
        for (int num = 0; num < N; ++num) {
            System.out.println("线程" + num + "到达");
            allSoldier[num] = new Thread(new Soldier(cyclicBarrier, "线程" + num));
            allSoldier[num].start();
        }

    }

}
