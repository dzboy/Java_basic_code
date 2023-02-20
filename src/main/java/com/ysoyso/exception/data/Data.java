package com.ysoyso.exception.data;

public class Data {
    /**
     * 契约式编程
     * input int data
     * @param i i > 0
     */
    public static void put(int i) {
        // 防御式编程
//        if (i <= 0) {
//            return;
//        }
        // 前置校验
        assert i > 0;
        System.out.println("输入了 " + i);
    }
}
