package com.ysoyso.clazz.animal;

import com.ysoyso.clazz.animal.animal.Animal;
import com.ysoyso.clazz.animal.animal.Cat;
import com.ysoyso.clazz.animal.animal.Dog;
import com.ysoyso.clazz.animal.house.CatHouse;
import com.ysoyso.clazz.animal.house.DogHouse;
import com.ysoyso.clazz.animal.house.House;

public class MethodDemo {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal cat = new Cat();
        Dog dog = new Dog();

        House house = new House();
        CatHouse catHouse = new CatHouse();
        DogHouse dogHouse = new DogHouse();

        animal.goHome(house);
        animal.goHome(catHouse);
        animal.goHome(dogHouse);

        cat.goHome(house);
        cat.goHome(catHouse);
        cat.goHome(dogHouse);

        dog.goHome(house);
        dog.goHome(catHouse);
        dog.goHome(dogHouse);

    }
}
