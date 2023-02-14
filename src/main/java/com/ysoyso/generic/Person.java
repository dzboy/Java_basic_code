package com.ysoyso.generic;

import java.io.Serializable;

public class Person implements Comparable<Person>, Serializable {
    int age;

    public Person(int age) {
        this.age = age;
    }
    @Override
    public int compareTo(Person o) {
        if (o == null) {
            return -1;
        }
        return o.age - age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
