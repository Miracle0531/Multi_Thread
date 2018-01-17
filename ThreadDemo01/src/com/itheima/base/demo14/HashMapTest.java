package com.itheima.base.demo14;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Titel:HashMapTest</p>
 * <p>Description:HashMap多线程测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-28 20:32
 */
public class HashMapTest {
    static Map<String, String> map = new HashMap<String, String>();

    public static class AddThread implements Runnable {

        int start = 0;

        public AddThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int num = 0; num < 100000; num++) {
                map.put(Integer.toString(num), Integer.toBinaryString(num));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new HashMapTest.AddThread(0));
        Thread thread2 = new Thread(new HashMapTest.AddThread(1));

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(map.size());

    }
}
