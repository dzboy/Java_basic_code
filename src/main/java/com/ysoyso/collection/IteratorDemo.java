package com.ysoyso.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorDemo {
    public static void main(String[] args) {
        YList<Integer> list = new YList<>(1, 3, 5, 7, 9, 2, 4, 6, 8, 0);
        for (int i : list) {
            System.out.print(i + ", ");
        }
        System.out.println("");
        System.out.println("---------------");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            System.out.print(i + ", ");
        }
        System.out.println("");
        System.out.println("---------------");
        int i = iterator.next();
        System.out.print(i + ", ");
    }

    static class YList<T> implements Iterable<T> {
        T[] ts;
        public YList(T...ts) {
            this.ts = ts;
        }

        @Override
        public Iterator<T> iterator() {
            return new YIterator<>(ts);
        }
    }

    static class YIterator<E> implements Iterator<E> {
        int index = 0;
        E[] ts;
        public YIterator(E[] ts) {
            if (null == ts) {
                return;
            }
            this.ts = ts;
        }

        @Override
        public boolean hasNext() {
            return index < ts.length;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (index >= ts.length) {
                throw new NoSuchElementException("YIterator 已经没有更多元素了");
            }
            return ts[index++];
        }
    }
}
