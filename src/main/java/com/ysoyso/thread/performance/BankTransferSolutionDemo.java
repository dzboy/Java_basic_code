package com.ysoyso.thread.performance;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankTransferSolutionDemo {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int balance1 = 1000;
    private int balance2 = 2000;

    public void transfer1() throws InterruptedException {
        lock.lock();
        try {
            while (balance1 < 500) {
                condition.await();
            }
            balance1 -= 500;
            balance2 += 500;
            System.out.println("Transfer $500 from account 1 to account 2");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void transfer2() throws InterruptedException {
        lock.lock();
        try {
            while (balance2 < 1000) {
                condition.await();
            }
            balance2 -= 1000;
            balance1 += 1000;
            System.out.println("Transfer $1000 from account 2 to account 1");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BankTransferSolutionDemo bts = new BankTransferSolutionDemo();

        Thread t1 = new Thread(() -> {
            try {
                bts.transfer1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                bts.transfer2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }

}

