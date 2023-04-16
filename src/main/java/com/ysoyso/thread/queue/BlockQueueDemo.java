package com.ysoyso.thread.queue;

import java.util.concurrent.*;

public class BlockQueueDemo {

    public static void main(String[] args) {
//        demoLinkedBlockingQueue();
//        demoArrayBlockingQueue();
//        demoSynchronousQueue();
        demoPriorityBlockingQueue();
    }

    private static void demoPriorityBlockingQueue() {
        BlockingQueue<String> blockingQueue = new PriorityBlockingQueue<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sleep(100);
                // 5,4,3,2,1,0,1,2,3,4
                put(Math.abs(i - 5) + "", blockingQueue);
            }
        });
        Thread t2 = new Thread(() -> {
            sleep(3000);
            while (true) {
                sleep(300);
                System.out.println(take(blockingQueue));
            }
        });
        t1.start();
        t2.start();
    }
    private static void demoSynchronousQueue() {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        generateBytes(blockingQueue);
    }
    private static void demoArrayBlockingQueue() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);
        generateBytes(blockingQueue);
    }
    private static void demoLinkedBlockingQueue() {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        generateBytes(blockingQueue);
    }

    private static void generateBytes(BlockingQueue<String> queue) {
        Thread t1 = new Thread(() -> {
            while (true) {
                sleep(300);
                System.out.println("producer start");
                long time = System.currentTimeMillis();
                // 256MB
                byte[] bytes = new byte[1024 * 1024 * 256];
                for (int i = 0; i < 1024 * 1024 * 256; i++) {
                    bytes[i] = (byte) (Math.random() * 255);
                }
                System.out.println("producer data ready");
//                queue.add(new String(bytes));
                put(new String(bytes), queue);
                System.out.println("producer, spend: " + (System.currentTimeMillis() - time) + ", size: " + queue.size());
//                boolean success = queue.offer(new String(bytes));
//                boolean success = offer(new String(bytes), queue, 10_000);
//                System.out.println("producer, spend: " + (System.currentTimeMillis() - time) + ", size: " + queue.size() + ", success: " + success);
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                sleep(20_000);
                System.out.println("consumer start");
                long time = System.currentTimeMillis();
//                String result = poll(queue, 1_000);
                String result = take(queue);
                if (null != result) {
                    System.out.println("consumer result length " + result.length()+", spend: " + (System.currentTimeMillis() - time));
                } else {
                    System.out.println("consumer result length 0, spend: " + (System.currentTimeMillis() - time));
                }
            }
        });
        t1.start();
        t2.start();
    }
    private static void put(String element, BlockingQueue<String> queue) {
        try {
            queue.put(element);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean offer(String element, BlockingQueue<String> queue, long timeout) {
        try {
            return queue.offer(element, timeout, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private static String poll(BlockingQueue<String> queue, long timeout) {
        try {
            return queue.poll(timeout, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private static String take(BlockingQueue<String> queue) {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
