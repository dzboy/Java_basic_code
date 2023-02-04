package com.ysoyso.clazz.animal.animal;

import com.ysoyso.clazz.animal.animal.base.Creature;
import com.ysoyso.clazz.animal.house.CatHouse;
import com.ysoyso.clazz.animal.house.DogHouse;
import com.ysoyso.clazz.animal.house.House;

public class Animal extends Creature {

    public Animal() {
        name = "Animal";
    }

    public void goHome(House house) {
        System.out.println(name + " go to the House");
    }

    public void goHome(CatHouse house) {
        System.out.println(name + " go to the CatHouse");
    }

    public void goHome(DogHouse house) {
        System.out.println(name + " go to the DogHouse");
    }

    public void run() {
        System.out.println(name + " run");
    }
}
