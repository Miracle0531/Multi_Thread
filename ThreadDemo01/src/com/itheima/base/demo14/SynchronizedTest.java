package com.itheima.base.demo14;

/**
 * <p>Titel:SynchronizedTest</p>
 * <p>Description:线程锁测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-28 20:18
 */
@SuppressWarnings("all")
public class SynchronizedTest implements Runnable {

    static SynchronizedTest synchronizedTest = new SynchronizedTest();
    static int num = 0;

    // 对象加锁
    public synchronized void increase() {
        num++;
    }

//    // 对象未加锁
//    public void increase() {
//        num++;
//    }

    @Override
    public void run() {

        for (int count = 0; count < 10000; count++) {
            increase();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(synchronizedTest);
        Thread thread2 = new Thread(synchronizedTest);
        Thread thread3 = new Thread(synchronizedTest);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(num);

    }

}
