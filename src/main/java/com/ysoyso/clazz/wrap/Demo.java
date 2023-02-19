package com.ysoyso.clazz.wrap;

public class Demo {
    public static void main(String[] args) {
//        Byte b;
//        Short s;
//        Integer i;
//        Long l;
//        Character c;
//        Float f;
//        Double d;
//        Boolean bool;

        int int0 = 1;
        Integer int1 = 2; // Integer.valueOf(2);

        float f = 3F;
        Float f1 = 4F;

        char c = 'c';
        Character character = 'c';

        int int2 = 5 + int1; // 5 + int1.intValue();
        Integer int3 = 6 + int1; // Integer.valueOf(6 + int1.intValue())
        int1 = null;

//        Integer int4 = Integer.valueOf(7);
//        int int5 = int4.intValue();

        // Integer、Short、Long -128~127 Character 0 ~ 127

        Integer int6 = 127;
        Integer int7 = 127;
        Integer int8 = 128;
        Integer int9 = 129;

        System.out.println(int6 == int7);
        System.out.println(int8 == int9);
        System.out.println(int8.intValue() == int9.intValue());
        System.out.println(int8.compareTo(int9));



        // new出来的Integer，相当于把new出来的地址作比较
        Integer i0 = new Integer(1);
        Integer i1 = new Integer(1);
        System.out.println("Integer 对象作比较 i0 == i1: " + (i0 == i1));

        // 手动拆项
        System.out.println("使用intValue得到int值作比较 i0 == i1: " + (i0.intValue() == i1.intValue()));

        // 自动拆箱成int类型
        int i2 = 1;
        System.out.println("将Integer自动拆箱 i1 == i2: " + (i1 == i2));

        // 自动装箱，如果在-128到127之间，则值存在常量池中、内存地址的比较
        Integer i3 = 30;
        Integer i4 = 30;
        System.out.println("Integer对象赋值比较 i3 == i4: " + (i3 == i4));

        // Integer对象赋值(超过-128~127区间)比较
        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println("Integer对象赋值(超过-128~127区间)比较 i5 == i6: " + (i5 == i6));

        // Integer对象赋值(超过-128~127区间)比较,调用intValue后再作比较
        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println("Integer对象赋值(超过-128~127区间)比较,调用intValue后 i7 == i8: " + (i7.intValue() == i8.intValue()));

        // 使用Integer类的equals()方法进行的是数值的比较
        Integer i9 = 129;
        Integer i10 = 129;
        System.out.println("Integer类的equals()方法进行的是数值的比较 i9 == i10: " + i9.equals(i10));

    }
}
