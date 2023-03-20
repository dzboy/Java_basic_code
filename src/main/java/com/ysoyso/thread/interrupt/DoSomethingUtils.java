package com.ysoyso.thread.interrupt;

public class DoSomethingUtils {
    private DoSomethingUtils() {

    }
    public static void doSomething() throws InterruptedException{
        while (true) {
            // 处理一些事情
            if (Thread.currentThread().isInterrupted()) {
                boolean flag = Thread.interrupted();
                System.out.println("线程被打断了 " + Thread.currentThread().getName() + " flag = " + flag);
                throw new InterruptedException("doSomething 被打断了");
            }
        }
    }
}
