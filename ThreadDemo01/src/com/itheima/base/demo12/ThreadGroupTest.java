package com.itheima.base.demo12;

/**
 * <p>Titel:ThreadGroupTest</p>
 * <p>Description:线程组测试类</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-28 19:19
 */
@SuppressWarnings("all")
public class ThreadGroupTest implements Runnable {

    public static void main(String[] args) {

        // 创建线程组
        ThreadGroup threadGroup = new ThreadGroup("线程测试组:");
        Thread thread1 = new Thread(threadGroup,new ThreadGroupTest(), "FirstThread:");
        Thread thread2 = new Thread(threadGroup,new ThreadGroupTest(), "SecondThread:");

        thread1.setPriority(1);
        thread2.setPriority(10);

        thread1.start();
        thread2.start();
        System.out.println(threadGroup.activeCount());
        threadGroup.list();

    }

    @Override
    public void run() {
        for (int num = 1; num < 1000; num++) {
            // 获取当前线程名
            System.out.println(Thread.currentThread().getThreadGroup().getName() + Thread.currentThread().getName() + "num:" + num);
        }

    }

}
