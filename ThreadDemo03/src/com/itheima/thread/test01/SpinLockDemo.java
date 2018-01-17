package com.itheima.thread.test01;

import org.junit.Test;

/**
 * <p>Titel:SpinLockDemo</p>
 * <p>Description:未使用自旋锁的递归案例</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-10 11:24
 */
@SuppressWarnings("all")
public class SpinLockDemo {

    int count = 0;

    public void countNumber() {
        if (count > 100000) {
            return;
        }
        count += 1;
        System.out.println("执行了" + count + "次");
        // 递归调用
        countNumber();
    }

    @Test
    public void testSpinkLock() {

        SpinLockDemo spinLockDemo = new SpinLockDemo();
        spinLockDemo.countNumber();
        System.out.println("继续执行其他任务...");

        /**
         * java.lang.StackOverflowError
         * 执行一定次数后出现栈内存溢出的情况,需要改进代码
         * 代码改进详见com.itheima.thread.test01.SpinLockTest
         */
    }

}
