package com.ysoyso.clazz.animal;

import com.ysoyso.clazz.animal.animal.*;
import com.ysoyso.clazz.animal.animal.base.Creature;
import com.ysoyso.clazz.animal.animal.base.Living;

public class Demo {
    public static void main(String[] args) {
        Creature cat = new Cat();
        Animal rabbit = new Rabbit();
        Dog dog = new Dog();
        Bird bird = new Bird();

        System.out.println(cat instanceof Creature);
        System.out.println(cat instanceof Animal);
        System.out.println(cat instanceof Cat);

        System.out.println(cat instanceof Dog);
        System.out.println(cat instanceof Rabbit);

        System.out.println(dog instanceof Creature);
        System.out.println(dog instanceof Animal);
        System.out.println(dog instanceof Dog);
        System.out.println(dog instanceof Living);


    }
}
