package com.ysoyso.reflection;

import java.util.List;

public class SomeClass<T> implements Comparable<SomeClass> {
    private T t;

    private String fieldName;

    public SomeClass() {
        System.out.println("default constructor");
    }

    public SomeClass(String fieldName) {
        System.out.println("1 param constructor");
        this.fieldName = fieldName;
    }

    public SomeClass(String fieldName, T t) {
        this.fieldName = fieldName;
        this.t = t;
    }

    private String methodNamePrivate() {
        System.out.println("hello world!!!");
        return "private method name";
    }

    public String methodName(String str) {
        this.fieldName = str;
        System.out.println("hello world");
        return "method name " + str;
    }

    public void setValue(List<String> list) {

    }


    @Override
    public int compareTo(SomeClass o) {
        return 0;
    }
}
