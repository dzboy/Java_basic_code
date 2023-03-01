package com.ysoyso.collection.views;

import java.util.*;

public class ViewDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 4, 6, 9);
        System.out.println(list);
        for (int i : list) {
            System.out.println(i);
        }
        List<Integer> list1 = List.of(1, 2, 5, 7, 8, 10);
        System.out.println(list1);

        Set<String> set = Set.of("q", "w", "we");
        System.out.println(set);
//        set.add("r");

        Map<Integer, String> map = Map.of(1, "a", 2, "3", 3, "r");
        System.out.println(map);

        Map<Integer, String> map1 = Map.ofEntries(Map.entry(1, "a"), Map.entry(2, "b"), Map.entry(3, "r"));
        System.out.println(map1);

        List<Integer> subList = list.subList(0, 2);
        System.out.println(subList);
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.addAll(Set.of(1, 2, 4, 5, 7, 8, 9, 6, 19));
        Set<Integer> subSet = treeSet.subSet(2, 9);
        System.out.println(subSet);
        Set<Integer> subSet1 = treeSet.headSet(8);
        System.out.println(subSet1);
        Set<Integer> subSet2 = treeSet.tailSet(8);
        System.out.println(subSet2);

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "1");
        treeMap.put(2, "2");
        treeMap.put(3, "3");
        treeMap.put(4, "4");
        treeMap.put(9, "9");
        treeMap.put(5, "5");
        treeMap.put(10, "10");
        Map<Integer, String> subMap = treeMap.subMap(2, 9);
        System.out.println(subMap);


        Map<Integer, String> unMap = Collections.unmodifiableMap(treeMap);
//        unMap.put(1, "1");
//        unMap.put(12, "12");
        List<Integer> unList = Collections.unmodifiableList(list1);
//        unList.add(1);
    }
}
