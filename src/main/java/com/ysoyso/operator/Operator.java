package com.ysoyso.operator;

/**
 * <pre>
 * 算数运算符
 * + - * / %
 * 赋值运算符
 * = += -= *= /= %=
 * 自增自减
 * ++ --
 * 关系运算符
 * == != > < >= <=
 * 逻辑运算符
 * && || !
 * 三元运算符
 * ? :
 * ==============================================
 *
     运算符                           |   结合性
     ------------------------------------------
     [] . () (方法调用)                                     |   从左向右
     ! ~ ++ -- +(一元运算) -(一元运算) () (强制类型转换) new    |  从右向左
     / % *                                                 |  从左向右
     + -                                                   |  从左向右
     << >> >>>                                             |  从左向右
     < > <= >= instanceof                                  |  从左向右
     == !=                                                 |  从左向右
     &                                                     |  从左向右
     ^                                                     |  从左向右
     |                                                     |  从左向右
     &&                                                    |  从左向右
     ||                                                    |  从左向右
     ?:                                                    |  从右向左
     =                                                     |  从右向左
 * </pre>
 *
 *
 */
public class Operator {
    public static void main(String[] args) {
        // 算数运算符
        // + - * / %
        // 赋值运算符
        // = += -= *= /= %=
        // 自增自减
        // ++ --
        // 关系运算符
        // == != > < >= <=
        // 逻辑运算符
        // && || !
        // 三元运算符
        // ? :
        int[] i = {4, 8, 16};
        String str = "abc";
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = 5;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(b * c);
        System.out.println(d / b);
        System.out.println(e % d);

        int y = 5;
        System.out.println(y);
        int z = 5;
        z += 5;
        // z = z + 5;
        System.out.println(z);

        int x = 5;
//        x++;
//        // x = x + 1;
//        System.out.println(x);
//        ++x;
//        System.out.println(x);

//        System.out.println(5 == x++);
//        System.out.println(5 == ++x);
//        System.out.println(a == b);
//        System.out.println(x == e);
//        System.out.println(a != b);
//        System.out.println(a > b);
//        System.out.println(a < b);
//        System.out.println(2 >= 2);

        System.out.println(a > b && a > c);
        System.out.println(a < b && a < c);
        System.out.println(a > b && a < c);
        System.out.println(a > b || a > c);
        System.out.println(a > b || a < c);
        System.out.println(a < b || a < c);
        System.out.println(!(a > b));
        System.out.println(!(a < b));

        x = a < b ? 3 : 2;
        // 变量 = 条件 ? 真 : 假
        System.out.println(x);


        System.out.println(a > b ? 0 : 100 + 1);
        // 100 + 1  101
        // a > b ? 0 : 101
        System.out.println(a > b || b == a + 1 && c != d);
        /*
         System.out.println(a > b || b == a + 1 && c != d);
         a > b || b == 2 && c != d
         false || b == 2 && c != d
         false || true && true
         false || true
         true
         */
        x = ~(a + b) * str.length() + (i[2] >> 1 + 2);
        /*
         x = ~(a + b) * str.length() + (i[2] >> 1 + 2);
         x = ~3 * 3 + (i[2] >> 3)
         x = ~3 * 3 + 2
         x = -4 * 3 + 2
         x = -12 + 2
         x = -10
         */
        System.out.println(x);

    }
}
