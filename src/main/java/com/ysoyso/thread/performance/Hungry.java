package com.ysoyso.thread.performance;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Java线程饥饿是指某个或某些线程因为无法获取所需的资源而一直无法执行，导致程序无法继续运行的状态。线程饥饿可能会导致程序出现长时间的停滞
 * 以下是与Java线程饥饿相关的知识点：
 * 死锁：当两个或多个线程相互等待对方释放资源时，就会发生死锁现象。
 * 非公平锁：在使用非公平锁的情况下，如果一个线程试图获取一个正在被其他线程持有的锁，那么该线程可能永远都无法获取到锁。
 * 同步代码块：如果同步代码块中的代码量过多，或者同步代码块中的逻辑复杂，就可能导致其他线程无法获取锁，从而导致饥饿现象。
 * 线程优先级：如果一个线程的优先级较低，而另一个线程的优先级较高，那么较低优先级的线程可能会一直得不到CPU资源，从而无法执行。
 * CPU调度算法：如果采用的CPU调度算法不合理，可能会导致某些线程一直无法得到运行机会，从而出现饥饿现象。
 */
public class Hungry {
    public static void main(String[] args) {
        waitResource();
//        waitBlock();
    }
    public static void waitBlock() {
        // 创建一个有界阻塞队列，容量为1
        final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

        // 创建两个线程并启动
        new Thread(() -> {
            while (true) {
                try {
                    // 往阻塞队列中添加元素
                    queue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    // 从阻塞队列中取出元素并进行处理
                    Integer value = queue.take();
                    System.out.println(Thread.currentThread().getName() + " 处理了元素：" + value);

                    // 让当前线程休眠一段时间
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public static void waitResource() {

        // 创建一个共享资源对象
        final SharedResource sharedResource = new SharedResource();

        // 创建多个线程并启动
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (sharedResource) {
                        // 执行一些需要共享资源的操作
                        // ...

                        // 让当前线程休眠一段时间
                        System.out.println(Thread.currentThread().getName() + " get resource");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    // 共享资源类
    static class SharedResource {
        // ...
    }
}
