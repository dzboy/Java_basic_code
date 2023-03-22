package com.ysoyso.thread.wait;

/**
 * notify后释放锁时机
 */
public class WaitBlockDemo {
    public static final Object LOCK = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 start");
            synchronized (LOCK) {
                System.out.println("t1 wait release lock");
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t1 run");
            }
        });

        Thread t2 = new Thread(() -> {
            sleep(1000);
            System.out.println("t2 start");
            synchronized (LOCK) {
                System.out.println("t2 run");
                LOCK.notify();
                System.out.println("t2 sleep");
                sleep(3000);
                System.out.println("t2 end");
            }
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
