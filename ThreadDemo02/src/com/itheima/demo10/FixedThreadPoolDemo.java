package com.itheima.demo10;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Titel:FixedThreadPoolDemo</p>
 * <p>Description:FixedThreadPool线程池</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-04 14:26
 */
@SuppressWarnings("all")
public class FixedThreadPoolDemo {

    public static class MyTask implements Runnable {

        @Override
        public void run() {

            System.out.println(System.currentTimeMillis() + ";ThreadID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int num = 0; num < 10; num++) {
            executorService.submit(myTask);
        }

    }

    @Test
    public void test() {
        MyTask myTask = new MyTask();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int num = 0; num < 10; num++) {
            executorService.submit(myTask);
        }
    }

}
