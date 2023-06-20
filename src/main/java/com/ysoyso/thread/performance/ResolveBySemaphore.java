package com.ysoyso.thread.performance;

import java.util.concurrent.Semaphore;

public class ResolveBySemaphore {
    private static final Semaphore semaphoreA = new Semaphore(1);
    private static final Semaphore semaphoreB = new Semaphore(1);
    public static void main(String[] args) throws InterruptedException {
//        deadLock();
        resolve();
    }

    private static void deadLock() {
        // 使用Semaphore避免死锁
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphoreA.acquire();
                    System.out.println("Thread 1 acquired semaphore A");
                    Thread.sleep(100);
                    semaphoreB.acquire();
                    System.out.println("Thread 1 acquired semaphore B");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphoreB.release();
                    semaphoreA.release();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphoreB.acquire();
                    System.out.println("Thread 2 acquired semaphore B");
                    Thread.sleep(100);
                    semaphoreA.acquire();
                    System.out.println("Thread 2 acquired semaphore A");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphoreA.release();
                    semaphoreB.release();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
    public static void resolve() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphoreA.acquire();
                    System.out.println("Thread 1 acquired semaphore A");
                    Thread.sleep(100);

                    while (!semaphoreB.tryAcquire()) {
                        semaphoreA.release();
                        System.out.println("Thread 1 released semaphore A and waiting for semaphore B");
                        semaphoreA.acquire();
                        System.out.println("Thread 1 acquired semaphore A again");
                    }

                    System.out.println("Thread 1 acquired semaphore B");
                    Thread.sleep(100);

                    semaphoreB.release();
                    System.out.println("Thread 1 released semaphore B");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphoreA.release();
                    System.out.println("Thread 1 released semaphore A");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphoreB.acquire();
                    System.out.println("Thread 2 acquired semaphore B");
                    Thread.sleep(100);

                    while (!semaphoreA.tryAcquire()) {
                        semaphoreB.release();
                        System.out.println("Thread 2 released semaphore B and waiting for semaphore A");
                        semaphoreB.acquire();
                        System.out.println("Thread 2 acquired semaphore B again");
                    }

                    System.out.println("Thread 2 acquired semaphore A");
                    Thread.sleep(100);

                    semaphoreA.release();
                    System.out.println("Thread 2 released semaphore A");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphoreB.release();
                    System.out.println("Thread 2 released semaphore B");
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
