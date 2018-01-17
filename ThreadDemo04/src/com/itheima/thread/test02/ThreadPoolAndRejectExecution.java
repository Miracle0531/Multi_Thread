package com.itheima.thread.test02;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * <p>Titel:ThreadPoolAndRejectExecution</p>
 * <p>Description:线程池与拒绝策略</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-11 20:47
 */
@SuppressWarnings("all")
public class ThreadPoolAndRejectExecution {

    public static class MyTask implements Runnable {

        @Override
        public void run() {

            System.out.println(System.currentTimeMillis() + "; ThreadID:" + Thread.currentThread().getId());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    @Test
    public void testThreadPool() throws InterruptedException {

        MyTask myTask = new MyTask();

        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(r.toString() + "is discard!");
            }
        });

        for (int num = 0; num < Integer.MAX_VALUE; num++) {
            executorService.submit(myTask);
            Thread.sleep(10);
        }

    }

}
