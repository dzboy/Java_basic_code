package com.ysoyso.introduction;

/**
 * 类注释，第一行java代码介绍
 *
 * @author dzboy
 * @version 1.0
 * @since 1.0
 */
public class Main {
    /**
     * java doc 多行注释
     */
    public static void say() {
        /*
        多行注释
         */
        System.out.println("Hello World");
    }
    public static void main(String[] args) {
        // 单行注释
        say();
        Car.bibi();
        String position = Car.showPosition();
        System.out.println(position);
    }
}
