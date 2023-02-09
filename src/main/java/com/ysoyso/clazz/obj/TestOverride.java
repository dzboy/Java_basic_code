package com.ysoyso.clazz.obj;

import com.ysoyso.clazz.obj.simple.Child;
import com.ysoyso.clazz.obj.simple.Parent;
import com.ysoyso.clazz.obj.simple.Toy;

public class TestOverride {
    public static void main(String[] args) {
        Parent p1 = new Parent();
        p1.setAge(10);
        p1.setName("he");
        System.out.println(p1);
        System.out.println(p1.toString());
    }

    private void test4() {
        Toy t1 = new Toy();
        t1.setName("小玩具");
        t1.setWeight(100);

        Toy t2 = new Toy();
        t2.setName("小玩具");
        t2.setWeight(100);

        Child p1 = new Child();
        p1.setAge(10);
        p1.setName("he");
        p1.setToy(t1);

        Child p2 = new Child();
        p2.setAge(10);
        p2.setName("he");
        p2.setToy(t2);
        System.out.println(p1.hashCode() == p2.hashCode());
        System.out.println(p1.equals(p2));
    }

    private void test3() {
        Parent p1 = new Parent();
        p1.setAge(10);
        p1.setName("he");
        Parent p2 = new Parent();
        p2.setAge(10);
        p2.setName("he");
        System.out.println(p1.hashCode() == p2.hashCode());
        System.out.println(p1.equals(p2));
    }

    private void test2() {
        Child child = new Child();
        child.setAge(10);

        Parent parent = new Parent();
        parent.setAge(10);

        System.out.println(child.equals(parent));
        System.out.println(parent.equals(child));
    }

    private void test1() {

        Toy t1 = new Toy();
        t1.setName("小玩具");
        t1.setWeight(100);

        Toy t2 = new Toy();
        t2.setName("小玩具");
        t2.setWeight(100);

        Child p1 = new Child();
        p1.setAge(10);
        p1.setName("he");
        p1.setToy(t1);
        Child p2 = new Child();
        p2.setAge(10);
        p2.setName("he");
        p2.setToy(t2);
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
    }

    private void test() {
        Child child = new Child();
        Parent parent = new Parent();
        System.out.println(child instanceof Child);
        System.out.println(child instanceof Parent);
        System.out.println("----------------");
        System.out.println(parent instanceof Parent);
        System.out.println(parent instanceof Child);

        Class<?> clazz = child.getClass();
        System.out.println(clazz);
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());

        System.out.println(parent.getClass());
    }
}
