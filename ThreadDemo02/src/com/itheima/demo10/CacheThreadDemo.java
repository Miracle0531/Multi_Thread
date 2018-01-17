package com.itheima.demo10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Titel:CacheThreadDemo</p>
 * <p>Description:CacheThread测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-04 15:06
 */
public class CacheThreadDemo {

    public static class MyTask implements Runnable {

        @Override
        public void run() {

            System.out.println(System.currentTimeMillis() + ";ThreadID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int num = 0; num < 10; num++) {
            executorService.submit(myTask);
        }

    }

}
