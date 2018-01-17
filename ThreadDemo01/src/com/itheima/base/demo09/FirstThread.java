package com.itheima.base.demo09;

/**
 * <p>Titel:FirstThread</p>
 * <p>Description:自定义线程一</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-27 19:23
 */
@SuppressWarnings("all")
public class FirstThread extends Thread {

    final static Object object = new Object();

    @Override
    public void run() {
        synchronized (object) {
            try {

                for (int num = 0; num < 1000; num++) {
                    if (num == 100){
                        object.wait();
                    }else {
                        // TODO 为什么线程二终止后线程一不继续执行了?
                        System.out.println("FirstThread:" + num);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
