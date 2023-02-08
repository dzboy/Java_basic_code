package com.ysoyso.clazz.inner.part;

public class Demo {

    public void print() {
        class Test {
            public void test() {
                System.out.println("test");
            }
        }
        Test test = new Test();
        test.test();
    }


    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.print();
    }
}
