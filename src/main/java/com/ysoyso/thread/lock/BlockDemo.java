package com.ysoyso.thread.lock;

/**
 * 介绍同步代码块和同步方法
 */
public class BlockDemo {
    final Object LOCK1 = new Object();
    static final Object LOCK_STATIC = new Object();

    public static void main(String[] args) {
        objectTest();
    }

    public static void objectTest() {
        BlockDemo demo = new BlockDemo();
        Thread t1 = new Thread(() -> {
            System.out.println(getThreadName() + " wait");
            demo.objectLogic();
            System.out.println(getThreadName() + " end");
        });
        Thread t2 = new Thread(() -> {
            System.out.println(getThreadName() + " wait");
            demo.objectLogic();
            System.out.println(getThreadName() + " end");
        });

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();
    }

    public static void staticTest() {
        Thread t1 = new Thread(() -> {
            System.out.println(getThreadName() + " wait");
            logic();
            System.out.println(getThreadName() + " end");
        });
        Thread t2 = new Thread(() -> {
            System.out.println(getThreadName() + " wait");
            logic();
            System.out.println(getThreadName() + " end");
        });

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();
    }

    /**
     * 同步代码块和同步方法：对象锁
     */
    public synchronized void objectLogic() {
        System.out.println(getThreadName() + " get lock");
        sleep(1000);
        System.out.println(getThreadName() + " sleep end");
    }

    /**
     * 同步代码块和同步方法：静态锁
     */
    public static synchronized void logic() {
        System.out.println(getThreadName() + " get lock");
        sleep(1000);
        System.out.println(getThreadName() + " sleep end");
    }

    public static String getThreadName() {
        return Thread.currentThread().getName();
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
