package com.ysoyso.io.copy;

import java.io.Serializable;

public class Animal implements Serializable, Cloneable {
    protected String name;
    protected transient int age;
    protected double weight;

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    @Override
    public Animal clone() throws CloneNotSupportedException {
        return (Animal) super.clone();
    }
}
