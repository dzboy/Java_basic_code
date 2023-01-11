package com.ysoyso.data;

import java.util.Arrays;

/**
 * [5, 4, 4, 9, 1, 4, 9, 5, 8, 2]
 * 一维数组
 * 多维数组
 * Arrays.toString()
 * Arrays.sort()
 * Arrays.binarySearch()
 * Arrays.copyOfRange()
 * Arrays.deepToString()
 */
public class ArrayDemo {
    public static void main(String[] args) {
//        int[] a = new int[12];
//        System.out.println(a.length);
//        a[0] = 10;
//        System.out.println(Arrays.toString(a));
//
//        String[] strings = new String[10];
//        System.out.println(Arrays.toString(strings));
//
//        for (int i = 0; i < a.length; i++) {
//            a[i] = i * 2;
//        }
//        System.out.println(Arrays.toString(a));
//
//        int[] b = new int[]{1, 2, 6, 7, 8};
//        System.out.println(b.length);
//        System.out.println(Arrays.toString(b));

//        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {0, 1, 2}};
//        int[] a0 = a[0];
//        System.out.println(Arrays.toString(a0));
//        int[] a1 = a[1];
//        System.out.println(Arrays.toString(a1));
//        int a10 = a[1][0];
//        System.out.println(a10);
//
//        int[] b = a[1];
//        int b0 = b[0];
//        System.out.println(b0);
//
//        int c = a[3][1];
//        System.out.println(c);
//
//        a[3][0] = 10;
//        System.out.println(Arrays.deepToString(a));
//
//        int[][][] d = new int[][][]{{{1, 2},{3, 4}},{{5, 6},{7, 8}},{{9, 0},{10, 11}}};
//        System.out.println(Arrays.deepToString(d));

//        int[][][] a = new int[5][3][2];
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[i].length; j++) {
//                for (int k = 0; k < a[i][j].length; k++) {
//                    a[i][j][k] = (int) (Math.random() * 100);
//                }
//            }
//        }
//        System.out.println(Arrays.deepToString(a));

        /*
         * Arrays.toString()
         * Arrays.deepToString()
         * Arrays.sort()
         * Arrays.binarySearch()
         * Arrays.copyOfRange()
         */

//        float f = 10.1234567f;
//        System.out.println(f);
//        System.out.println((int) f);

//        int[] a = new int[10];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = (int) (Math.random() * 100);
//        }
//
//        System.out.println(Arrays.toString(a));
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));

        int[] a = new int[]{5, 4, 4, 9, 1, 4, 9, 5, 8, 2};
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));
//        int index = Arrays.binarySearch(a, 5);
//        System.out.println(index);

        int[] b = Arrays.copyOf(a, 5);
        System.out.println(Arrays.toString(b));

        int[] c = Arrays.copyOfRange(a, 3, 7);
        System.out.println(Arrays.toString(c));
    }

}
