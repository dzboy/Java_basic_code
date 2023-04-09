package com.ysoyso.thread.utils;

import java.util.concurrent.Semaphore;

/**
 * 信号量，根据许可数量，来获取和释放许可，获取的许可用完后，需要等待释放后，其他线程才可以获取许可继续执行
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5, false);
//        for (int i = 0; i < 10; i++) {
//            Thread t = new Thread(() -> {
//                sleep(1000);
//                try {
//                    semaphore.acquire();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("acquire thread " + Thread.currentThread().getName());
//                sleep(5000);
//                semaphore.release();
//                System.out.println("release thread " + Thread.currentThread().getName());
//            });
//            t.setName("t-" + i);
//            t.start();
//        }

        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("acquire thread " + Thread.currentThread().getName() + " acquire count:" + j);
                    semaphore.release();
                    System.out.println("release thread " + Thread.currentThread().getName());
                }
            });
            t.setName("t-" + i);
            t.start();
        }

    }

    private static void sleep(long time) {
        try {
            Thread.sleep((long) (1000 + Math.random() * time));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
