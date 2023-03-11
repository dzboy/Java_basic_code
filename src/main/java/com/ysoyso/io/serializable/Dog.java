package com.ysoyso.io.serializable;

public class Dog extends Animal {
    Animal friend;

    public Dog(String name, int age, double weight, Animal animal) {
        super(name, age, weight);
        this.friend = animal;
    }

    public Animal getFriend() {
        return friend;
    }

    public void setFriend(Animal friend) {
        this.friend = friend;
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
}
