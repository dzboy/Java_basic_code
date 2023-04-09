package com.ysoyso.thread.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读锁不互斥，写锁互斥
 * 写锁可降级，读锁不可升级
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
//        rwDemo();
//        rwReduceDemo();
        rwUpgradeDemo();
    }

    private static void rwReduceDemo() {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        Thread t1 = new Thread(() -> {
            writeLock.lock();
            try {
                System.out.println("获取writeLock");
                readLock.lock();
                try {
                    System.out.println("降级为readLock");
                } finally {
                    System.out.println("释放readLock");
                    readLock.unlock();
                }
            } finally {
                System.out.println("释放writeLock");
                writeLock.unlock();
            }
        });
        t1.start();
    }
    private static void rwUpgradeDemo() {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        Thread t1 = new Thread(() -> {
            readLock.lock();
            try {
                System.out.println("获取readLock");
                writeLock.lock();
                try {
                    System.out.println("升级为writeLock");
                } finally {
                    System.out.println("释放writeLock");
                    writeLock.unlock();
                }
            } finally {
                System.out.println("释放readLock");
                readLock.unlock();
            }
        });
        t1.start();
    }
    private static Queue<String> messages = new LinkedList<>();
    private static void rwDemo() {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        Thread readThread1 = new Thread(() -> {
            while (true) {
                sleep(100);
                if (messages.isEmpty()) {
                    continue;
                }
                System.out.println("readThread1 will lock");
                readLock.lock();
                System.out.println("readThread1 lock");
//                sleep(10000);
                try {
                    String message = messages.poll();
                    System.out.println("readThread1 " + message);
                } finally {
                    System.out.println("readThread1 unlock");
                    readLock.unlock();
                }
            }
        });
        Thread readThread2 = new Thread(() -> {
            while (true) {
                sleep(100);
                if (messages.isEmpty()) {
                    continue;
                }
                System.out.println("readThread2 will lock");
                readLock.lock();
                System.out.println("readThread2 lock");
//                sleep(10000);
                try {
                    String message = messages.poll();
                    System.out.println("readThread2 " + message);
                } finally {
                    System.out.println("readThread2 unlock");
                    readLock.unlock();
                }
            }
        });
        Thread writeThread = new Thread(() -> {
            int i = 0;
            while (true) {
                System.out.println("writeThread will lock");
                sleep(1000);
                writeLock.lock();
                System.out.println("writeThread lock");
                try {
                    sleep(1000);
                    i++;
                    System.out.println("writeThread write  message:" + i);
                    messages.offer("message:" + i);
                } finally {
                    System.out.println("writeThread unlock");
                    writeLock.unlock();
                }
            }
        });
        readThread1.start();
        readThread2.start();
        writeThread.start();
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
