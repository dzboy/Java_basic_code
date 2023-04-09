package com.ysoyso.thread.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) {
        FutureTask<String> future = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("call");
                sleep(3000);
                System.out.println("run");
                return "Hello World";
            }
        });
        Thread thread = new Thread(future);
        thread.start();
        try {
            System.out.println("main get");
            sleep(1000);
//            System.out.println(future.isDone());
//            System.out.println(future.get());
//            System.out.println(future.isDone());

            System.out.println(future.isDone());
            future.cancel(false);
            System.out.println(future.isDone());
            if (!future.isCancelled()) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


    private static void sleep(long time) {
        try {
            Thread.sleep((long) (1000 + Math.random() * time));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
