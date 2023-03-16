package com.ysoyso.thread.thread;

public class UncaughtExceptionDemo {
    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                StackTraceElement[] elements = e.getStackTrace();
                if (null != elements[0]) {
                    StackTraceElement ele = elements[0];
                    System.err.println(t.getName() + " " + " [" + ele.getFileName() + "][" + ele.getClassName() + "][" + ele.getMethodName()+"] : "  + e.getMessage() + ":" + elements[0].getLineNumber());
                }
            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("这是一个异常");
            }
        });
        thread.start();

        int i = 0;
        int re = 10 / i;
    }
}
