package com.ysoyso.thread.interrupt;

public class Demo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                DoSomethingUtils.doSomething();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // 正常执行的逻辑
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("释放资源、结束任务或恢复任务");
            } else {
                System.out.println("线程正常结束");
            }
        });
        thread.setName("thread-do-something");
        thread.start();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            thread.interrupt();
        }).start();
    }
}
