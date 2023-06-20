package com.ysoyso.annotation.pkg;

@TestAnnotation
public class AnnoTest implements Test{

    @TestAnnotation
    private int count;

    @TestAnnotation
    @Override
    public void test() {

    }

    @Deprecated
    public void demo() {
        PACKAGE_CLASS packageClass = new PACKAGE_CLASS();
        packageClass.test();
    }

    public static void main(String[] args) {
        AnnoTest test = new AnnoTest();
        test.demo();
    }
}
