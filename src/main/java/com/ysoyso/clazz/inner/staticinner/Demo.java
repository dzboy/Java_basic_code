package com.ysoyso.clazz.inner.staticinner;

public class Demo {

    private Test test = new Test();
    private Test2 test2 = new SubTest2();
    private String title;

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.test.test();
        demo.test2.test();

        Test test1 = new Test();

    }
    static class Test {
        public void test() {
            System.out.println("Test 静态内部类方法 ");
        }
    }

    static interface Test2 {
        void test();
    }

    static class SubTest2 implements Test2 {

        @Override
        public void test() {
            System.out.println("SubTest2 静态内部类方法");
        }
    }
}
