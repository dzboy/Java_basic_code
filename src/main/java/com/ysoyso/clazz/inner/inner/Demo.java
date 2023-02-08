package com.ysoyso.clazz.inner.inner;

public class Demo {
    Test test = new SubTest();
    Test2 test2 = new SubTest2();
    Test3 test3 = new SubTest3();

    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        Test test = demo.new Test();
        test.test();
        System.out.println(demo.title);
    }
    public class Test {
        public void test() {
            setTitle("hha");
            System.out.println("test " + title);
        }
    }

    abstract class Test2{
        abstract void test();
    }

    interface Test3 {
        void test();
    }

    class SubTest extends Test {
        @Override
        public void test() {
            super.test();
            System.out.println("sub test");
        }

        public void test(String test) {
            System.out.println(test);
        }
    }

    class SubTest2 extends Test2 {

        @Override
        void test() {
            System.out.println("test2");
        }
    }

    class SubTest3 implements Test3 {

        @Override
        public void test() {
            System.out.println("test3");
        }
    }

}
