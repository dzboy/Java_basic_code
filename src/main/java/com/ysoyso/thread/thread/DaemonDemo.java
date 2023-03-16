package com.ysoyso.thread.thread;

public class DaemonDemo {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(getName() + " " + i);
                }
            }
        };
        thread.setName("thread-A");
        thread.start();

        Thread daemonThread = new Thread() {
            @Override
            public void run() {
                super.run();
                Thread subThread = new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        while (true) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println(getName() + " " + System.currentTimeMillis() + " " + isDaemon());
                        }
                    }
                };
                subThread.start();

            }
        };
        daemonThread.setName("DaemonThread");
        daemonThread.setDaemon(true);
        daemonThread.start();
    }
}
