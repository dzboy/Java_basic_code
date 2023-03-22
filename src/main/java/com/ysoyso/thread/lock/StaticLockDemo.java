package com.ysoyso.thread.lock;

/**
 * 介绍静态锁和对象锁的区别
 */
public class StaticLockDemo {
    public static void main(String[] args) {
        objectCount();
    }

    /**
     * 相同对象和不同对象锁的差异
     */
    public static void objectCount() {
        StaticLockDemo d = new StaticLockDemo();
        StaticLockDemo d2 = new StaticLockDemo();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                d.count2();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                d2.count2();
            }
        });
        t1.start();
        t2.start();
        join(t1);
        join(t2);
        System.out.println("result = " + i);
    }

    /**
     * 静态锁
     */
    public static void staticCount() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                count();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                count();
            }
        });
        t1.start();
        t2.start();
        join(t1);
        join(t2);
        System.out.println("result = " + i);
    }

    static int i = 0;

    public synchronized void count2() {
        synchronized (this) {
            i++;
        }
    }
    public static synchronized void count() {
        i++;
    }
    public static void join(Thread t) {
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
