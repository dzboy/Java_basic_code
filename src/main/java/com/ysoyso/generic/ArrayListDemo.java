package com.ysoyso.generic;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(6);
        int val = list.get(2);
        System.out.println(val);
        System.out.println(list);

        ArrayList<String> strList = new ArrayList<>();
        strList.add("s1");
        strList.add("s3");
        strList.add("s6");
        String str = strList.get(2);
        System.out.println(str);
        System.out.println(strList);


        ArrayList<Pair<Integer, String>> pairList = new ArrayList<>();
        pairList.add(new Pair<>(0, "H"));
        pairList.add(new Pair<>(12, "E"));
        pairList.add(new Pair<>(36, "L"));
        Pair<Integer, String> pair = pairList.get(2);
        System.out.println("key:" + pair.key + " val:" + pair.val);

    }
}
