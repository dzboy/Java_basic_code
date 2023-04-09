package com.ysoyso.thread.utils;

import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 阶段的概念
 */
public class PhaserDemo {
    public static void main(String[] args) {
//        arriveAndAwaitAdvanceThreadDemo();
//        arriveAndAwaitAdvanceMainDemo();
        stageDemo();
    }

    private static void stageDemo() {
        Phaser phaser = new Phaser();
        phaser.bulkRegister(3);
        stage(phaser, "老李");
        stage(phaser, "小张");
        stage(phaser, "大刘");
    }

    private static void stage(Phaser phaser, String stage) {
        Thread t = new Thread(() -> {
            System.out.println("赶来的是 " + stage);
            phaser.arriveAndAwaitAdvance();
            System.out.println("开始斗地主");
        });
        t.start();
    }

    /**
     * 类似CyclicBarrier
     */
    private static void arriveAndAwaitAdvanceThreadDemo() {
        Phaser phaser = new Phaser();
        phaser.bulkRegister(5);
        for (int i = 0; i < 5; i++) {
//            phaser.register();
            Thread thread = new Thread(() -> {
                sleep(1000);
                System.out.println(Thread.currentThread().getName() + " arrive");
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName() + " run " + phaser.getRegisteredParties());
            });
            thread.setName("t-" + i);
            thread.start();
        }
    }

    /**
     * 类似CountDownLatch
     */
    private static void arriveAndAwaitAdvanceMainDemo() {
        Phaser phaser = new Phaser();
        for (int i = 0; i < 5; i++) {
            phaser.register();
            Thread thread = new Thread(() -> {
                sleep(1000);
                System.out.println(Thread.currentThread().getName() + " arrive");
                phaser.arrive();
                System.out.println(Thread.currentThread().getName() + " run");
            });
            thread.setName("t-" + i);
            thread.start();
        }
        System.out.println("main arrive ");
        phaser.arriveAndAwaitAdvance();
        System.out.println("main run ");
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
