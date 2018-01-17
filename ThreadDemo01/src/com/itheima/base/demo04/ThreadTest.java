package com.itheima.base.demo04;

import org.junit.Test;

/**
 * 多线程测试
 *
 * @author TJR
 * @version 1.0, 2017-12-22 18:30
 */
public class ThreadTest {

    public static void main(String[] args) {

        MyThread myThread1 = new MyThread("A");
        MyThread myThread2 = new MyThread("B");
        MyThread myThread3 = new MyThread("C");
        MyThread myThread4 = new MyThread("D");
        MyThread myThread5 = new MyThread("E");

//        myThread1.start();
//        myThread2.start();
//        myThread3.start();
//        myThread4.start();
//        myThread5.start();

        myThread1.run();
        myThread2.run();
        myThread3.run();
        myThread4.run();
        myThread5.run();

    }

    @Test
    public void test() {

        MyThread myThread1 = new MyThread("A");
        MyThread myThread2 = new MyThread("B");
        MyThread myThread3 = new MyThread("C");
        MyThread myThread4 = new MyThread("D");
        MyThread myThread5 = new MyThread("E");

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();

//        myThread1.run();
//        myThread2.run();
//        myThread3.run();
//        myThread4.run();
//        myThread5.run();
    }

    @Test
    public void test1(){
        new Thread(()->{
            System.out.println(123);
        }).start();
    }

}
