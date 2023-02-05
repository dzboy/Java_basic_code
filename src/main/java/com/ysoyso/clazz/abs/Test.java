package com.ysoyso.clazz.abs;

public class Test {
    public static void main(String[] args) {
        Person men = new Men();
        Person women = new Women();
        men.age = 22;
        women.age = 20;

        men.say();
        men.run();
        women.say();
        women.run();

    }
}
