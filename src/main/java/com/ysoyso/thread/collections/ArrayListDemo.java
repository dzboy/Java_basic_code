package com.ysoyso.thread.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayListDemo {
    public static void main(String[] args) throws InterruptedException {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.ensureCapacity(20000); // 加上这行就不会报错了，因为不需要扩容，但数量会少
        List<Integer> list = new CopyOnWriteArrayList<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Size of the list: " + list.size());
    }


//    Exception in thread "Thread-0" java.lang.ArrayIndexOutOfBoundsException: 163
//    at java.util.ArrayList.add(ArrayList.java:463) // 如下ArrayList中的代码，在elementData[size++] = e;处报错
//    at com.ysoyso.thread.collections.ArrayListDemo.lambda$main$0(ArrayListDemo.java:12)
//    at java.lang.Thread.run(Thread.java:748)

//    --------------ArrayList--------------
//    public boolean add(E e) {
//        ensureCapacityInternal(size + 1);  //  t1和t2都到达这个位置，此时size + 1刚好是数组最后一个位置，不用扩容
//        elementData[size++] = e; // t1和t2都到达这个位置，t1先size++，此时size是最后一个index，t2再size++就会越界
//        return true;
//    }

//    --------------CopyOnWriteArrayList--------------
//    public boolean add(E e) {
//        final ReentrantLock lock = this.lock;
//        lock.lock();
//        try {
//            Object[] elements = getArray();
//            int len = elements.length;
//            Object[] newElements = Arrays.copyOf(elements, len + 1);
//            newElements[len] = e;
//            setArray(newElements);
//            return true;
//        } finally {
//            lock.unlock();
//        }
//    }

}
