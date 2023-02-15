package com.ysoyso.generic.erased;

public class Pair<T> {
    protected T t;

    public void setT(T t) {
        System.out.println("Pair setT");
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
