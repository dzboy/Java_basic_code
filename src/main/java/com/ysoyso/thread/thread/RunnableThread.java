package com.ysoyso.thread.thread;

public class RunnableThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("开始运行了"));
        thread.start();

        new Thread(() -> System.out.println("开始运行了")).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始运行了");
            }
        }).start();
    }
}
