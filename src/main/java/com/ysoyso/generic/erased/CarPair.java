package com.ysoyso.generic.erased;

public class CarPair<T extends Car> {
    private T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
