package com.ysoyso.thread.attribute.volatiles;

public class VolatilesDemo {
    static volatile boolean flag = false;
    static volatile int count = 0;
// JMM
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                count++;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                count++;
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }

    private static void testVolatile() {

        Thread t1 = new Thread(() -> {
            while (true) {
                if (flag) {
                    System.out.println("t1 " + System.currentTimeMillis());
                    break;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t2 " + System.currentTimeMillis());
            flag = true;
        });
        t1.start();
        t2.start();
    }
}
