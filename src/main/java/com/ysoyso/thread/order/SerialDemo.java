package com.ysoyso.thread.order;

/**
 * 指令重排序
 */
public class SerialDemo {
    static int i;
    static int j;
    public static void main(String[] args) {
        // 在某个线程内执行如下赋值操作
        i = 1;
        j = 2;
        //可以看到，至于是先执行 i 还是 先执行 j ，对最终的结果不会产生影响。所以，上面代码真正执行时，既可以是
        i = 1;
        j = 2;
        //也可以是
        j = 2;
        i = 1;
        System.out.println(i);
        System.out.println(j);


        new Thread(() -> {
            i = 1;
            j = 2;
        }).start();
        new Thread(() -> {
            System.out.println(i);
            System.out.println(j);
        });
    }
}
