package com.ysoyso.thread.executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 工作原理
 * <pre>
 *             ThreadPoolExecutor service = new ThreadPoolExecutor(
 *                 coreSize,
 *                 coreSize * 2,
 *                 1000,
 *                 TimeUnit.MILLISECONDS,
 *                 queue,
 *                 handler);
 *
 * 1、线程池刚创建时，里面没有一个线程。任务队列是作为参数传进来的。不过，就算队列里面有任务，线程池也不会马上执行它们。
 * 2、当调用 execute() 方法添加一个任务时，线程池会做如下判断：
 *       execute(Runnable) 总流程：
 *             a. 如果正在运行的线程数量小于 corePoolSize，那么马上创建线程运行这个任务；
 *             b. 如果正在运行的线程数量大于或等于 corePoolSize，那么将这个任务放入队列。
 *             c. 如果这时候队列满了，而且正在运行的线程数量小于 maximumPoolSize，那么还是要创建线程运行这个任务；
 *             d. 如果队列满了，而且正在运行的线程数量大于或等于 maximumPoolSize，那么线程池会根据拒绝策略执行：比如AbortPolicy会抛出异常，告诉调用者“我不能再接受任务了”。
 * 3、当一个线程完成任务时，它会从队列中取下一个任务来执行。
 * 4、当一个线程无事可做，超过一定的时间（keepAliveTime）时，线程池会判断，如果当前运行的线程数大于 corePoolSize，那么这个线程就被停掉。
 *       所以线程池的所有任务完成后，它最终会收缩到 corePoolSize 的大小。
 *
 * 拒绝策略：
 *       提供了四种预定义的处理程序策略：
 *     在默认的ThreadPoolExecutor.AbortPolicy         中，处理程序遭到拒绝将抛出运行时RejectedExecutionException。
 *     在     ThreadPoolExecutor.CallerRunsPolicy    中，线程调用运行该任务的execute 本身。此策略提供简单的反馈控制机制，能够减缓新任务的提交速度。
 *     在     ThreadPoolExecutor.DiscardPolicy       中，不能执行的任务将被删除。
 *     在     ThreadPoolExecutor.DiscardOldestPolicy 中，如果执行程序尚未关闭，则工作队列头部的任务将被删除，然后重试执行程序（如果再次失败，则重复此过程）
 * </pre>
 */
public class ExecutorServiceDemo {
    public static void main(String[] args) {
        demoParams();
//        demoQueue();
//        demoKeepAliveTime();
    }

    private static void demoParams() {

        // 验证 工作原理
        int coreSize = Runtime.getRuntime().availableProcessors();
        System.out.println("coreSize " + coreSize);
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(); // 无界队列
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

        /*
        验证 拒绝策略
        DiscardPolicy
        run 0 2 4 4 6
        run 1 1 4 4 6
        run 4 0 4 4 6 // 超出corePoolSize的线程在运行
        run 5 0 3 4 6 // 超出corePoolSize的线程在运行
        run 2 0 2 2 6 // 取出Queue中的任务运行
        run 3 0 1 2 6 // 取出Queue中的任务运行
         */
//        int coreSize = 2;
//        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(2); // 有界队列
//        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
//        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();
//        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();
//        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();

        ThreadPoolExecutor service = new ThreadPoolExecutor(
                coreSize,
                coreSize * 2,
                1000,
                TimeUnit.MILLISECONDS,
                queue,
                handler);

        service.setThreadFactory(new IOThreadFactory());

        Thread t = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                sleep(1000);
                System.out.println("before submit queueSize:" + queue.size() + ", index: " + i + ", ActiveCount:" + service.getActiveCount() + ", PoolSize:" + service.getPoolSize() + ", TaskCount:" + service.getTaskCount());
                int finalI = i;
                service.submit(() -> {
//                    sleep(10000);
                    sleep(20000); // 验证拒绝策略
                    System.out.println("thread " + Thread.currentThread().getName() + ", index: " + finalI + " queueSize:" + queue.size() + ", ActiveCount:" + service.getActiveCount() + ", PoolSize:" + service.getPoolSize() + ", TaskCount:" + service.getTaskCount());
                });
                System.out.println("after submit queueSize:" + queue.size());
            }
        });
        t.setName("TST");
        t.start();
    }

    private static void demoQueue() {

        int coreSize = 1;
        System.out.println("coreSize " + coreSize);
//        BlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        BlockingQueue<Runnable> queue = new SynchronousQueue<>();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

        ThreadPoolExecutor service = new ThreadPoolExecutor(
                coreSize,
                coreSize * 2,
                1000,
                TimeUnit.MILLISECONDS,
                queue,
                handler);

        service.setThreadFactory(new IOThreadFactory());

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                sleep(100);
                System.out.println("before submit queueSize:" + queue.size() + ", index: " + i + ", ActiveCount:" + service.getActiveCount() + ", PoolSize:" + service.getPoolSize() + ", TaskCount:" + service.getTaskCount());
                int finalI = i;
                service.execute(new PriorityRunnable() {
                    @Override
                    public void run() {
                        sleep(2000);
                        System.out.println("thread " + Thread.currentThread().getName() + ", index: " + finalI + " queueSize:" + queue.size() + ", ActiveCount:" + service.getActiveCount() + ", PoolSize:" + service.getPoolSize() + ", TaskCount:" + service.getTaskCount());
                    }
                }.setPriority(i));
                System.out.println("after submit queueSize:" + queue.size());
            }
        }).start();
    }

    private static void demoKeepAliveTime() {

        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

        ThreadPoolExecutor service = new ThreadPoolExecutor(
                1,
                20,
                2000,
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<>(),
                handler);

        service.setThreadFactory(new IOThreadFactory());

        final long time = System.currentTimeMillis();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                sleep(10);
                int finalI = i;
                service.submit(() -> {
                    sleep(300);
                    System.out.println(System.currentTimeMillis() - time);
                    System.out.println("thread " + Thread.currentThread().getName() + ", index: " + finalI + ", ActiveCount:" + service.getActiveCount() + ", PoolSize:" + service.getPoolSize() + ", TaskCount:" + service.getTaskCount());
                });
            }
        }).start();


        new Thread(() -> {
            sleep(2000);
            for (int i = 0; i < 60; i++) {
                System.out.println("ActiveCount:" + service.getActiveCount() + ", PoolSize:" + service.getPoolSize() + ", TaskCount:" + service.getTaskCount());
                sleep(10);
            }
        }).start();
    }

    static class IOThreadFactory implements ThreadFactory {
        static final AtomicInteger count = new AtomicInteger();
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("POOL-IO-" + count.incrementAndGet());
            return t;
        }
    }

    public abstract static class PriorityRunnable implements Runnable, Comparable<PriorityRunnable> {
        int priority;

        public PriorityRunnable setPriority(int priority) {
            this.priority = priority;
            return this;
        }

        @Override
        public int compareTo(PriorityRunnable o) {
            if (null == o) {
                return 1;
            } else {
                return priority - o.priority; // asc
            }
        }
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
