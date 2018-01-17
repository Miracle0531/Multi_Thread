package com.itheima.demo06;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <p>Titel:SemaphoreDemo</p>
 * <p>Description:信号量测试案例</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-30 18:23
 */
@SuppressWarnings("all")
public class SemaphoreDemo implements Runnable {

    final Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {

        try {

            semaphore.acquire();
            // 模拟操作耗时
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ":done!");
            semaphore.release();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        final SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        for (int num = 0; num < 1000; num++) {
            executorService.submit(semaphoreDemo);
        }

    }

}
