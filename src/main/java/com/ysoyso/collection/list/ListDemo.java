package com.ysoyso.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class ListDemo {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
//        for (int i : list) {
//            list.add(2);
//        }

        ListIterator<Integer> iterator = list.listIterator();
        int i = 10;
        while (iterator.hasNext() && i > 0) {
            list.add(10 - i);
            i--;
        }
        System.out.println(list);
    }

    private void arrayList() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(1, 100);
        System.out.println(list1);
        System.out.println(list1.get(3));
        list1.remove(4);
        System.out.println(list1);
    }

    private void testTime() {
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list1.add(i);
            list.add(i);
        }

        long time = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 100000; j++) {
                list.get(j);
            }
        }
        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 100000; j++) {
                list1.get(j);
            }
        }
        System.out.println(System.currentTimeMillis() - time);
    }

    private void test() {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.addFirst(-1);
        list.addFirst(-2);
//        System.out.println(list);
//
        ListIterator<Integer> iterator = list.listIterator();
        iterator.add(100);
        iterator.add(101);
        iterator.next();
        iterator.add(102);
        iterator.previous();
        iterator.add(103);
        int nextIndex = iterator.nextIndex();
        int previousIndex = iterator.previousIndex();
        iterator.next();
        iterator.set(0);
        System.out.println(nextIndex + "  " + previousIndex);
        System.out.println(list);

//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

//        for (int i : list) {
//            System.out.println(i);
//        }
    }
}
