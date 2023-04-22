package com.ysoyso.thread.executor;

import java.util.concurrent.*;

public class FibonacciTaskDemo {

    public static void main(String[] args) throws Exception {
        int n = 40;
        System.out.println("Calculating Fibonacci sequence for n = " + n);

        long start = System.currentTimeMillis();

        ForkJoinPool pool1 = new ForkJoinPool();
        FibonacciTask task1 = new FibonacciTask(n);
        int result1 = pool1.invoke(task1);

        long end1 = System.currentTimeMillis();
        System.out.println("ForkJoinPool: Result = " + result1 + ", Time = " + (end1 - start) + "ms");

        long start2 = System.currentTimeMillis();
        ThreadPoolExecutor pool2 = new ThreadPoolExecutor(4, 4, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        FibonacciTask2 task2 = new FibonacciTask2(n);
        Future<Integer> future2 = (Future<Integer>) pool2.submit(task2);
        int result2 = future2.get();
        long end2 = System.currentTimeMillis();
        System.out.println("ThreadPoolExecutor: Result = " + result2 + ", Time = " + (end2 - start2) + "ms");

        pool1.shutdown();
        pool2.shutdown();
    }

    static class FibonacciTask extends RecursiveTask<Integer> {
        private int n;

        public FibonacciTask(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n <= 1) {
                return n;
            }
            // 1 1 2 3 5 8 13
//            System.out.println("Thread : " + Thread.currentThread().getName());
            FibonacciTask task1 = new FibonacciTask(n - 1);
            FibonacciTask task2 = new FibonacciTask(n - 2);
            task1.fork();
            int result2 = task2.compute();
            int result1 = task1.join();
            return result1 + result2;
        }
    }


    static class FibonacciTask2 implements Callable<Integer> {
        int n;
        public FibonacciTask2(int n) {
            this.n = n;
        }

        @Override
        public Integer call() throws Exception {
            if (n <= 1) {
                return n;
            }
            System.out.println("Thread : " + Thread.currentThread().getName());
            FibonacciTask2 task1 = new FibonacciTask2(n - 1);
            FibonacciTask2 task2 = new FibonacciTask2(n - 2);
            int result1 = task1.call();
            int result2 = task2.call();
            return result1 + result2;
        }
    }
}
