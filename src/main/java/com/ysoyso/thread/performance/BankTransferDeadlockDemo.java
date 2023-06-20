package com.ysoyso.thread.performance;

public class BankTransferDeadlockDemo {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    private int balance1 = 1000;
    private int balance2 = 2000;

    public void transfer1() {
        synchronized (lock1) {
            System.out.println("Acquired lock1 in transfer1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                balance1 -= 500;
                balance2 += 500;
                System.out.println("Acquired lock2 in transfer1");
                System.out.println("Transfer $500 from account 1 to account 2");
            }
        }
    }

    public void transfer2() {
        synchronized (lock2) {
            System.out.println("Acquired lock2 in transfer2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1) {
                balance2 -= 1000;
                balance1 += 1000;
                System.out.println("Acquired lock1 in transfer2");
                System.out.println("Transfer $1000 from account 2 to account 1");
            }
        }
    }

    public static void main(String[] args) {
        BankTransferDeadlockDemo btd = new BankTransferDeadlockDemo();

        Thread t1 = new Thread(() -> btd.transfer1());
        Thread t2 = new Thread(() -> btd.transfer2());

        t1.start();
        t2.start();
    }
}
