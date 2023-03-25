package com.ysoyso.thread.attribute;

public class SynchronizedDemo {
    static int counter = 0;
    static final Object LOCK = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (SynchronizedDemo.class) {
                    counter++;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (SynchronizedDemo.class) {
                    counter++;
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter);
    }
}
