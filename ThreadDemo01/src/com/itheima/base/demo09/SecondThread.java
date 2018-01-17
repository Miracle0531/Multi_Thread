package com.itheima.base.demo09;

/**
 * <p>Titel:SecondThread</p>
 * <p>Description:自定义线程二</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-27 19:24
 */
@SuppressWarnings("all")
public class SecondThread extends Thread {

    final static Object object = new Object();

    @Override
    public void run() {

        synchronized (object) {
            try {
                object.notify();
                Thread.sleep(2000);
                System.out.println("SecondThread END...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
