package com.ysoyso.thread.performance;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueDead {
    private final int capacity = 5;
    private final LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(capacity);

    public void produce() throws InterruptedException {
        while (true) {
            System.out.println("Consumer will put");
            synchronized (this) {
                while (queue.size() == capacity) {
                    wait();
                }
                Thread.sleep(100);
                int num = (int) (Math.random() * 10);
                System.out.println("Produced: " + num);
                queue.put(num);
                notifyAll();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            System.out.println("Consumer will take");
            synchronized (this) {
                while (queue.isEmpty()) {
                    wait();
                }
                Thread.sleep(100);
                System.out.println("Consumer take");
                Integer num = queue.take();
                System.out.println("Consumed: " + num);
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        QueueDead pc = new QueueDead();

        Thread t1 = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
