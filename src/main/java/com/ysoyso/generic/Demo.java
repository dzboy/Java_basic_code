package com.ysoyso.generic;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ListWrapper<Person> listWrapper = new ListWrapper<>();
        List<Person> list = listWrapper.list;
        list.add(new Person(10));
        list.add(new Person(6));
        list.add(new Person(20));
        list.add(new Person(14));
        listWrapper.sort();

        System.out.println(list);
    }

    private void test() {
        ListDemo<Integer> listDemo = new ListDemo<>();
        listDemo.add(0, 10);
        listDemo.add(1, 20);
        listDemo.add(2, 11);
        int val = listDemo.get(1);
        System.out.println(val);

        ListDemo<String> listDemoString = new ListDemo<>();
        listDemoString.add(0, "s10");
        listDemoString.add(1, "s20");
        listDemoString.add(2, "s11");
        String str = listDemoString.get(1);
        System.out.println(str);

        ListDemo<Pair<Integer, String>> pairListDemo = new ListDemo<>();
        pairListDemo.add(0, new Pair<>(0, "H"));
        pairListDemo.add(1, new Pair<>(12, "E"));
        pairListDemo.add(2, new Pair<>(36, "L"));
        Pair<Integer, String> pair = pairListDemo.get(1);
        System.out.println("key:" + pair.key + " val:" + pair.val);
    }
}
