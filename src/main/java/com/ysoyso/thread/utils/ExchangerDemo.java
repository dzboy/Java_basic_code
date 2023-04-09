package com.ysoyso.thread.utils;

import java.util.concurrent.Exchanger;

/**
 * 用于两个线程间的通信
 * 多线程调用时进行数据交换
 */
public class ExchangerDemo {
    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                System.out.println("t1 sleep");
                sleep(1000);
                System.out.println("t1 run");
                String data = exchanger.exchange("t1data");
                System.out.println(Thread.currentThread().getName() + " " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();

        new Thread(()->{
            try {
                System.out.println("t2 run");
                String data = exchanger.exchange("t2data");
                System.out.println(Thread.currentThread().getName() + " " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T2").start();
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
