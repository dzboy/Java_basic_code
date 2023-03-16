package com.ysoyso.thread.thread;

public class Demo {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
//                Thread.yield();
                System.out.println(getName());
            }
        };

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println(getName());
            }
        };
//        thread1.setPriority(Thread.MAX_PRIORITY);
        thread.setName("thread-A");
        thread1.setName("thread-B");
        thread.start();
        thread1.start();
    }

    public static void create() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + " " + i);
                }
            }
        };
        thread.setName("thread-A");
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + " " + i);
                }
            }
        };
        thread1.setName("thread-B");
        thread.start();
        thread1.start();
    }
}
