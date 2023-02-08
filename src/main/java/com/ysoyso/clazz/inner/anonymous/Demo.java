package com.ysoyso.clazz.inner.anonymous;

public class Demo {

    private Test test = new Test() {
        @Override
        public void test() {
            System.out.println("匿名内部类");
        }
    };

    private Test2 test2 = new Test2() {
        @Override
        void test() {
            System.out.println("匿名内部类2");
        }
    };

    private Test test1 = new SubTest();

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.test.test();
        demo.test1.test();
        demo.test2.test();
    }

    static class SubTest implements Test {

        @Override
        public void test() {
            System.out.println("静态内部类");
        }
    }

    abstract class Test2 {
        abstract void test();
    }
    interface Test {
        void test();
    }
}
