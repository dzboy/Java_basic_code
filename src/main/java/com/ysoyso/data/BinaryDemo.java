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
        // 0 0 0 0 2^n
        // 与、或、异或、取反、左移、右移、无符号右移
        // 有符号、无符号、正数、负数
        int i = 111;

        int result = binary("1000") >>> 1;
        System.out.println(binary("1000") + " " + result);
        System.out.println(toBinary(result));

        System.out.println(Integer.parseInt("1010", 2));
        System.out.println(Math.pow(2, 64));
    }

    static int binary(String binary) {
        return Integer.parseInt(binary, 2);
    }

    static String toBinary(int num) {
        return Integer.toBinaryString(num);
    }
}
