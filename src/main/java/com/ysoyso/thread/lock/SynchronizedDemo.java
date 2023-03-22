package com.ysoyso.thread.lock;

/**
 * 介绍synchronized关键字
 * synchronized结束后，锁的释放时机
 */
public class SynchronizedDemo {
    public static final Object LOCK = new Object();
    static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        lockBlock();
    }

    public static void test() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (LOCK) {
                    count++;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (LOCK) {
                    count++;
                }
            }
        });
        /*
        count++; =>   count = count + 1;
        t1 count = 0;  count + 1; // 此时count = 0; t2执行
        t2 count = 0;  count + 1; count = 1 // 执行完 count = 1; t1继续执行
        t1 count = 1;
        --------------------------------
        count++; =>   count = count + 1;
        synchronized : t1 count = 0;  count + 1; count = 1// 此时count = 1; t2执行
        synchronized : t2 count = 1;  count + 1; count = 2 // 执行完 count = 2;
         */
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }

    public static void lockBlock() {
        Thread t1 = new Thread(() -> {
            System.out.println(" t1 wait");
            synchronized (LOCK) {
                System.out.println(" t1 get lock");
                sleep(3000);
            }
            System.out.println(" t1 unlock");
            sleep(6000);
            System.out.println(" t1 end");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("t2 wait");
            synchronized (LOCK) {
                System.out.println("t2 get lock");
                sleep(3000);
            }
            System.out.println("t2 unlock");
            sleep(6000);
            System.out.println("t2 end");
        });
        t1.start();
        t2.start();
    }
    public static void lock() {
        Thread t1 = new Thread(() -> {
            System.out.println(" t1 wait");
            synchronized (LOCK) {
                System.out.println(" t1 get lock");
                sleep(1000);
                System.out.println(" t1 sleep end");
            }
            System.out.println(" t1 end");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("t2 wait");
            synchronized (LOCK) {
                System.out.println("t2 get lock");
                sleep(1000);
                System.out.println("t2 sleep end");
            }
            System.out.println("t2 end");
        });
        t1.start();
        t2.start();
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
