package com.ysoyso.io.serializable;

import com.ysoyso.io.FileUtils;

import java.io.*;
import java.util.Arrays;

public class DemoMember {
    public static void main(String[] args) {
        File file = new File("src/main/java/com/ysoyso/io/serial/Animal.dat");
        FileUtils.makeFile(file);

        Animal animal = new Animal("小猫", 5, 12.2);
        Dog dogD = new Dog("D", 3, 12.1, animal);
        Dog dogE = new Dog("E", 4, 13.2, animal);
        Animal[] animals = new Animal[]{animal, dogE, dogD};

        System.out.println(dogD.friend == dogE.friend);

        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(animals);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Animal[] anis = (Animal[]) ois.readObject();
            System.out.println(Arrays.toString(anis));
            Dog dogE1 = (Dog) anis[1];
            Dog dogD1 = (Dog) anis[2];
            System.out.println(dogD1.friend == dogE1.friend);

            Animal ani1 = anis[0];
            System.out.println(ani1 == animal);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
