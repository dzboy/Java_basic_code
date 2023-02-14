package com.ysoyso.generic;

public class Func {
    public Object obj;

    public <E, T extends Comparable<E>> void setObj(T obj) {
        this.obj = obj;
    }

    public <T> T getObj() {
        return (T) obj;
    }

    public static void main(String[] args) {
        Func func = new Func();
        func.setObj(new Person(1));
        Person person = func.getObj();
        System.out.println(person);
    }

}
