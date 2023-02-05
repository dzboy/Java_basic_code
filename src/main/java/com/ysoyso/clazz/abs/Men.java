package com.ysoyso.clazz.abs;

public class Men extends Person{
    public Men() {
        sex = 1;
    }

    @Override
    public void run() {
        System.out.println("我跑的快");
    }
}
