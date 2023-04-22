package com.ysoyso.thread.executor;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

public class ExecutorDemo {
    public static void main(String[] args) {
//        execute();
        serial();
    }

    private static void execute() {
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable command) {
                command.run();
            }
        };
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
    }

    private static void serial() {
        Executor executor = new Executor() {
            final Queue<Runnable> queue = new ArrayDeque<>();
            Runnable runnable;

            @Override
            public synchronized void execute(Runnable command) {
                // 1 queue empty -> scheduleNext()
                // 2 queue not empty -> ...  command.run()结束 finally中 scheduleNext() -> queue中取下一个任务 -> run
                //                              ^ _____________________________________________________________|
                queue.offer(new Runnable() {
                    public void run() {
                        try {
                            command.run();
                        } finally {
                            scheduleNext();
                        }
                    }
                });
                if (runnable == null) {
                    scheduleNext();
                }
            }

            private synchronized void scheduleNext() {
                runnable = queue.poll();
                if (null != runnable) {
                    runnable.run();
                }
            }
        };
        int coreSize = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < coreSize; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    int finalJ = j;
                    executor.execute(() -> {
                        sleep(1000);
                        System.out.println(Thread.currentThread().getName() + " task:" + finalJ);
                    });
                }
            });
            t.setName("T-" + i);
            t.start();
        }
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
