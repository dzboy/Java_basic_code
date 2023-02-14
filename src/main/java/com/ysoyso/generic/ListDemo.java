package com.ysoyso.generic;

public class ListDemo<E> {

    E obj;
    Object[] items = new Object[10];

    public void add(int index, E val) {
        if (index >= items.length) {
            System.out.println("下标越界");
            return;
        }
        items[index] = val;
    }

    public E get(int index) {
        if (index >= items.length) {
            System.out.println("下标越界");
            return null;
        }
        return (E) items[index];
    }

    public void setObj(E obj) {
        this.obj = obj;
    }

    public E getObj() {
        return obj;
    }
}
