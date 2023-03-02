package com.ysoyso.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class SortDemo {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person person = new Person(20, 200);
        list.add(new Person(10, 100));
        list.add(person);
        list.add(new Person(1, 10));
        list.add(new Person(3, 300));
//        list.sort(Comparator.naturalOrder());
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                return o1.salary - o2.salary;
            }
        });
        Collections.shuffle(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
        int index = Collections.binarySearch(list, person);
        System.out.println(index);
    }

    static class Person implements Comparable<Person> {
        int age;
        int salary;

        public Person(int age) {
            this.age = age;
        }

        public Person(int age, int salary) {
            this.age = age;
            this.salary = salary;
        }

        @Override
        public int compareTo(Person o) {
            if (null == o) {
                return -1;
            }
            return age - o.age;
        }

        @Override
        public String toString() {
            return "age: " + age + " salary: " + salary;
        }
    }

}
