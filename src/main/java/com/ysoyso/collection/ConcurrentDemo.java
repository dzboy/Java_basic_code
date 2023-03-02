package com.ysoyso.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentDemo {
    public static void main(String[] args) {
//        Map<Integer, Integer> map = new ConcurrentHashMap<>();
//        map.put(1, 1);
//        System.out.println(map);
//        map.put(null, null);
//        map.put(null, 1);
//        map.put(1, null);

//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(null, 1);
//        map.put(1, null);
//        System.out.println(map);

//        List<Integer> list = new CopyOnWriteArrayList<>();
//        list.add(1);
//        System.out.println(list);


        Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());
        map.put(1, 1);
        map.get(1);
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

    }
}
