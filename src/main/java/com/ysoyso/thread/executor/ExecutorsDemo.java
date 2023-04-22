package com.ysoyso.thread.executor;

import java.util.concurrent.*;

public class ExecutorsDemo {
    public static void main(String[] args) {
        // corePoolSize和maximumPoolSize相同，无界队列
        // 该线程池中的线程数始终不变。
        // 如果线程池中的所有线程都在处理任务时都处于繁忙状态，那么新的任务就会在队列中等待。
        // 适用于需要限制线程数量的场景，如服务器端并发请求处理。
        // nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()
        ExecutorService fixedThreadExecutor = Executors.newFixedThreadPool(4);

        // corePoolSize 0,maximumPoolSize是Integer.MAX_VALUE，线程存活时间60s，线程不会存储再队列中
        // 根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。
        // 如果线程池中的所有线程都在处理任务时都处于繁忙状态，那么线程池会创建新的线程来处理任务。
        // 适用于执行很多短期异步任务的程序，如任务队列处理。
        // 0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>()
        ExecutorService cachedThreadExecutor = Executors.newCachedThreadPool();

        // corePoolSize和maximumPoolSize相同 = 1，无界队列，如果newFixedThreadPool(1)相当于newSingleThreadExecutor()
        // 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序执行。
        // 适用于需要保证顺序执行各个任务，并且在任意时间点，不会有多个线程是活动的场景。
        // 1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        // 内部是ScheduledThreadPoolExecutor，maximumPoolSize是Integer.MAX_VALUE
        // 创建一个定长线程池，支持定时及周期性任务执行。
        // 适用于需要定时执行任务或周期性执行任务的场景，
        // 如定时备份数据、定时发送邮件等。
        // new ScheduledThreadPoolExecutor(corePoolSize)
        ScheduledExecutorService scheduledThreadExecutor = Executors.newScheduledThreadPool(4);
        scheduledThreadExecutor.scheduleAtFixedRate(() -> {
            System.out.println("-------------------");
            System.out.println("schedule this task");
        }, 0, 3, TimeUnit.SECONDS);
    }
}
