package com.ysoyso.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
//        lock();
//        interrupt();
//        tryLock();
//        tryLockTimeout();
        fair();

    }

    private static void fair() {
        ReentrantLock lock = new ReentrantLock(true);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    System.out.println("t1 获取锁");
                    sleep(100);
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    System.out.println("t2 获取锁");
                    sleep(100);
                } finally {
                    lock.unlock();
                }
            }
        });
        t1.start();
        t2.start();
    }

    private static void tryLockTimeout() {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            System.out.println("t1 run");
            sleep(1000);
            try {
                boolean success = lock.tryLock(5000, TimeUnit.MILLISECONDS);
                System.out.println("t1 lock " + success);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    System.out.println("t1 unlock");
                    lock.unlock();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            System.out.println("t2 run");
            lock.lock();
            try {
                System.out.println("t2 lock");
                sleep(5000);
            } finally {
                System.out.println("t2 unlock");
                lock.unlock();
            }
        });
        t1.start();
        t2.start();
    }
    private static void tryLock() {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            System.out.println("t1 run");
            sleep(1000);
            try {
                boolean hasLock = false;
                while (!hasLock) {
                    System.out.println("t1 try lock");
                    hasLock = lock.tryLock();
                    sleep(300);
                }
                System.out.println("t1 lock");
            } finally {
                System.out.println("t1 unlock");
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            System.out.println("t2 run");
            lock.lock();
            try {
                System.out.println("t2 lock");
                sleep(3000);
            } finally {
                System.out.println("t2 unlock");
                lock.unlock();
            }
        });
        t1.start();
        t2.start();
    }

    private static void interrupt() {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            System.out.println("t1 run");
            sleep(1000);
            try {
                System.out.println("t1 tryLock");
                lock.lockInterruptibly();
                System.out.println("t1 lock");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("t1 unlock");
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            System.out.println("t2 run");
            lock.lock();
            try {
                System.out.println("t2 lock");
                sleep(1500);
                System.out.println("t2 interrupt t1");
                t1.interrupt();
            } finally {
                System.out.println("t2 unlock");
                lock.unlock();
            }
        });
        t1.start();
        t2.start();

    }

    private static void lock() {
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            System.out.println("t1 run");
            lock.lock();
            try {
                System.out.println("t1 lock");
                sleep(3000);
            } finally {
                System.out.println("t1 unlock");
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            System.out.println("t2 run");
            lock.lock();
//            可重入
//            lock.lock();
//            lock.unlock();
            try {
                System.out.println("t2 lock");
                sleep(3000);
            } finally {
                System.out.println("t2 unlock");
                lock.unlock();
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
