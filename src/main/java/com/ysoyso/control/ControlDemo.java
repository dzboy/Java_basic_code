package com.ysoyso.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 分支
 * - if() {}
 * - if() {} else {}
 * - if() {} else if() {}
 * - switch() case: break; default:
 * 循环
 * - while
 * - do while
 * - for
 * - continue
 * - break
 */
public class ControlDemo {

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("请输入第一个数值");
            String num1 = read();
            if ("q".equals(num1)) {
                break;
            }
            System.out.println("请输入操作符");
            String op = read();
            System.out.println("请输入第二个数值");
            String num2 = read();
            int i1;
            int i2;
            try {
                i1 = Integer.parseInt(num1);
                i2 = Integer.parseInt(num2);
            } catch (NumberFormatException e) {
                System.out.println("输入的不是数字");
                continue;
            }
            int result;
            switch (op) {
                case "+":
                    result = i1 + i2;
                    break;
                case "-":
                    result = i1 - i2;
                    break;
                case "*":
                    result = i1 * i2;
                    break;
                case "/":
                    result = i1 / i2;
                    break;
                default:
                    System.out.println("输入的不是+、-、*、/中的任意一个");
                    continue;
            }
            System.out.println(num1 + op + num2 + "=" + result);
        }
    }

    public static String read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
    public static void demo() {

//        String str = read();
//        System.out.println("1".equals(str));
//        if ("1".equals(str)) {
//            System.out.println("输入了1");
//        } else if ("2".equals(str)){
//            System.out.println("输入了2");
//        } else if ("3".equals(str)) {
//            System.out.println("输入了3");
//        } else {
//            System.out.println("输入了未知数");
//        }
//        switch (str) {
//            case "1":
//            case "2":
//            case "3":
//                System.out.println("输入了1或2或3");
//                break;
//            default:
//                System.out.println("输入了未知数");
//
//        }

//        if ("1".equals(str) || "2".equals(str) || "3".equals(str)) {
//            System.out.println("输入了1或2或3");
//        } else {
//            System.out.println("输入了未知数");
//        }

//        while ("1".equals(str)) {
//            System.out.println("输入了1");
//            break;
//        }

//        int i = 0;
//        while (i < 10) {
//            if (i < 5) {
//                i++;
//                System.out.println("在if中 i = " + i);
//                continue;
//            }
//            System.out.println("i = " + i);
//            i++; // i = i+1;
//        }

//        int i = 0;
//        do {
//            System.out.println("i = " + i);
//            i++;
//        } while (i < 10);

//        for(int i = 0; i < 10; i++) {
//            System.out.println("i = " + i);
//        }

//        for (int i = 0; i < 10; ) {
//            System.out.println("i = " + i);
//        }

//        int i = 0;
//        for (; i < 10; ) {
//            System.out.println("i = " + i);
//            i++;
//        }

//        for (int i = 0, j = 0; i < 10 && j < 20; i++, j += 3) {
//            // j = j + 3
//            System.out.println(" i = " + i + " j = " + j);
//        }

//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(i + "");
//        }
//        System.out.println(list);
//        for (String str : list) {
//            if ("3".equals(str)) {
//                break;
//            }
//            System.out.println(str);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            String str = list.get(i);
//            System.out.println(str);
//        }
    }

}
