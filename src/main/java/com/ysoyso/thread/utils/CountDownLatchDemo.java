package com.ysoyso.thread.utils;

import java.util.concurrent.CountDownLatch;

/**
 * 等待latch为0后，继续执行
 * --->|----->
 * ----->|----->
 * ------->|----->
 *         |------->
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                sleep((long) (Math.random() * 5000) + 1000);
                latch.countDown();
                System.out.println(Thread.currentThread().getName() + " countdown " + latch.getCount());
            });
            t.setName("t-" + i);
            t.start();
        }
        latch.await();
        System.out.println("main run");
        System.out.println("--------------------");

//        for (int i = 0; i < 10; i++) {
//            Thread t = new Thread(() -> {
//                sleep((long) (Math.random() * 5000) + 1000);
//                latch.countDown();
//                System.out.println(Thread.currentThread().getName() + " countdown " + latch.getCount());
//            });
//            t.setName("t-" + i);
//            t.start();
//        }
//        latch.await();
//        System.out.println("main run2");
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
