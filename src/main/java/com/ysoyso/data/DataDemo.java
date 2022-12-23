package com.ysoyso.data;

public class DataDemo {

    /**
     * bit 位
     * byte 字节 1byte = 8bit
     * KB 1KB = 1024byte
     * MB 1MB = 1024KB
     * GB 1GB = 1024MB
     *
     * @param args
     */
    public static void main(String[] args) {

        // 原码：高位表示符号位，其他位表示数值位数
        // 反码：在原码基础上，符号位不动，数值为取反，得到反码
        // 补码：在反码的基础上+1，得到的就是原码的补码

        // 1 字节 = 8bit
        // 01111111
        // 10000000
        // 01111111
        // 10000000
        // -128 ~ 127
        byte b = 1;
        // 2 字节
        short s = 1;
        // 4 字节
        int i = 1;
        // 8 字节
        long l = 1;

        // 4字节
        float f = 1.0F;
        // 8字节
        double d = 2.0;

        char c = 'c';

        boolean flag = true;
        boolean flag2 = false;


    }
}
