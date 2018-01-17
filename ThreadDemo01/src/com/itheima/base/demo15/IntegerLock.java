package com.itheima.base.demo15;

/**
 * <p>Titel:IntegerLock</p>
 * <p>Description:Integer加锁测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-28 20:47
 */
public class IntegerLock implements Runnable {

    public static Integer num = 0;

    static IntegerLock integerLock = new IntegerLock();

    @Override
    public void run() {

        for (int count = 0; count < 10000; count++) {
            // 修正代码
            synchronized (integerLock){
                num++;
            }

            // 错误代码
            /**
             * Integer是一个不变对象,需要新建对象重新赋值,因此导致不同线程获取到的num值不同而导致结果不同
             */
            synchronized (num){
                num++;
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(integerLock);
        Thread thread2 = new Thread(integerLock);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(num);

    }
}
