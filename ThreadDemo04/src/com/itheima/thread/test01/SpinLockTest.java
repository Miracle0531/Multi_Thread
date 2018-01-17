package com.itheima.thread.test01;

import org.junit.Test;

/**
 * <p>Titel:SpinLockTest</p>
 * <p>Description:自旋锁测试类</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-10 11:19
 */
@SuppressWarnings("all")
public class SpinLockTest {

    int count = 0;

    public void number() {
        count += 1;
        System.out.println("执行了" + count + "次...");
    }

    @Test
    public void testSpinLock() {

        SpinLockTest spinLockTest = new SpinLockTest();
        while (spinLockTest.count < 10000){
            spinLockTest.number();
        }
        System.out.println("继续执行其他任务...");
    }

}
