package com.ysoyso.thread.executor;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorDemo {

    static int coreSize = Runtime.getRuntime().availableProcessors();
    static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(coreSize);
    public static void main(String[] args) {
//        delayDemo();
//        timerDemo(1000, () -> System.out.println("tick"));
        timerDemo2(1000, () -> System.out.println("tick"));
    }

    private static void delayDemo() {
        System.out.println("start");
        executor.schedule(() -> System.out.println("run"), 3000, TimeUnit.MILLISECONDS);
    }

    private static void timerDemo(int tick, Runnable runnable) {
        executor.schedule(() -> {
            timerDemo(tick, runnable);
            runnable.run();
        }, tick, TimeUnit.MILLISECONDS);
    }

    private static void timerDemo2(int tick, Runnable runnable) {
        executor.scheduleAtFixedRate(runnable, 5000, tick, TimeUnit.MILLISECONDS);
    }
}
