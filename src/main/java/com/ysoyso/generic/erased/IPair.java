package com.ysoyso.generic.erased;

import java.io.Serializable;

public class IPair<T extends Serializable & Comparable<Employee>> {

    private T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
