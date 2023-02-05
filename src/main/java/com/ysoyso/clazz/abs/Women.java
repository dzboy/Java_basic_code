package com.ysoyso.clazz.abs;

public class Women extends Person{
    public Women() {
        sex = 0;
    }

    @Override
    public void run() {
        System.out.println("跑得慢");
    }
}
