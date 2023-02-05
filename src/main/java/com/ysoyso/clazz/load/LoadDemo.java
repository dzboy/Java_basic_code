package com.ysoyso.clazz.load;

public class LoadDemo {

    public int age = 50;

    static {
        System.out.println("静态代码块");
    }
    {
        System.out.println("代码块");
        System.out.println(age);
    }

    public LoadDemo() {
        System.out.println("构造方法");
        System.out.println(age);
    }

    public void run() {
        System.out.println("run");
    }

    public static void main(String[] args) {
        LoadDemo loadDemo = new LoadDemo();
        loadDemo.run();
    }
}
