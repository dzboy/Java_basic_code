package com.ysoyso.generic.wildcard;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Test {

    public static void main(String[] args) {
        Pair<Dog> dogPair = new Pair<>();
        dogPair.setT(new Dog());
//        Pair<? extends Animal> aniPair = dogPair;
//        printAnimal(dogPair);
        printAnimal2(dogPair);
        System.out.println("#########################");
        Pair<? extends Animal> animalPair = new AnimalPair();
//        animalPair.setT(new Animal());
//        animalPair.setT(new Dog());
//        animalPair.setT(new Object());
//        animalPair.compare(new Animal());
        animalPair.setT(null);
        Dog dog = (Dog) animalPair.getT();

        Pair<? super Animal> dogSuperPair = new AnimalPair();
        dogSuperPair.setT(new Animal());
        dogSuperPair.setT(new Dog());
//        dogSuperPair.setT(new Object());
        dogSuperPair.setT(null);
        Animal animal = (Animal) dogSuperPair.getT();
//        Dog dog1 = dogSuperPair.getT();
        test();
        testWildcard();
        testSwap();
    }

    private static void printAnimal(Pair<Animal> pair) {
        Animal animal = pair.getT();
        System.out.println(animal.toString());
    }


    private static void printAnimal2(Pair<? extends Animal> pair) {
        Animal animal = pair.getT();
        System.out.println(animal.toString());
    }
    static class House implements Comparable<House> {
        @Override
        public int compareTo(House o) {
            return 0;
        }
    }

    static class AnimalHouse extends House {
    }

    public static <T extends Comparable<? super T>> T getHouse(T t) {
        return t;
    }

    public static <T extends Comparable<? super T>> Comparable<? super T> getHouse1(T t) {
        return t;
    }

    private static void test() {
        System.out.println("######## test super");
        House house1 = getHouse(new House());
        AnimalHouse house2 = getHouse(new AnimalHouse());

        Comparable<? super House> comparable1 = getHouse1(new House());
        Comparable<? super AnimalHouse> comparable2 = getHouse1(new AnimalHouse());

        Comparable<? super House> c4 = new House();
        Comparable<? super AnimalHouse> c1 = new AnimalHouse();


        Comparable<? super AnimalHouse> c2 = new AnimalHouse();
        Comparable<? super House> c3 = new House();

        List<Comparable<? super House>> list = new ArrayList<>();
        list.add(new AnimalHouse());
        list.add(new House());
        System.out.println(list);
    }

    private static void testWildcard() {
        System.out.println("######## test wildcard");
        List<Comparable<?>> list = new ArrayList<>();
        list.add(new House());
        list.add(new AnimalHouse());
        Comparable<?> comparable = list.get(0);
//        Comparable<House> comparable1 = list.get(0);

        System.out.println(list);

        Pair<Animal> pair = new Pair<>();
        pair.setT(new Dog());
        String clazz = check(pair);
        System.out.println(clazz);
        String clazz2 = check2(pair);
        System.out.println(clazz2);
    }

    private static String check(Pair<?> pair) {
        System.out.println("######## check pair");
        Object o = pair.getT();
        return o.getClass().getName();
    }

    private static <T> String check2(Pair<T> pair) {
        System.out.println("######## check pair");
        T o = pair.getT();
        return o.getClass().getName();
    }

    private static void testSwap() {
        System.out.println("######## testSwap");
        Pair<Animal> pair = new Pair<>();
        pair.setT(new Animal());

        Pair<?> pair1 = pair;
        print2(pair1);

//        print(pair);

//        Pair<?> wildcardPair = new Pair<>();
//        wildcardPair.setT(new Animal());
//        wildcardPair.setT(null);
//        print2(wildcardPair);

        List<Comparable<? super AnimalHouse>> list = new ArrayList<>();
        list.add(new AnimalHouse());
        list.add(new House());
//        ? super AnimalHouse obj1 = list.get(0);
//        ? super AnimalHouse obj2 = list.get(1);
//        AnimalHouse obj1 = list.get(0);
//        AnimalHouse obj2 = list.get(1);
//        list.clear();
//        list.add(obj2);
//        list.add(obj1);

        System.out.println(list);
        swap(list);
        System.out.println(list);

    }
    private static void print(Pair<?> p1) {
//        ? obj1 = p1.getT();
        print2(p1);
    }
    private static <T> void print2(Pair<T> p1) {
        T t = p1.getT();
        System.out.println(t.getClass().getSimpleName());
    }

    private static <T> void swap(List<T> list) {
        T obj1 = list.get(0);
        T obj2 = list.get(1);
        list.clear();
        list.add(obj2);
        list.add(obj1);
    }

}
