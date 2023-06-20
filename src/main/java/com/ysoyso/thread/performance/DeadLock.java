package com.ysoyso.thread.performance;

public class DeadLock {
    private static Object lockA = new Object();
    private static Object lockB = new Object();


    public static void main(String[] args) {
        testWaitLock();
    }

    // 双方互相持有对方需要的锁:即两个或多个线程在等待彼此持有的锁，导致所有线程都无法继续执行下去。这种情况通常会产生一个循环等待的场景。
    private static void testWaitLock() {
        Thread thread1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread 1 acquired lock A");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB) {
                    System.out.println("Thread 1 acquired lock B");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("Thread 2 acquired lock B");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockA) {
                    System.out.println("Thread 2 acquired lock A");
                }
            }
        });

        thread1.start();
        thread2.start();
    }


}
