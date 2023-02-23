package com.ysoyso.collection.list;

public class LinkedDemo<T> {

    public static void main(String[] args) {
        LinkedDemo<Integer> list = new LinkedDemo<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(6);
        list.addFirst(-1);
        list.addFirst(-2);
        list.addFirst(-6);

        Node<Integer> node = list.head;
        while (null != node) {
            System.out.println(node.data);
            node = node.next;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    //       temp
    // 1 <   > 2 <   > 3
    // head
    //               tail
    public void add(T t) {
        Node<T> temp = tail;

        Node<T> node = new Node<>();
        node.data = t;
        node.prev = temp;

        if (temp == null) {
            head = node;
        } else {
            temp.next = node;
        }
        tail = node;
    }

    //            temp
    //     -2 <  > -1 <  > 1
    //                 tail
    //    head
    public void addFirst(T t) {
        Node<T> temp = head;

        Node<T> node = new Node<>();
        node.data = t;
        node.next = temp;

        if (temp == null) {
            tail = node;
        } else {
            temp.prev = node;
        }
        head = node;
    }


    static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;
    }
}
