package com.ysoyso.thread.attribute;

public class LocalVariablesDemo {
    public static void main(String[] args) {
        new Thread(() -> {
            int count = 0;
            for (int i = 0; i < 100; i++) {
                count++;
            }
            System.out.println(count);
        }).start();
        new Thread(() -> {
            int count1 = 0;
            for (int i = 0; i < 100; i++) {
                count1++;
            }
            System.out.println(count1);
        }).start();
    }
}
