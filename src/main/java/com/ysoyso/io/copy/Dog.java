package com.ysoyso.io.copy;

public class Dog extends Animal implements Cloneable {
    Animal friend;

    public Dog(String name, int age, double weight, Animal animal) {
        super(name, age, weight);
        this.friend = animal;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "friend=" + friend +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    @Override
    public Dog clone() throws CloneNotSupportedException {
        Dog dog = (Dog) super.clone();
        dog.friend = this.friend.clone();
        return dog;
    }
}
