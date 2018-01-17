package com.itheima.thread.test01;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <p>Titel:CyclicBarrierDemo</p>
 * <p>Description:回环栅栏案例</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-10 15:19
 */
@SuppressWarnings("all")
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        int num = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(num);
        for (int count = 0; count < num; count++) {
            new testCyclicBarrier(cyclicBarrier).start();
        }

    }

    public static class testCyclicBarrier extends Thread {

        private CyclicBarrier cyclicBarrier;

        public testCyclicBarrier(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {

            System.out.println("线程" + Thread.currentThread().getId() + "正在运行...");
            try {
                Thread.sleep(2000);
                System.out.println("线程" + Thread.currentThread().getId() + "运行结束...");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程执行结束");
        }

    }

}
