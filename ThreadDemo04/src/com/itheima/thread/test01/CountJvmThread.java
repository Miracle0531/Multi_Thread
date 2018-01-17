package com.itheima.thread.test01;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * <p>Titel:CountJvmThread</p>
 * <p>Description:JVM运行线程统计</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-10 1:14
 */
@SuppressWarnings("all")
public class CountJvmThread {

    public static void main(String[] args) {

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId() + " : " + threadInfo.getThreadName());
            System.out.println("当前线程:" + threadInfo.getThreadName());
        }
        /**
         * 5 : Attach Listener      接收外部命令并将结果返回给调用者
         * 4 : Signal Dispatcher    收到Attach Listener线程的命令后分发处理给JVM的线程
         * 3 : Finalizer            调用对象的finalizer的线程,就是垃圾回收线程
         * 2 : Reference Handler    主要用于处理引用对象本身(软、弱、虚引用)的垃圾回收问题
         * 1 : main                 主线程
         */

    }

}
