package com.ysoyso.data;

public class DataDemo {
    /**
     * bit 位
     * byte 字节 1byte = 8bit
     * KB 1KB = 1024byte
     * MB 1MB = 1024KB
     * GB 1GB = 1024MB
     * TB 1TB = 1024GB
     * @param args
     */
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        byte b1 = 1;
        byte b2 = 1;
        System.out.println(b1 + b2);
        short s1 = 2;
        short s2 = 1;
        System.out.println(s2 - s1);
        int i1 = 100;
        int i2 = 10;
        System.out.println(i1 * i2);
        long l1 = 100;
        long l2 = 10;
        System.out.println(l1 / l2);
        float f = 100.01F;
        System.out.println(f / i2);

        char c = 'c';
        System.out.println(c);
        int ci = c;
        System.out.println(ci);
        int ci2 = Integer.valueOf(c);
        System.out.println(ci2);

        char a = 'A';
        System.out.println(a);
        int ai = a;
        System.out.println(ai);

        boolean flag = true;
        System.out.println(flag);

    }

    private static void data() {
        // 1byte
        byte b = 1;
        // 2byte
        short s = 1;
        // 4byte
        int i = 1;
        // 8byte
        long l = 1;

        // 4byte
        float f = 1.0f;
        // 8byte
        double d = 1.0;

        // 2byte
        char c = 'c';

        boolean flag = true;
        boolean flag1 = false;
    }
}
