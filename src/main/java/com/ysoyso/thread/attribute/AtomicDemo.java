package com.ysoyso.thread.attribute;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger integer = new AtomicInteger();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
//                integer.incrementAndGet();
//                integer.getAndAdd(1);
                integer.set(integer.get() + 1);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
//                integer.incrementAndGet();
//                integer.getAndAdd(1);
                integer.set(integer.get() + 1);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(integer.get());
    }
}
