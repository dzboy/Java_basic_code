package com.ysoyso.io.copy;

import com.ysoyso.io.FileUtils;

import java.io.*;

public class ConstantsDemo {
    public static void main(String[] args) {
        File file = new File("src/main/java/com/ysoyso/io/color/Color.dat");
        FileUtils.makeFile(file);

        Color red = Color.RED;
        System.out.println(red == Color.RED);
        System.out.println(red.value + " " + Color.RED.value);

        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(red);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Color r = (Color) ois.readObject();
            System.out.println(r.value + " " + red.value);
            System.out.println(r == red);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
