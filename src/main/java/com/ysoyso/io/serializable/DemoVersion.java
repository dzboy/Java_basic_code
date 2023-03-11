package com.ysoyso.io.serializable;

import com.ysoyso.io.FileUtils;

import java.io.*;

public class DemoVersion {
    public static void main(String[] args) {
        File file = new File("src/main/java/com/ysoyso/io/serial/Animal.dat");
        FileUtils.makeFile(file);
//        write(file);
        read(file);

    }

    private static void write(File file) {
//        Cat cat = new Cat("小猫", 5, 12.2);
        Cat cat = new Cat("小猫", 5, 12.2, "米奇");
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(cat);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read(File file) {

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Cat ani = (Cat) ois.readObject();
            System.out.println(ani);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
