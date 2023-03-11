package com.ysoyso.io.copy;

public class CloneDemo {
    public static void main(String[] args) {
        Animal animal = new Animal("小猫", 1, 5.5);
        Animal animal2 = new Animal("小猫2", 1, 5.5);
        Dog dog = new Dog("小狗D", 1, 23.2, animal);

//        Dog dog1 = dog;
//        dog1.name = "小狗E";
//        System.out.println(dog);
//        System.out.println(dog1);
//        System.out.println(dog == dog1);

        try {
            Dog cloneDog = dog.clone();
            cloneDog.name = "小狗E";
            cloneDog.friend.name = "小猫2";
            System.out.println(dog);
            System.out.println(cloneDog);

            System.out.println(cloneDog == dog);

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
