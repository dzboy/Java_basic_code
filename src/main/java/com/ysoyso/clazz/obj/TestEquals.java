package com.ysoyso.clazz.obj;

public class TestEquals {
    public static void main(String[] args) {
        String a = "test";
        String b = "test";
        System.out.println(a.equals(b));
        System.out.println(a == b);

        String a1 = new String("test1");
        String b1 = new String("test1");
        System.out.println(a1.equals(b1));
        System.out.println(a1 == b1);

    }
}
