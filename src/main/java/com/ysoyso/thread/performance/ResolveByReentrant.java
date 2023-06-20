package com.ysoyso.thread.performance;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ResolveByReentrant {
    private static final ReentrantLock lockA = new ReentrantLock();
    private static final ReentrantLock lockB = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockA.lock();
                    System.out.println("Thread 1 acquired lock A");
                    Thread.sleep(100);
                    if (lockB.tryLock(100, TimeUnit.MILLISECONDS)) {
                        System.out.println("Thread 1 acquired lock B");
                        Thread.sleep(100);
                    } else {
                        System.out.println("Thread 1 failed to acquire lock B, aborting");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (lockB.isHeldByCurrentThread()) {
                        lockB.unlock();
                        System.out.println("Thread 1 released lock B");
                    }
                    lockA.unlock();
                    System.out.println("Thread 1 released lock A");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockB.lock();
                    System.out.println("Thread 2 acquired lock B");
                    Thread.sleep(100);
                    if (lockA.tryLock(100, TimeUnit.MILLISECONDS)) {
                        System.out.println("Thread 2 acquired lock A");
                        Thread.sleep(100);
                    } else {
                        System.out.println("Thread 2 failed to acquire lock A, aborting");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (lockA.isHeldByCurrentThread()) {
                        lockA.unlock();
                        System.out.println("Thread 2 released lock A");
                    }
                    lockB.unlock();
                    System.out.println("Thread 2 released lock B");
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
