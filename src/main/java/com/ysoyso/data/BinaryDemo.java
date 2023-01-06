package com.ysoyso.data;

/**
 * 解释进制<br />
 * <ul>
 *     <li>2进制、8进制、16进制</li>
 *     <li>2、8、16进制转10进制</li>
 *     <li>2进制运算、常见用法</li>
 *     <li>计算机的原码、反码、补码</li>
 *     <li>byte的取值范围原理</li>
 * </ul>
 *
 */
public class BinaryDemo {
    public static void main(String[] args) {
        // 0 1 2 3 4 5 6 7 8 9
        // 10 11 12...
        // 100 101 102..

        // 0 1
        // 10 11
        // 100 101

        // 0 1 2 3 4 5 6 7
        // 10 11..17

        // 0..9 A B C D E F
        // 10...1F...FF

        int i1 = 0b0001; // 0B0001;
        int i2 = 020; // 020
        int i3 = 0x1F;// 0X1F; 0x1F
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);

        // 2进制转10进制
        byte b1 = 0b0101;
        // 1 * 2^0 + 0 * 2^1 + 1 * 2^2 + 0 * 2^3 = 1 + 0 + 4 + 0 = 5
        System.out.println(b1);
        // 8进制转10进制
        int i4 = 00302;
        // 2 * 8 ^ 0 + 0 * 8 ^ 1 + 3 * 8 ^ 2 + 0 * 8 ^ 3 = 2 + 0 + 192 + 0 = 194
        System.out.println(i4);

        // 与 &
        int i5 = 0b0101;
        int i6 = 0b0101;
        int i7 = i5 & i6;
        // 101
        System.out.println(i7);
        System.out.println(Integer.toBinaryString(i7));

        // 或 |
        i5 = 0b0101;
        i6 = 0b1000;
        i7 = i5 | i6;
        // 1101
        System.out.println(i7);
        System.out.println(Integer.toBinaryString(i7));

        // 异或 ^
        i5 = 0b0111;
        i6 = 0b0100;
        i7 = i5 ^ i6;
        // 0011
        System.out.println(i7);
        System.out.println(Integer.toBinaryString(i7));
        // 按位取反 ~
        i5 = 0b00000000000000000000000000000101;
        i7 = ~ i5;
        // 11111111111111111111111111111010
        // 10000000000000000000000000000101
        // 10000000000000000000000000000110
        System.out.println(i7);
        System.out.println(Integer.toBinaryString(i7));
        System.out.println(-0b110);
        // 左移 <<
        i5 = 0b001000;
        i7 = i5 << 2;
        // 100000
        System.out.println(Integer.toBinaryString(i7));
        // 右移 如果是正数，右移最高位补0，如果是负数，右移最高位补1
        i5 = 0b001000;
        i7 = i5 >> 2;
        // 000010
        System.out.println(Integer.toBinaryString(i7));
        // 无符号右移 >>> 最高位补0
        i5 = -0b110;
        //11111111111111111111111111111010
        System.out.println(i5);
        System.out.println(Integer.toBinaryString(i5));
        i7 = i5 >> 2;
        //11111111111111111111111111111110
        System.out.println(Integer.toBinaryString(i7));
        i7 = i5 >>> 2;
        //111111111111111111111111111110
        System.out.println(Integer.toBinaryString(i7));

        // 100 - 10 = 90
        // 100 + (-10) = 90
        // 原码：高位表示符号，其他位表示数值
        // 反码：如果是正数，反码就是原码，如果是负数的话，符号位不变，数值位取反
        // 补码：如果是正数，原码就是补码，如果是负数，在反码的基础上+1得到就是补码

        i5 = 0b110;
        i6 = -0b110;
        System.out.println(i5);
        System.out.println(Integer.toBinaryString(i5));
        System.out.println(i6);
        System.out.println(Integer.toBinaryString(i6));
        // 10000000000000000000000000000110
        // 11111111111111111111111111111001
        // 11111111111111111111111111111010

        // 00000000000000000000000000000110
        // 11111111111111111111111111111010
        // 00000000000000000000000000000000
        System.out.println(i5 + i6);

        byte b0 = 0;
        // 8bit 00000000
        // 2^8 = 256
        // -128 ~ 127
        // 01111111  127
        // 11111111 -127
        // 00000000  0
        // 10000000  -0
        // 10000000  -128



    }

}
