package com.ysoyso.data;

/**
 * 解释二进制<br />
 * <ul>
 *     <li>手指计数 vs 鸟翅膀计数</li>
 *     <li>2进制</li>
 *     <li>2进制转10进制</li>
 *     <li>2进制运算、常见用法</li>
 *     <li>16位寄存器，计数个数、值的范围</li>
 * </ul>
 *
 */
public class BinaryDemo {
    public static void main(String[] args) {
        // 0 1 2 3 4 5 6 7 8 9
        // 10 11 12 13 14 15 16 17 18 19
        // ....
        // 101 102 103...

        // 0 1
        // 10 11
        // 100 101
        // 110 111

        /*
             1         0        1
         1 * 2^2 + 0 * 2^1 + 1 * 2^0 = 5
             1       1         1
         1 * 2^2 + 1 * 2^1 + 1 * 2^0 = 7
         */

        // 0 0 0 0 2^n
        // 与 &
        int i1 = binary("100");
        int i2 = binary("101");
        int ir = i1 & i2;
        System.out.println(toBinary(ir));

        // 或 |
        i1 = binary("100");
        i2 = binary("101");
        ir = i1 | i2;
        System.out.println(toBinary(ir));
        // 异或 ^
        i1 = binary("100");
        i2 = binary("101");
        ir = i1 ^ i2;
        System.out.println(toBinary(ir));

        // 取反~
        i2 = ~binary("101");
        System.out.println(toBinary(i2));

        // 左移 <<
        int i3 = binary("10010");
        // 00001001000
        int i4 = i3 << 2;
        System.out.println(toBinary(i4));

        // 右移 >> 如果是正数，高位是补0 ，如果是负数，高位是补1
        i3 = binary("10010");
        i4 = i3 >> 2;
        System.out.println(toBinary(i4));

        // 无符号右移 >>>  无论正负，高位都是补0的
        byte b = 8; // 1000 >> 2 = 10
        System.out.println(b >> 2);
        System.out.println(b >>> 2);

        byte b2 = -8;
        System.out.println(b2 >> 2);
        System.out.println(b2 >>> 2);
        System.out.println(toBinary(b2 >> 2));
        System.out.println(toBinary(b2 >>> 2));

        // 原码：高位表示符号位，其他位表示数值位数
        // 反码：在原码基础上，符号位不动，数值为取反，得到反码
        // 补码：在反码的基础上+1，得到的就是原码的补码


    }

    static int binary(String binary) {
        return Integer.parseInt(binary, 2);
    }

    static String toBinary(int num) {
        return Integer.toBinaryString(num);
    }
}
