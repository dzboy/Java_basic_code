package com.ysoyso.thread.order;

import java.util.concurrent.atomic.AtomicInteger;

public class OrderDemo {
    static AtomicInteger count1 = new AtomicInteger();
    static AtomicInteger count2 = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                // count1自增 、 count1赋值、 count2自增、count2赋值
                synchronized (OrderDemo.class) {
                    int c1 = count1.incrementAndGet();
                    int c2 = count2.incrementAndGet();
                    if (c1 != c2) {
                        System.out.println("t1 : " + c1 + " " + c2);
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (OrderDemo.class) {
                    int c1 = count1.incrementAndGet();
                    int c2 = count2.incrementAndGet();
                    if (c1 != c2) {
                        System.out.println("t2 : " + c1 + " " + c2);
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("-------------------");
        System.out.println(count1.get());
        System.out.println(count2.get());
    }
}
