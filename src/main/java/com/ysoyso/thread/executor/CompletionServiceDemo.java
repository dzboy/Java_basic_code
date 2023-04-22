package com.ysoyso.thread.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * <pre>
 * CompletionService和线程池的异同点如下：
 *
 * 相同点：CompletionService和线程池都可以用于异步执行任务。
 * 不同点：CompletionService可以按照任务完成的顺序获取结果，而线程池则不能保证任务的执行顺序。
 *       此外，CompletionService还可以批量处理任务结果，而线程池则需要手动遍历Future来获取每个任务的结果。
 * </pre>
 */
public class CompletionServiceDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        multiTask();
//        threadPoolTask();
    }

    private static void threadPoolTask() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(() -> {Thread.sleep(9000); return 3;});
        tasks.add(() -> {Thread.sleep(6000); return 2;});
        tasks.add(() -> {Thread.sleep(3000); return 1;});

//        for (int i = 0; i < tasks.size(); i++) {
//            Future<Integer> future = executorService.submit(tasks.get(i));
//            System.out.println(future.get());
//        }

//        List<Future<Integer>> futures = executorService.invokeAll(tasks);
//        for (int i = 0; i < futures.size(); i++) {
//            System.out.println(futures.get(i).get());
//        }

    }

    private static void multiTask() throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);

        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(() -> {Thread.sleep(9000); return 3;});
        tasks.add(() -> {Thread.sleep(6000); return 2;});
        tasks.add(() -> {Thread.sleep(3000); return 1;});

        for (Callable<Integer> task : tasks) {
            completionService.submit(task);
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("will take");
            Future<Integer> future = completionService.take(); // 通过completionService.take()来获取完成任务的结果
            System.out.println("Result " + i + ": " + future.get());
        }

        executor.shutdown();
    }

}
