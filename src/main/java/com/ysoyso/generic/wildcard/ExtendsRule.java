package com.ysoyso.generic.wildcard;

import java.util.ArrayList;
import java.util.List;

public class ExtendsRule {
    public static void main(String[] args) {
        Pair<Dog> dogPair = new Pair<>();
//        Pair<Animal> animalPair = dogPair;

        Pair<Animal> animalPair = new Pair<>();
        animalPair.setT(new Dog());
        animalPair.setT(new Animal());
        Animal animal = animalPair.getT();

        List<Dog> list = new ArrayList<>();
//        List<Animal> animalList = list;
//        setAnimal(list);

//        ArrayList<Dog> list2 = new ArrayList<>();
//        List<Dog> list3 = list2;

//        Pair<Animal> ap = new Pair<>();
//        Pair pair = dogPair;
        set(dogPair);
        Object obj = dogPair.getT();
        if (obj instanceof Dog) {
            Dog dog = dogPair.getT();
        }

        Dog[] dogs = new Dog[10];
        Animal[] animals = dogs;
    }

    private static void set(Pair pair) {
        pair.setT("hello");
    }

    private static void setAnimal(List<Animal> list) {

    }
}
