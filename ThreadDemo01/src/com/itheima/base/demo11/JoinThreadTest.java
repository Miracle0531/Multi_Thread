package com.itheima.base.demo11;

/**
 * <p>Titel:JoinThreadTest</p>
 * <p>Description:等待结束线程测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-28 16:39
 */
@SuppressWarnings("all")
public class JoinThreadTest {
    // 定义公共可见变量
    public volatile static int num = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (num = 0; num < 10000; num++) ;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        AddThread addThread = new AddThread();
        addThread.start();
        System.out.println(num);
        addThread.join();
        System.out.println(num);

    }

}
