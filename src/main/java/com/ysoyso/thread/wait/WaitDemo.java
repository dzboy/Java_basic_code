package com.ysoyso.thread.wait;

import java.util.LinkedList;
import java.util.Queue;

public class WaitDemo {
    public static Queue<String> words = new LinkedList<>();
    public static void main(String[] args) {
        waitTest();
    }

    public static void waitTest() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                sleep(1000);
                System.out.println("放入 : index " + i);
                put("index " + i);
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("t2 取出 : " + get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t3 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("t3 取出 : " + get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t4 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("t4 取出 : " + get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public static synchronized void put(String word) {
        words.offer(word);
        WaitDemo.class.notify();
    }

    public static synchronized String get() throws InterruptedException {
        WaitDemo.class.wait();
        return words.poll();
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
