package com.ysoyso.thread.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SynchronizedXXXDemo {
    public static void main(String[] args) throws InterruptedException {
        List<String> syncList = Collections.synchronizedList(new LinkedList<>());
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                syncList.add(i + "");
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                syncList.add(i + "");
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(syncList.size());
    }
}
