package com.ysoyso.clazz.field;

public class FieldDemo {
    private String title;
    private static String name;

    private int num1;
    private static int num2;

    public FieldDemo() {
        name = "FieldDemo";
        title = "title";
    }

    static {
        name = "Hello";
        String name1 = "";
    }

    {
        name = "Hello";
        title = "title";
        String name1 = "";
    }

    public static void setName(String name) {
        FieldDemo.name = name;
    }

    public void setStaticName(String name1) {
        name = name1;
        title = "title";

    }
    public void func() {
        String funcName = "func";
        if ("func".equals(funcName)) {
            String funcName2 = "func2";
            funcName2 = "func2hah";
        }
        for (int i = 0; i < 100; i++) {
            funcName += i + "";
        }
    }

    class Name {
        public void setName(String name1) {
            name = name1;
            title = "title";
        }
    }

    static class Name2 {
        public static void setName(String name) {
            FieldDemo.name = name;
        }
    }

    public static void main(String[] args) {
        FieldDemo demo1 = new FieldDemo();
        FieldDemo demo2 = new FieldDemo();

        for (int i = 0; i < 5; i++) {
            demo1.num1++;
            FieldDemo.num2++;
            System.out.println("demo1.num1 = " + demo1.num1 + " demo2.num1 = " + demo2.num1 + " FieldDemo.num2 " + FieldDemo.num2);
        }
        for (int i = 0; i < 5; i++) {
            demo2.num1++;
            FieldDemo.num2++;
            System.out.println("demo1.num1 = " + demo1.num1 + " demo2.num1 = " + demo2.num1 + " FieldDemo.num2 " + FieldDemo.num2);
        }

    }


}
