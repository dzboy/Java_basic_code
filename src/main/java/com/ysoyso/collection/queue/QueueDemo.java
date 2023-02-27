package com.ysoyso.collection.queue;

import java.util.*;

public class QueueDemo {
    static class Age {
        int age;

        public Age(int age) {
            this.age = age;
        }

//        @Override
//        public int compareTo(Age o) {
//            if (null == o) {
//                return -1;
//            }
//            return age - o.age;
//        }

        @Override
        public String toString() {
            return age + "";
        }

    }
    public static void main(String[] args) {
        PriorityQueue<Age> queue = new PriorityQueue<>(new Comparator<Age>() {
            @Override
            public int compare(Age o1, Age o2) {
                if (o1 == null || o2 == null) {
                    return -1;
                }
                return o1.age - o2.age;
            }
        });
        queue.offer(new Age(1));
        queue.offer(new Age(20));
        queue.offer(new Age(3));
        queue.offer(new Age(40));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    private void deque() {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerFirst(4);
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
    }

    private void testQueue() {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println("size：" + queue.size());
        System.out.println(queue.poll());
        System.out.println("size：" + queue.size());
        System.out.println(queue.peek());
        System.out.println("size：" + queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println("size：" + queue.size());
        System.out.println(queue.peek());
    }
}
