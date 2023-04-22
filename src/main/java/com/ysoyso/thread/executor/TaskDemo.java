package com.ysoyso.thread.executor;

import java.util.concurrent.*;

public class TaskDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(4);
//        Future<?> task = service.submit(new FutureTask<>(() -> {
//            Thread.sleep(3000);
//            System.out.println("return hello");
//            return "hello";
//        }));
//        System.out.println("-------wait-------");
//        String str = (String) task.get();
//        System.out.println(str);


//        FutureTask<String> task0 = new FutureTask<>(() -> {
//            Thread.sleep(3000);
//            return "hello 2 " + Thread.currentThread().getName();
//        });
//        service.submit(task0);
//
//        System.out.println("-------wait0-------");
//        String str0 = task0.get();
//        System.out.println(str0);
//
//
//        FutureTask<String> task00 = new FutureTask<>(() -> {
//            Thread.sleep(3000);
//            return "hello 3 " + Thread.currentThread().getName();
//        });
//        System.out.println("-------wait00-------");
//        task00.run();
//        String str00 = task00.get();
//        System.out.println(str00);
//
//        Future<?> task1 = service.submit(() -> {
//            Thread.sleep(3000);
//            return "world " + Thread.currentThread().getName();
//        });
//        System.out.println("-------wait1-------");
//        String str1 = (String) task1.get();
//        System.out.println(str1);
//
//        Callable<String> callable = () -> {
//            Thread.sleep(3000);
//            return "world 1 " + Thread.currentThread().getName();
//        };
//        System.out.println("-------wait11-------");
//        String str11 = callable.call();
//        System.out.println(str11);

    }
}
