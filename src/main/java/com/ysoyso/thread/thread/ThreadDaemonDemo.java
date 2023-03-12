package com.ysoyso.thread.thread;

public class ThreadDaemonDemo {

    public static void main(String[] args) {

    }

    static class DaemonRunnable implements Runnable {

        @Override
        public void run() {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        Thread.yield();
                    }
                }
            });
            System.out.println(t.getName() + " " + t.isDaemon());

        }
    }
}
