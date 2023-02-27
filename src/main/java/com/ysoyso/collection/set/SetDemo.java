package com.ysoyso.collection.set;

import java.util.*;

public class SetDemo implements Comparable<SetDemo> {
    int count;

    public SetDemo(int count) {
        this.count = count;
    }
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(10);
        linkedHashSet.add(-1);
        linkedHashSet.add(3);
        linkedHashSet.add(2);
        System.out.println(linkedHashSet);
    }

    private void treeMap() {

//        TreeSet<SetDemo> treeSet = new TreeSet<>();
//        treeSet.add(new SetDemo(1));
//        treeSet.add(new SetDemo(10));
//        treeSet.add(new SetDemo(-1));
//        treeSet.add(new SetDemo(3));
//        treeSet.add(new SetDemo(2));
//
//        System.out.println(treeSet);

        TreeSet<SetDemo> treeSet1 = new TreeSet<>(new Comparator<SetDemo>() {
            @Override
            public int compare(SetDemo o1, SetDemo o2) {
                if (o1 == null || o2 == null) {
                    return 0;
                }
                return o1.count - o2.count;
            }
        });
        treeSet1.add(new SetDemo(1));
        treeSet1.add(new SetDemo(10));
        treeSet1.add(new SetDemo(-1));
        treeSet1.add(new SetDemo(3));
        treeSet1.add(new SetDemo(2));
        System.out.println(treeSet1);
    }

    private void hashSet() {

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(10);
        hashSet.add(11);
        hashSet.add(20);
        hashSet.add(110);
        hashSet.add(120);
        System.out.println(hashSet);

        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("---------------");
        for (int i : hashSet) {
            System.out.println(i);
        }
    }

    @Override
    public int compareTo(SetDemo o) {
        if (null == o) {
            return 0;
        }
        return o.count - count;
    }

    @Override
    public String toString() {
        return count + " ";
    }
}
