package com.ysoyso.clazz.abs;

public abstract class Person {
    protected int age;
    protected int sex;

    public void say() {
        String sexStr;
        if (sex == 1) {
            sexStr = "男孩儿";
        } else {
            sexStr = "女孩儿";
        }
        System.out.println("我的年龄：" + age + " 我是" + sexStr);
    }

    public abstract void run();
}
