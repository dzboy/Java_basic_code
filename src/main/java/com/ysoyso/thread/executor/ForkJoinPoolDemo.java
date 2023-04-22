package com.ysoyso.thread.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinPool和ExecutorServer的区别在于，ForkJoinPool是一种特殊的线程池，专门用于处理可分解的任务，而ExecutorServer则是一般性的线程池。
 * ForkJoinPool通过工作窃取算法 work-stealing 来提高效率，而ExecutorServer则是通过生产者-消费者模型来实现任务的调度。
 * ForkJoinPool的使用需要继承RecursiveTask或RecursiveAction类，然后重写compute方法
 */
public class ForkJoinPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();

//        for (int j = 0; j < 10; j++) {
//            sleep(1000);
//            pool.submit(() -> {
//                System.out.println("hello " + Thread.currentThread().getName());
//            });
//        }

        ForkJoinTask<String> forkJoinTask = pool.submit(new RecursiveTask<String>() {

            @Override
            protected String compute() {
                sleep(3000);
                return "hello " + Thread.currentThread().getName();
            }
        });

//        String result = forkJoinTask.get();
//        System.out.println(result);

//        String result1 = forkJoinTask.invoke();
//        System.out.println(result1);

//        String result2 = forkJoinTask.join();
//        System.out.println(result2);

    }
    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
