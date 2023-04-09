package com.ysoyso.thread.utils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 通过await阻塞指定数量的线程，当所有线程被阻塞住后，再同时放开
 *   ->|--->
 * --->|--->
 *  -->|--->
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(10, () -> {
            System.out.println(Thread.currentThread().getName() + " is tripped");
        });
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                sleep((long) (Math.random() * 5000) + 1000);
                try {
                    System.out.println(Thread.currentThread().getName() + " will await, Parties:" + barrier.getParties() + " NumberWaiting:" + barrier.getNumberWaiting());
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " start");
            });
            t.setName("t-" + i);
            t.start();
        }
        sleep(10000);
        System.out.println("-----------reset------------");
        barrier.reset();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                sleep((long) (Math.random() * 5000) + 1000);
                try {
                    System.out.println(Thread.currentThread().getName() + " will await, Parties:" + barrier.getParties() + " NumberWaiting:" + barrier.getNumberWaiting());
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " start");
            });
            t.setName("t-" + i);
            t.start();
        }

    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
