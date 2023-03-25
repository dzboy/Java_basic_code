package com.ysoyso.thread.attribute;

/**
 * Thread
 * ^
 * ThreadLocalMap
 * ^
 * ThreadLocal
 */
public class ThreadLocalDemo {
    private static final ThreadLocal<Integer> counter = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void increment() {
        counter.set(counter.get() + 1);
    }

    public static int get() {
        return counter.get();
    }

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
            System.out.println(get());
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
            System.out.println(get());
        }).start();

    }
}
