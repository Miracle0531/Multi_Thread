package com.itheima.base.demo13;

/**
 * <p>Titel:DaemonThreadTest</p>
 * <p>Description:守护线程测试类</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-28 19:28
 */
@SuppressWarnings("all")
public class DaemonThreadTest {

    public static class DaemonThread extends Thread {

        @Override
        public void run() {
            while (true) {
                try {

                    System.out.println("I'm DaemonThread!!!");

                    Thread.sleep(1000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new DaemonThread();
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(5000);

    }

}
