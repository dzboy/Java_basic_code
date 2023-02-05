package com.ysoyso.clazz.load;

public class Base {
    static {
        System.out.println("Base 静态代码块");
    }

    {
        System.out.println("Base 代码块");
    }

    public Base() {
        System.out.println("Base 构造方法");
    }
}
