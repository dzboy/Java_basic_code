package com.ysoyso.io.serializable;

import com.ysoyso.io.FileUtils;

import java.io.*;
import java.util.Arrays;

public class DemoSimple {
    public static void main(String[] args) {
        File file = new File("src/main/java/com/ysoyso/io/serial/Animal.dat");
        FileUtils.makeFile(file);

        Animal animal = new Animal("小猫1", 5, 12.2);

        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(animal);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Animal ani = (Animal) ois.readObject();
            System.out.println(ani);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
