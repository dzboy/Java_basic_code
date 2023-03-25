package com.ysoyso.thread.attribute;

public class FinalDemo {
    public static final int CONST = 1;
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(CONST);
        });
        new Thread(() -> {
            System.out.println(CONST);
        });
    }
}
