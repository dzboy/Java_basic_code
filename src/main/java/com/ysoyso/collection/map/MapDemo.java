package com.ysoyso.collection.map;

import java.util.*;
import java.util.function.BiFunction;

public class MapDemo {
    public static void main(String[] args) {
        Map<Person, Integer> hashMap = new HashMap<>();
        Map<Person, Integer> identityHashMap = new IdentityHashMap<>();
        hashMap.put(new Person(1), 1);
        hashMap.put(new Person(2), 2);
        hashMap.put(new Person(1), 3);
        System.out.println(hashMap);
        System.out.println("------------");
        identityHashMap.put(new Person(1), 1);
        identityHashMap.put(new Person(2), 2);
        identityHashMap.put(new Person(1), 3);
        System.out.println(identityHashMap);

    }


    static class Person {
        int age;

        public Person(int age) {
            this.age = age;
        }
        @Override
        public String toString() {
            return age + "";
        }

        @Override
        public int hashCode() {
            return age;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (null == obj || obj.getClass() != this.getClass()) {
                return false;
            }
            Person person = (Person) obj;
            return person.age == this.age;
        }
    }

    private void linkedHashMap() {

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("hello", 100);
        map.put("world", 200);
        map.put("1", 300);
        System.out.println(map);
    }

    private void treeMap() {

        Map<Person, Integer> map = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (null == o1) {
                    return -1;
                }
                if (null == o2) {
                    return 1;
                }
                return o2.age - o1.age;
            }
        });
        map.put(new Person(1), 100);
        map.put(new Person(5), 200);
        map.put(new Person(4), 300);
        map.put(new Person(2), 400);
        System.out.println(map);
    }

    private void hashMap() {

        Map<String, Integer> map = new HashMap<>();
        map.put("hello", 100);
        map.put("world", 200);
        map.put("1", 300);
        System.out.println(map);
        System.out.println("----------");
//         for (int i = 0; i < 10; i++) {
//            int v = map.containsKey("a") ? map.get("a") + 1 : 1;
//            map.put("a", v);
//            map.putIfAbsent("a", 0);
//            map.put("a", map.get("a") + 1);
//            map.merge("a", 1, Integer::sum);
//            System.out.println(map.get("a"));
//        }
        map.put("1", 400);
        System.out.println(map);
        map.remove("1");
        System.out.println(map);
    }

}
