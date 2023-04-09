package com.ysoyso.thread.lock;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    public static void main(String[] args) {
//        demo();
//        checkConditionDemo();
        checkWaitDemo();
    }

    private static void demo() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread t0 = new Thread(() -> {
            System.out.println("t0 start");
            lock.lock();
            try {
                System.out.println("t0 lock");
                condition.await();
                System.out.println("t0 run");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    System.out.println("t0 unlock");
                    lock.unlock();
                }
            }
            System.out.println("t0 end");
        });
        Thread t1 = new Thread(() -> {
            System.out.println("t1 start");
            lock.lock();
            try {
                System.out.println("t1 lock");
                condition.await();
                System.out.println("t1 run");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    System.out.println("t1 unlock");
                    lock.unlock();
                }
            }
            System.out.println("t1 end");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2 start");
            sleep(1000);
            System.out.println("t2 lock");
            lock.lock();
            try {
                sleep(2000);
                System.out.println("t2 signal");
                condition.signal();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    System.out.println("t2 unlock");
                    lock.unlock();
                }
            }
            System.out.println("t2 end");
        });
        t0.start();
        t1.start();
        t2.start();
    }

    static AtomicBoolean isSignal = new AtomicBoolean();
    private static void checkConditionDemo() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread t1 = new Thread(() -> {
            System.out.println("t1 start");
            sleep(2000);
            try {
                lock.lock();
                System.out.println("t1 lock");
                if (!isSignal.get()) {
                    System.out.println("t1 await");
                    condition.await();
                }
                System.out.println("t1 run");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    System.out.println("t1 unlock");
                    lock.unlock();
                }
            }
            System.out.println("t1 end");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2 start");
            try {
                sleep(1000);
                System.out.println("t2 lock");
                lock.lock();
                sleep(2000);
                System.out.println("t2 signal");
                condition.signal();
                isSignal.set(true);
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    System.out.println("t2 unlock");
                    lock.unlock();
                }
            }
            System.out.println("t2 end");
        });
        t1.start();
        t2.start();
    }

    private static void checkWaitDemo() {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 start");
            sleep(2000);
            synchronized (ConditionDemo.class) {
                System.out.println("t1 lock");
                try {
                    if (!isSignal.get()) {
                        System.out.println("t1 wait");
                        ConditionDemo.class.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t1 run");
            }
            System.out.println("t1 end");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2 start");
            sleep(1000);
            synchronized (ConditionDemo.class) {
                System.out.println("t2 lock");
                sleep(2000);
                System.out.println("t2 notify");
                ConditionDemo.class.notify();
                isSignal.set(true);
            }
            System.out.println("t2 end");
        });
        t1.start();
        t2.start();
    }
    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
