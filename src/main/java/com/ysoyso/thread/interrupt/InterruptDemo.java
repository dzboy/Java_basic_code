package com.ysoyso.thread.interrupt;

public class InterruptDemo {
    public static void main(String[] args) {
        InterruptRunnable runnable = new InterruptRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class InterruptRunnable implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000 * 2);
                } catch (InterruptedException e) {
                    System.out.println("isInterrupted 1 " + Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    System.out.println("isInterrupted 2 " + Thread.currentThread().isInterrupted());
                }
                Thread.interrupted();
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("isInterrupted");
                    break;
                } else {
                    System.out.println("running");
                }
            }
        }
    }

    private static void cancelByFlag() {

        TaskRunnable runnable = new TaskRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(10000);
            runnable.cancel();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class TaskRunnable implements Runnable {

        boolean cancel;
        @Override
        public void run() {
            while (true) {
                if (cancel) {
                    break;
                }
                try {
                    Thread.sleep(1000 * 60 * 60 * 24);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("running");
            }
        }

        public void cancel() {
            cancel = true;
        }
    }
}
