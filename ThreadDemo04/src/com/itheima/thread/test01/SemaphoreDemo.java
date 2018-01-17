package com.itheima.thread.test01;

import java.util.concurrent.Semaphore;

/**
 * <p>Titel:SemaphoreDemo</p>
 * <p>Description:信号量的案例</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-10 15:08
 */
@SuppressWarnings("all")
public class SemaphoreDemo {

    public static void main(String[] args) {

        int N = 10;
        Semaphore semaphore = new Semaphore(5);
        for (int num = 0; num < N; num++) {
            new Worker(num,semaphore).start();
        }

    }

    public static class Worker extends Thread {

        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {

                semaphore.acquire();
                System.out.println("线程" + Thread.currentThread().getId() + "正在运行...");
                Thread.sleep(2000);
                System.out.println("线程" + Thread.currentThread().getId() + "运行结束...");
                semaphore.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
