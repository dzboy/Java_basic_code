package com.ysoyso.generic.disallow;

import java.util.Arrays;

public class ArrayType {
//    @SafeVarargs
//    public static <T> T[] getArr(T... ts) {
//        return ts;
//    }
//
//    public static <T extends Comparable<T>> T[] arr(T...ts) {
////        T[] result = new T[10];
//        Object[] result = new Object[10];
//        int i = 0;
//        for (T t : ts) {
//            result[i++] = t;
//        }
//        return (T[]) result;
//    }
//
    interface Convert<R> {
        R apply(int value);
    }

    @SafeVarargs
    public static <T extends Comparable<T>> T[] arr(Convert<T[]> constr, T...ts) {
//        T[] result = new T[10];
        T[] result = constr.apply(10);
        int i = 0;
        for (T t : ts) {
            result[i++] = t;
        }
        return result;
    }
//
    static class Pair<T> {
        T t;

        public Pair(T t) {
            this.t = t;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "t=" + t +
                    '}';
        }
    }

    public static void main(String[] args) {
//        Pair<String> pair[] = new Pair<String>[10];
//        pair[0] = new Pair<>("hello");
//        pair[1] = new Pair<Integer>(1);
//        System.out.println(pair[0]);
//        Object obj[] = new Object[10];
//        obj[1] = new Pair<>(1);
//        System.out.println(Arrays.toString(pair));
//
//        Pair<String>[] pairs = ArrayType.getArr(new Pair<>("h"), new Pair<>("e"));
//        System.out.println(Arrays.toString(pairs));
//        Object obj[] = pairs;
//        obj[0] = new Pair<>(1);
//        System.out.println(obj[0]);
//
//        String[] strings = ArrayType.getArr("h", "e", "llo");
//        String[] strings = ArrayType.arr("h", "e", "llo");
//        System.out.println(Arrays.toString(strings));

        Convert<String[]> convert = new Convert<String[]>() {

            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        };
//        String[] str = convert.apply(10);
//        System.out.println(Arrays.toString(str));

        String[] strings = ArrayType.arr(convert, "h", "e", "llo");
        System.out.println(Arrays.toString(strings));
    }
}
