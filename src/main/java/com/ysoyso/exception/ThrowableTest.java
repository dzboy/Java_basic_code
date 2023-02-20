package com.ysoyso.exception;

public class ThrowableTest {

    public static void main(String[] args) {
        Person person = null;
        if (null != person) {
            person.setAge(10);
        }

    }

    static class Person {
        int age;

        public void setAge(int age) {
            this.age = age;
            System.out.println("年龄是 " + age);
        }
    }

}
